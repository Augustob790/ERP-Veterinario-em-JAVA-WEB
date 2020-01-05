package Beans;

import Controlle.Agendamento;
import Controlle.Cliente;
import Controlle.Animais;
import Controlle.Servico;
import Controlle.Funcionario;
import DAO.AgendamentoDao;
import DAO.ClienteDao;
import DAO.AnimaisDao;
import DAO.ServicoDao;
import DAO.FuncionarioDao;
import Util.JSFUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AgendamentoBeans implements Serializable {
//Variaveis

    private Agendamento agendamento;
    
    
    private ArrayList<Agendamento> itens;
    private ArrayList<Agendamento> itensFiltrados;

    private String acao;
    private Long codigo;
    private List<Cliente> listaClientes;
    private List<Animais> listaAnimais;
    private List<Servico> listaServico;
    private List<Funcionario> listaFuncionario;

    public List<Animais> getListaAnimais() {
        return listaAnimais;
    }
//Getters e Setters

    public void setListaAnimais(List<Animais> listaAnimais) {
        this.listaAnimais = listaAnimais;
    }

    public List<Servico> getListaServico() {
        return listaServico;
    }

    public void setListaServico(List<Servico> listaServico) {
        this.listaServico = listaServico;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Agendamento> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Agendamento> itens) {
        this.itens = itens;
    }

    public ArrayList<Agendamento> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Agendamento> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }
//metodo de pesquisar
    //@PostConstruct

    public void prepararPesquisa() {

        try {
            AgendamentoDao fdao = new AgendamentoDao();
            itens = (ArrayList<Agendamento>) fdao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo de carregar os cadastros

        public void carregarCadastro() {

        try {
            if (codigo != null) {
                AgendamentoDao fdao = new AgendamentoDao();
                agendamento = fdao.buscarCodigo(codigo);
            } else {
                agendamento = new Agendamento();
            }

            FuncionarioDao dao = new FuncionarioDao();
            listaFuncionario = dao.listar();
            ClienteDao ado = new ClienteDao();
            listaClientes = ado.listar();
            AnimaisDao aod = new AnimaisDao();
            listaAnimais = aod.listar();
            ServicoDao ad = new ServicoDao();
            listaServico = ad.listar();
        } catch (RuntimeException ex) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            ex.printStackTrace();
        }

    }
//    public void carregarCadastro() {
//
//        try {
//            if (codigo != null) {
//                AgendamentoDao fdao = new AgendamentoDao();
//                agendamento = fdao.buscarCodigo(codigo);
//            } else {
//                agendamento = new Agendamento();
//            }
//
//            FuncionarioDao dao = new FuncionarioDao();
//            listaFuncionario = dao.listar();
//
//        } catch (RuntimeException ex) {
//            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
//            ex.printStackTrace();
//        }
//
//    }
//
//    public void carregarCadastro1() {
//
//        try {
//
//            if (codigo != null) {
//
//                ClienteDao fdao = new ClienteDao();
//
//                cliente = fdao.buscarCodigo(codigo);
//
//            } else {
//                cliente = new Cliente();
//
//            }
//            ClienteDao ado = new ClienteDao();
//            listaClientes = ado.listar();
//        } catch (RuntimeException e) {
//            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
//            e.printStackTrace();
//        }
//
//    }
//
//    public void carregarCadastro2() {
//
//        try {
//            if (codigo != null) {
//                AnimaisDao fdao = new AnimaisDao();
//                animais = fdao.buscarCodigo(codigo);
//            } else {
//                animais = new Animais();
//            }
//
//            AnimaisDao aod = new AnimaisDao();
//            listaAnimais = aod.listar();
//        } catch (RuntimeException e) {
//            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
//            e.printStackTrace();
//        }
//
//    }
//
//    public void carregarCadastro3() {
//
//        try {
//
//            if (codigo != null) {
//
//                FuncionarioDao fdao = new FuncionarioDao();
//
//                funcionario = fdao.buscarCodigo(codigo);
//
//            } else {
//                funcionario = new Funcionario();
//
//            }
//        } catch (RuntimeException e) {
//            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
//            e.printStackTrace();
//        }
//
//    }
//
//    public void carregarCadastro4() {
//
//        try {
//
//            if (codigo != null) {
//                ServicoDao fdao = new ServicoDao();
//                servico = fdao.buscarCodigo(codigo);
//            } else {
//                servico = new Servico();
//            }
//
//            ServicoDao ad = new ServicoDao();
//            listaServico = ad.listar();
//        } catch (RuntimeException e) {
//            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
//            e.printStackTrace();
//        }
//
//    }
//metodo de criar um agendamento

    public void novo() {
        agendamento = new Agendamento();
    }
//metodo de salvar um agendamento

    public void salvar() {

        try {
            AgendamentoDao fdao = new AgendamentoDao();
            fdao.Salvar(agendamento);

            agendamento = new Agendamento();

            JSFUtil.AdicionarMensagemSucesso("Agendamento salvo com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }
//metodo de excluir agendamento

    public void excluir() {
        try {
            AgendamentoDao fdao = new AgendamentoDao();
            fdao.Excluir(agendamento);

            JSFUtil.AdicionarMensagemSucesso("Agendamento excluido com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("Não é possível excluir um agendamento que tenha uma venda associado!");
            e.printStackTrace();
        }
    }
//metodo de editar agendamento

    public void editar() {
        try {
            AgendamentoDao fdao = new AgendamentoDao();
            fdao.Atualizar(agendamento);

            JSFUtil.AdicionarMensagemSucesso("Agendamento editado com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }

}
