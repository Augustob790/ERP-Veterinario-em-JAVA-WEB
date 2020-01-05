/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlle;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AUGUSTO
 */
@Entity
@Table(name = "agendamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agendamento.findAll", query = "SELECT a FROM Agendamento a")
    , @NamedQuery(name = "Agendamento.findByCodigoAgendamento", query = "SELECT a FROM Agendamento a WHERE a.codigoAgendamento = :codigoAgendamento")
    , @NamedQuery(name = "Agendamento.findByDataAgenda", query = "SELECT a FROM Agendamento a WHERE a.dataAgenda = :dataAgenda")
    , @NamedQuery(name = "Agendamento.findByDescricaoAgendamento", query = "SELECT a FROM Agendamento a WHERE a.descricaoAgendamento = :descricaoAgendamento")})
public class Agendamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoAgendamento")
    private Integer codigoAgendamento;
    @Column(name = "data_agenda")
    @Temporal(TemporalType.DATE)
    private Date dataAgenda;
    @Size(max = 45)
    @Column(name = "descricao_agendamento")
    private String descricaoAgendamento;
    @JoinTable(name = "agendamento_do_servico", joinColumns = {
        @JoinColumn(name = "Agendamento_idAgendamento", referencedColumnName = "codigoAgendamento")}, inverseJoinColumns = {
        @JoinColumn(name = "Servico_idServico", referencedColumnName = "codigoServico")})
    @ManyToMany
    private Collection<Servico> servicoCollection;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "codigoCliente")
    @ManyToOne(optional = false)
    private Cliente clienteidCliente;
    @JoinColumn(name = "Funcionario_idFuncionario", referencedColumnName = "codigoFuncionario")
    @ManyToOne(optional = false)
    private Funcionario funcionarioidFuncionario;

    public Agendamento() {
    }

    public Agendamento(Integer codigoAgendamento) {
        this.codigoAgendamento = codigoAgendamento;
    }

    public Integer getCodigoAgendamento() {
        return codigoAgendamento;
    }

    public void setCodigoAgendamento(Integer codigoAgendamento) {
        this.codigoAgendamento = codigoAgendamento;
    }

    public Date getDataAgenda() {
        return dataAgenda;
    }

    public void setDataAgenda(Date dataAgenda) {
        this.dataAgenda = dataAgenda;
    }

    public String getDescricaoAgendamento() {
        return descricaoAgendamento;
    }

    public void setDescricaoAgendamento(String descricaoAgendamento) {
        this.descricaoAgendamento = descricaoAgendamento;
    }

    @XmlTransient
    public Collection<Servico> getServicoCollection() {
        return servicoCollection;
    }

    public void setServicoCollection(Collection<Servico> servicoCollection) {
        this.servicoCollection = servicoCollection;
    }

    public Cliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Cliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    public Funcionario getFuncionarioidFuncionario() {
        return funcionarioidFuncionario;
    }

    public void setFuncionarioidFuncionario(Funcionario funcionarioidFuncionario) {
        this.funcionarioidFuncionario = funcionarioidFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAgendamento != null ? codigoAgendamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agendamento)) {
            return false;
        }
        Agendamento other = (Agendamento) object;
        if ((this.codigoAgendamento == null && other.codigoAgendamento != null) || (this.codigoAgendamento != null && !this.codigoAgendamento.equals(other.codigoAgendamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controlle.Agendamento[ codigoAgendamento=" + codigoAgendamento + " ]";
    }
    
}
