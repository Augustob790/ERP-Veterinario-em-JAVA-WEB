/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlle;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AUGUSTO
 */
@Entity
@Table(name = "animais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animais.findAll", query = "SELECT a FROM Animais a")
    , @NamedQuery(name = "Animais.findByCodigoAnimais", query = "SELECT a FROM Animais a WHERE a.codigoAnimais = :codigoAnimais")
    , @NamedQuery(name = "Animais.findByNome", query = "SELECT a FROM Animais a WHERE a.nome = :nome")
    , @NamedQuery(name = "Animais.findByIdade", query = "SELECT a FROM Animais a WHERE a.idade = :idade")
    , @NamedQuery(name = "Animais.findByPeso", query = "SELECT a FROM Animais a WHERE a.peso = :peso")
    , @NamedQuery(name = "Animais.findByEspecie", query = "SELECT a FROM Animais a WHERE a.especie = :especie")})
public class Animais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoAnimais")
    private Integer codigoAnimais;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "idade")
    private String idade;
    @Size(max = 45)
    @Column(name = "peso")
    private String peso;
    @Size(max = 45)
    @Column(name = "especie")
    private String especie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animaisidAnimais")
    private Collection<Vacinacao> vacinacaoCollection;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "codigoCliente")
    @ManyToOne(optional = false)
    private Cliente clienteidCliente;

    public Animais() {
    }

    public Animais(Integer codigoAnimais) {
        this.codigoAnimais = codigoAnimais;
    }

    public Integer getCodigoAnimais() {
        return codigoAnimais;
    }

    public void setCodigoAnimais(Integer codigoAnimais) {
        this.codigoAnimais = codigoAnimais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @XmlTransient
    public Collection<Vacinacao> getVacinacaoCollection() {
        return vacinacaoCollection;
    }

    public void setVacinacaoCollection(Collection<Vacinacao> vacinacaoCollection) {
        this.vacinacaoCollection = vacinacaoCollection;
    }

    public Cliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Cliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAnimais != null ? codigoAnimais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animais)) {
            return false;
        }
        Animais other = (Animais) object;
        if ((this.codigoAnimais == null && other.codigoAnimais != null) || (this.codigoAnimais != null && !this.codigoAnimais.equals(other.codigoAnimais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controlle.Animais[ codigoAnimais=" + codigoAnimais + " ]";
    }
    
}
