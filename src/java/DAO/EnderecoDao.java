
package DAO;

import Controlle.Endereco;
import Util.HibernateUtil;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class EnderecoDao {
//metodo de salvar
    public void Salvar(Endereco endereco) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); 
            session.save(endereco);
            transaction.commit(); 

        } catch (RuntimeException ex) {
            if (transaction != null) {
                transaction.rollback(); 

            }

        } finally {
            session.close();
        }
    }

    // método de excluir 
    public void Excluir(Endereco endereco) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); 
            session.delete(endereco);
            transaction.commit(); 

        } catch (RuntimeException ex) {
            if (transaction != null) {
                transaction.rollback(); 

            }

        } finally {
            session.close();
        }
    }
//metodo de atualizar
    public void Atualizar(Endereco endereco) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); 
            session.update(endereco);
            transaction.commit(); 

        } catch (RuntimeException ex) {
            if (transaction != null) {
                transaction.rollback(); 

            }

        } finally {
            session.close();
        }
    }

    // método para listar os dados
    public List< Endereco> listar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Endereco> enderecoes = null;
        try {
            Query consulta = session.getNamedQuery("Endereco.findAll");
            enderecoes = consulta.list();

        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
        return enderecoes;

    }

    // Buscar por Código
    public Endereco buscarCodigo(long codigo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Endereco enderecoes = null;
        try {
    Query consulta = session.getNamedQuery("Endereco.findByCodigoEndereco");
            consulta.setLong("codigoEndereco", codigo);
            enderecoes = (Endereco) consulta.uniqueResult();

        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
        return enderecoes;

    }
}
