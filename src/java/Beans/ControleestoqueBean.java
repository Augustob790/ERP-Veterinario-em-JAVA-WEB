
package Beans;

import Controlle.Controleestoque;
import DAO.ControleEstoqueDao;
import Util.JSFUtil;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



@ManagedBean(name = "MBControleestoque")
@ViewScoped
public class ControleestoqueBean implements Serializable {
//Variaveis
    private Controleestoque controleestoque;

    private ArrayList<Controleestoque> itens;
    private ArrayList<Controleestoque> itensFiltrados;
    
    private String acao;
    private Long codigo;
//getters e setters
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

    public Controleestoque getControleestoque() {
       if (controleestoque == null) {
            controleestoque = new Controleestoque();
        }
        return controleestoque;
    }

    //
    public void setControleestoque(Controleestoque controleestoque) {
        this.controleestoque = controleestoque;
    }

    public ArrayList<Controleestoque> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Controleestoque> itens) {
        this.itens = itens;
    }

    public ArrayList<Controleestoque> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Controleestoque> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }
//metodo de pesquisar
    //@PostConstruct
    public void prepararPesquisa() {

        try {
            ControleEstoqueDao fdao = new ControleEstoqueDao();
            itens = (ArrayList<Controleestoque>) fdao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo de carregar cadastro
   public void carregarCadastro() {

        try {

            if (codigo != null) {

                ControleEstoqueDao fdao = new ControleEstoqueDao();

                controleestoque = fdao.buscarCodigo(codigo);

            } else {
                controleestoque = new Controleestoque();

            }
        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo de excluir produtos
    public void novo() {
        controleestoque = new Controleestoque();
    }
//metodo de salvar produto
    public void salvar() {

        try {
            ControleEstoqueDao fdao = new ControleEstoqueDao();
            fdao.Salvar(controleestoque);

            controleestoque = new Controleestoque();

            JSFUtil.AdicionarMensagemSucesso("Produto salvo com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }
//metodo de excluir produto
    public void excluir() {
        try {
            ControleEstoqueDao fdao = new ControleEstoqueDao();
            fdao.Excluir(controleestoque);

            JSFUtil.AdicionarMensagemSucesso("Produto excluido com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("Não é possível excluir um produto que tenha uma venda associado!");
            e.printStackTrace();
        }
    }
//metodo de editar produto
    public void editar() {
        try {
            ControleEstoqueDao fdao = new ControleEstoqueDao();
            fdao.Atualizar(controleestoque);

            JSFUtil.AdicionarMensagemSucesso("Produto editado com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }

}
