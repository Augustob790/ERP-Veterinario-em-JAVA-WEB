package Beans;

import Controlle.Cliente;
import DAO.ClienteDao;
import Util.JSFUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

public class ClienteBeans implements Serializable {
//variaveis

    private Cliente cliente;

    private ArrayList<Cliente> itens;
    private ArrayList<Cliente> itensFiltrados;
    private List<Cliente> listaCliente;
    private String acao;
    private Long codigo;
//Getters e Setters

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

    public Cliente getCliente() {
        if (cliente == null) {
            cliente = new Cliente();
        }
        return cliente;
    }

    //
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Cliente> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Cliente> itens) {
        this.itens = itens;
    }

    public ArrayList<Cliente> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Cliente> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

//metodo de prepapar pesquisa
    //@PostConstruct
    public void prepararPesquisa() {

        try {
            ClienteDao fdao = new ClienteDao();
            itens = (ArrayList<Cliente>) fdao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo de carregar cadastro

    public void carregarCadastro() {

        try {

            if (codigo != null) {

                ClienteDao fdao = new ClienteDao();

                cliente = fdao.buscarCodigo(codigo);

            } else {
                cliente = new Cliente();

            }
        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo de criar um novo cliente

    public void novo() {
        cliente = new Cliente();
    }
//metodo de salvar cliente

    public void salvar() {

        try {
            ClienteDao fdao = new ClienteDao();
            fdao.Salvar(cliente);

            cliente = new Cliente();

            JSFUtil.AdicionarMensagemSucesso("Cliente salvo com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }
//metodo de excluir cliente

    public void excluir() {
        try {
            ClienteDao fdao = new ClienteDao();
            fdao.Excluir(cliente);

            JSFUtil.AdicionarMensagemSucesso("Cliente excluido com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("Não é possível Cliente um cliente que tenha uma venda associado!");
            e.printStackTrace();
        }
    }
//metodo de editar cliente

    public void editar() {
        try {
            ClienteDao fdao = new ClienteDao();
            fdao.Atualizar(cliente);

            JSFUtil.AdicionarMensagemSucesso("Cliente editado com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }

}
