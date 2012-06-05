/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamento.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Fabiano
 */
@Entity
public class Contrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date emissao;
    
    @ManyToOne
    private Cliente cliente;
    
    private double total;
    
    @OneToMany(mappedBy = "contrato")
    private List<Item>itens = new ArrayList<Item>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> Itens) {
        this.itens = Itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gerenciamento.model.Contrato[ id=" + id + " ]";
    }
    
    private void addItem(Item item){
        if(!itens.contains(item)){
            item.setContrato(this);
            itens.add(item);
        }
            
    }
    
    private void removeItem(Item item){
        if(itens.contains(item)){
            item.setContrato(null);
            itens.remove(item);
        }
    }
    
}
