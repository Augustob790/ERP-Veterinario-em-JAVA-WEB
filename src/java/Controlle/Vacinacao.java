/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlle;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AUGUSTO
 */
@Entity
@Table(name = "vacinacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacinacao.findAll", query = "SELECT v FROM Vacinacao v")
    , @NamedQuery(name = "Vacinacao.findByCodigoVacinacao", query = "SELECT v FROM Vacinacao v WHERE v.codigoVacinacao = :codigoVacinacao")
    , @NamedQuery(name = "Vacinacao.findByNomeVacina", query = "SELECT v FROM Vacinacao v WHERE v.nomeVacina = :nomeVacina")
    , @NamedQuery(name = "Vacinacao.findByDataValidade", query = "SELECT v FROM Vacinacao v WHERE v.dataValidade = :dataValidade")
    , @NamedQuery(name = "Vacinacao.findByDescricaoVacina", query = "SELECT v FROM Vacinacao v WHERE v.descricaoVacina = :descricaoVacina")})
public class Vacinacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoVacinacao")
    private Integer codigoVacinacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome_vacina")
    private String nomeVacina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_validade")
    @Temporal(TemporalType.DATE)
    private Date dataValidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao_vacina")
    private String descricaoVacina;
    @JoinColumn(name = "Animais_idAnimais", referencedColumnName = "codigoAnimais")
    @ManyToOne(optional = false)
    private Animais animaisidAnimais;

    public Vacinacao() {
    }

    public Vacinacao(Integer codigoVacinacao) {
        this.codigoVacinacao = codigoVacinacao;
    }

    public Vacinacao(Integer codigoVacinacao, String nomeVacina, Date dataValidade, String descricaoVacina) {
        this.codigoVacinacao = codigoVacinacao;
        this.nomeVacina = nomeVacina;
        this.dataValidade = dataValidade;
        this.descricaoVacina = descricaoVacina;
    }

    public Integer getCodigoVacinacao() {
        return codigoVacinacao;
    }

    public void setCodigoVacinacao(Integer codigoVacinacao) {
        this.codigoVacinacao = codigoVacinacao;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getDescricaoVacina() {
        return descricaoVacina;
    }

    public void setDescricaoVacina(String descricaoVacina) {
        this.descricaoVacina = descricaoVacina;
    }

    public Animais getAnimaisidAnimais() {
        return animaisidAnimais;
    }

    public void setAnimaisidAnimais(Animais animaisidAnimais) {
        this.animaisidAnimais = animaisidAnimais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoVacinacao != null ? codigoVacinacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacinacao)) {
            return false;
        }
        Vacinacao other = (Vacinacao) object;
        if ((this.codigoVacinacao == null && other.codigoVacinacao != null) || (this.codigoVacinacao != null && !this.codigoVacinacao.equals(other.codigoVacinacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controlle.Vacinacao[ codigoVacinacao=" + codigoVacinacao + " ]";
    }
    
}
