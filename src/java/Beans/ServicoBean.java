
package Beans;

import Controlle.Controleestoque;
import Controlle.Servico;
import DAO.ControleEstoqueDao;
import DAO.ServicoDao;
import Util.JSFUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBServico")
@ViewScoped
public class ServicoBean implements Serializable {
//variaveis
    private Servico servico;

    private ArrayList<Servico> itens;
    private ArrayList<Servico> itensFiltrados;
    private String acao;
    private Long codigo;
    private List<Controleestoque> listaEstoque;

    public List<Controleestoque> getListaEstoque() {
        return listaEstoque;
    }
//Getters e Setters
    public void setListaEstoque(List<Controleestoque> listaEstoque) {
        this.listaEstoque = listaEstoque;
    }

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

    public Servico getServico() {
        if (servico == null) {
            servico = new Servico();
        }
        return servico;
    }

    //
    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public ArrayList<Servico> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Servico> itens) {
        this.itens = itens;
    }

    public ArrayList<Servico> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Servico> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }
//metodo de pesquisa
    //@PostConstruct
    public void prepararPesquisa() {

        try {
            ServicoDao fdao = new ServicoDao();
            itens = (ArrayList<Servico>) fdao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo de carregar cadastro
    public void carregarCadastro() {

        try {

            if (codigo != null) {
                ServicoDao fdao = new ServicoDao();
                servico = fdao.buscarCodigo(codigo);
            } else {
                servico = new Servico();
            }

            ControleEstoqueDao dao = new ControleEstoqueDao();
            listaEstoque = dao.listar();
        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo de criar um novo servico
    public void novo() {
        servico = new Servico();
    }
//metodo de salvar servico
    public void salvar() {

        try {
            ServicoDao fdao = new ServicoDao();
            fdao.Salvar(servico);

            servico = new Servico();

            JSFUtil.AdicionarMensagemSucesso("Serviço salvo com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }
//metodo de excluir servico
    public void excluir() {
        try {
            ServicoDao fdao = new ServicoDao();
            fdao.Excluir(servico);

            JSFUtil.AdicionarMensagemSucesso("Serviço excluido com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("Não é possível excluir um serviço que tenha uma venda associado!");
            e.printStackTrace();
        }
    }
//metodo de editar servico
    public void editar() {
        try {
            ServicoDao fdao = new ServicoDao();
            fdao.Atualizar(servico);

            JSFUtil.AdicionarMensagemSucesso("Serviço editado com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }

}
