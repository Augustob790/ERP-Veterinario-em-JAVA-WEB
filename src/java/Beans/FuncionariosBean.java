package Beans;

import Controlle.Funcionario;
import DAO.FuncionarioDao;
import Util.JSFUtil;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBFuncionarios")
@ViewScoped
public class FuncionariosBean implements Serializable {
//mvariaveis

    private Funcionario funcionario;

    private ArrayList<Funcionario> itens;
    private ArrayList<Funcionario> itensFiltrados;
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

    public Funcionario getFuncionario() {
        if (funcionario == null) {
            funcionario = new Funcionario();
        }
        return funcionario;
    }

    //
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ArrayList<Funcionario> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Funcionario> itens) {
        this.itens = itens;
    }

    public ArrayList<Funcionario> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Funcionario> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }
//metodo de pesquisa
    //@PostConstruct

    public void prepararPesquisa() {

        try {
            FuncionarioDao fdao = new FuncionarioDao();
            itens = (ArrayList<Funcionario>) fdao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo de carregar cadastros funcionarios

    public void carregarCadastro() {

        try {

            if (codigo != null) {

                FuncionarioDao fdao = new FuncionarioDao();

                funcionario = fdao.buscarCodigo(codigo);

            } else {
                funcionario = new Funcionario();

            }
        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo de criar um novo funcionario

    public void novo() {
        funcionario = new Funcionario();
    }
//metodo de salvar funcionario

    public void salvar() {

        try {
            FuncionarioDao fdao = new FuncionarioDao();
            fdao.Salvar(funcionario);

            funcionario = new Funcionario();

            JSFUtil.AdicionarMensagemSucesso("Funcionário salvo com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }
//metodo de excluir funcionario

    public void excluir() {
        try {
            FuncionarioDao fdao = new FuncionarioDao();
            fdao.Excluir(funcionario);

            JSFUtil.AdicionarMensagemSucesso("Funcionário excluido com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("Não é possível excluir um funcionário que tenha uma venda associado!");
            e.printStackTrace();
        }
    }
//metodo de editar funcionarios

    public void editar() {
        try {
            FuncionarioDao fdao = new FuncionarioDao();
            fdao.Atualizar(funcionario);

            JSFUtil.AdicionarMensagemSucesso("Funcionário editado com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }

}
