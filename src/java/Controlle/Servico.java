/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlle;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AUGUSTO
 */
@Entity
@Table(name = "servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s")
    , @NamedQuery(name = "Servico.findByCodigoServico", query = "SELECT s FROM Servico s WHERE s.codigoServico = :codigoServico")
    , @NamedQuery(name = "Servico.findByNomeServico", query = "SELECT s FROM Servico s WHERE s.nomeServico = :nomeServico")
    , @NamedQuery(name = "Servico.findByDescricao", query = "SELECT s FROM Servico s WHERE s.descricao = :descricao")})
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoServico")
    private Integer codigoServico;
    @Size(max = 45)
    @Column(name = "nome_servico")
    private String nomeServico;
    @Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
    @ManyToMany(mappedBy = "servicoCollection")
    private Collection<Agendamento> agendamentoCollection;
    @JoinColumn(name = "ControleEstoque_idProduto", referencedColumnName = "codigoProduto")
    @ManyToOne(optional = false)
    private Controleestoque controleEstoqueidProduto;

    public Servico() {
    }

    public Servico(Integer codigoServico) {
        this.codigoServico = codigoServico;
    }

    public Integer getCodigoServico() {
        return codigoServico;
    }

    public void setCodigoServico(Integer codigoServico) {
        this.codigoServico = codigoServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Agendamento> getAgendamentoCollection() {
        return agendamentoCollection;
    }

    public void setAgendamentoCollection(Collection<Agendamento> agendamentoCollection) {
        this.agendamentoCollection = agendamentoCollection;
    }

    public Controleestoque getControleEstoqueidProduto() {
        return controleEstoqueidProduto;
    }

    public void setControleEstoqueidProduto(Controleestoque controleEstoqueidProduto) {
        this.controleEstoqueidProduto = controleEstoqueidProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoServico != null ? codigoServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.codigoServico == null && other.codigoServico != null) || (this.codigoServico != null && !this.codigoServico.equals(other.codigoServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controlle.Servico[ codigoServico=" + codigoServico + " ]";
    }
    
}
