/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamento.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.persistence.*;

/**
 *
 * @author Fabiano
 */
@Entity
public class Item implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="itemKey")
    @SequenceGenerator(name="itemKey", allocationSize=1)
    private Long id;
    
    @ManyToOne
    private Contrato contrato;
    
    @ManyToOne
    private Produto produto;
    
    private BigDecimal quantidade = new BigDecimal("0.0");
    
    private BigDecimal valorUnitario = new BigDecimal("0.0");
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    public BigDecimal getValorTotal(){
        return this.quantidade.multiply(this.getValorUnitario()).setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.produto != other.produto && (this.produto == null || !this.produto.equals(other.produto))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 71 * hash + (this.produto != null ? this.produto.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "com.gerenciamento.model.Item[ id=" + id + " ]";
    }
}
