
package Beans;

import Controlle.Vacinacao;
import DAO.VacinacaoDao;
import Util.JSFUtil;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "MBVacinacao")
@ViewScoped
public class VacinacaoBean implements Serializable {
    //Variaveis
    private Vacinacao vacinacao;

    private ArrayList<Vacinacao> itens;
    private ArrayList<Vacinacao> itensFiltrados;
    private String acao;
    private Long codigo;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Vacinacao getVacinacao() {
        if (vacinacao == null) {
            vacinacao = new Vacinacao();
        }
        return vacinacao;
    }

    //
    public void setVacinacao(Vacinacao vacinacao) {
        this.vacinacao = vacinacao;
    }

    public ArrayList<Vacinacao> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Vacinacao> itens) {
        this.itens = itens;
    }

    public ArrayList<Vacinacao> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Vacinacao> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }

    //@PostConstruct
    public void prepararPesquisa() {

        try {
            VacinacaoDao fdao = new VacinacaoDao();
            itens = (ArrayList<Vacinacao>) fdao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }

//Metodo para carregar Cadastro
public void carregarCadastro() {

        try {

            if (codigo != null) {

                VacinacaoDao fdao = new VacinacaoDao();

                vacinacao = fdao.buscarCodigo(codigo);

            } else {
                vacinacao = new Vacinacao();

            }
        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
    
    //novo cadastro
    public void novo() {
        vacinacao = new Vacinacao();
    }
    
    //metodo salvar
    public void salvar() {

        try {
            VacinacaoDao fdao = new VacinacaoDao();
            fdao.Salvar(vacinacao);

            vacinacao = new Vacinacao();

            JSFUtil.AdicionarMensagemSucesso("Vacinação salvo com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }
    //metodo de excluir
    public void excluir() {
        try {
            VacinacaoDao fdao = new VacinacaoDao();
            fdao.Excluir(vacinacao);

            JSFUtil.AdicionarMensagemSucesso("Vacinação excluido com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("Não é possível excluir um vacinação que tenha uma venda associado!");
            e.printStackTrace();
        }
    }
//    metodo de editar
    public void editar() {
        try {
            VacinacaoDao fdao = new VacinacaoDao();
            fdao.Atualizar(vacinacao);

            JSFUtil.AdicionarMensagemSucesso("Vacinação editado com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }

}
