
package Beans;

import Controlle.Endereco;
import DAO.EnderecoDao;
import Util.JSFUtil;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "MBEndereco")
@ViewScoped
public class EnderecoBean implements Serializable {
//Variaveis
    private Endereco endereco;

    private ArrayList<Endereco> itens;
    private ArrayList<Endereco> itensFiltrados;
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

    public Endereco getEndereco() {
        if (endereco == null) {
            endereco = new Endereco();
        }
        return endereco;
    }

    //
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Endereco> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Endereco> itens) {
        this.itens = itens;
    }

    public ArrayList<Endereco> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Endereco> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }
//metodo de pesquisar
    //@PostConstruct
    public void prepararPesquisa() {

        try {
            EnderecoDao fdao = new EnderecoDao();
            itens = (ArrayList<Endereco>) fdao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo de carregar cadastro
      public void carregarCadastro() {

        try {

            if (codigo != null) {

                EnderecoDao fdao = new EnderecoDao();

                endereco = fdao.buscarCodigo(codigo);

            } else {
                endereco = new Endereco();

            }
        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo de criar um novo endereco
    public void novo() {
        endereco = new Endereco();
    }
//metodo de salvar endereco
    public void salvar() {

        try {
            EnderecoDao fdao = new EnderecoDao();
            fdao.Salvar(endereco);

            endereco = new Endereco();

            JSFUtil.AdicionarMensagemSucesso("Endereço salvo com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }
//metodo de excluir endereco
    public void excluir() {
        try {
            EnderecoDao fdao = new EnderecoDao();
            fdao.Excluir(endereco);

            JSFUtil.AdicionarMensagemSucesso("Endereço excluido com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("Não é possível excluir um endereço que tenha uma venda associado!");
            e.printStackTrace();
        }
    }
//metodo de editar endereco
    public void editar() {
        try {
            EnderecoDao fdao = new EnderecoDao();
            fdao.Atualizar(endereco);

            JSFUtil.AdicionarMensagemSucesso("Endereço editado com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }

}
