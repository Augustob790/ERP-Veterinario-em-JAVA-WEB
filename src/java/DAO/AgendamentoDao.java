
package DAO;

import Controlle.Agendamento;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AgendamentoDao {
//metodo de salvar
    public void Salvar(Agendamento agendamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            session.save(agendamento);
            transaction.commit(); // confirma a transação
        } catch (RuntimeException ex) {
            if (transaction != null) {
                transaction.rollback(); // desfaz a transação
            }
        } finally {
            session.close();
        }
    }

    // método de excluir 
    public void Excluir(Agendamento agendamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            session.delete(agendamento);
            transaction.commit(); // confirma a transação
        } catch (RuntimeException ex) {
            if (transaction != null) {
                transaction.rollback(); // desfaz a transação
            }
        } finally {
            session.close();
        }
    }
//metodo de atualizar
    public void Atualizar(Agendamento agendamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            Agendamento agendaEditar = buscarCodigo(agendamento.getCodigoAgendamento());
            session.update(agendamento);
            transaction.commit(); // confirma a transação
        } catch (RuntimeException ex) {
            if (transaction != null) {
                transaction.rollback(); // desfaz a transação
            }
        } finally {
            session.close();
        }
    }

    // método para listar os dados
    public List< Agendamento> listar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Agendamento> animaisses = null;
        try {
            Query consulta = session.getNamedQuery("Agendamento.findAll");
            animaisses = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
        return animaisses;
    }

    // Buscar por Código
    public Agendamento buscarCodigo(long codigo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Agendamento agendamento = null;
        try {
            Query consulta = session.getNamedQuery("Agendamento.findByCodigoAgendamento");
            consulta.setLong("codigoAgendamento", codigo);
            agendamento = (Agendamento) consulta.uniqueResult();

        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
        return agendamento;
    }

}
