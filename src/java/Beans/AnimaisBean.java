
package Beans;

import Controlle.Animais;
import Controlle.Cliente;
import DAO.AnimaisDao;
import DAO.ClienteDao;
import Util.JSFUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



@ManagedBean(name = "MBAnimais")
@ViewScoped
public class AnimaisBean implements Serializable {
//Variaveis
    private Animais animais;

    private ArrayList<Animais> itens;
    private ArrayList<Animais> itensFiltrados;
    private String acao;
    private Long codigo;
    private List<Cliente> listaClientes;

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
//Getters e Setters
    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
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

    public Animais getAnimais() {
        if (animais == null) {
            animais = new Animais();
        }
        return animais;
    }

    //
    public void setAnimais(Animais animais) {
        this.animais = animais;
    }

    public ArrayList<Animais> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Animais> itens) {
        this.itens = itens;
    }

    public ArrayList<Animais> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Animais> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }
//metodo de pesquisar
    //@PostConstruct
    public void prepararPesquisa() {

        try {
            AnimaisDao fdao = new AnimaisDao();
            itens = (ArrayList<Animais>) fdao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo de carregar cadastro
    public void carregarCadastro() {

        try {
            if (codigo != null) {
                AnimaisDao fdao = new AnimaisDao();
                animais = fdao.buscarCodigo(codigo);
            } else {
                animais = new Animais();
            }

            ClienteDao ado = new ClienteDao();
            listaClientes = ado.listar();
        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo de cadastrar animais
    public void novo() {
        animais = new Animais();
    }
//metodo de salvar animais
    public void salvar() {

        try {
            AnimaisDao fdao = new AnimaisDao();
            fdao.Salvar(animais);

            animais = new Animais();

            JSFUtil.AdicionarMensagemSucesso("Animal salvo com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }
//metodo de excluir animais
    public void excluir() {
        try {
            AnimaisDao fdao = new AnimaisDao();
            fdao.Excluir(animais);

            JSFUtil.AdicionarMensagemSucesso("Animal excluido com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("Não é possível excluir um animal que tenha uma vacina  associado!");
            e.printStackTrace();
        }
    }
//metodo de editar animais
    public void editar() {
        try {
            AnimaisDao fdao = new AnimaisDao();
            fdao.Atualizar(animais);

            JSFUtil.AdicionarMensagemSucesso("Animal editado com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }

}
