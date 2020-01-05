
package DAO;

import Controlle.Animais;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class AnimaisDao {
//metodo de salvar
    public void Salvar(Animais animais) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            session.save(animais);
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
    public void Excluir(Animais animais) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            session.delete(animais);
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
    public void Atualizar(Animais animais) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            Animais animaissEditar = buscarCodigo(animais.getCodigoAnimais());
            animaissEditar.setNome(animais.getNome());
            session.update(animais);
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
    public List< Animais> listar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Animais> animaisses = null;
        try {
            Query consulta = session.getNamedQuery("Animais.findAll");
            animaisses = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
        return animaisses;
    }

    // Buscar por Código
    public Animais buscarCodigo(long codigo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Animais animais = null;
        try {
            Query consulta = session.getNamedQuery("Animais.findByCodigoAnimais");
            consulta.setLong("codigoAnimais", codigo);
            animais = (Animais) consulta.uniqueResult();

        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
        return animais;
    }

}
