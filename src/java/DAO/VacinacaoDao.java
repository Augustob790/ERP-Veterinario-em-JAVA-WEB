

package DAO;

import Controlle.Vacinacao;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class VacinacaoDao {
    //metodo de salvar
    public void Salvar(Vacinacao vacinacao ) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            session.save(vacinacao);
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
    public void Excluir(Vacinacao vacinacao ) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            session.delete(vacinacao);
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
    public void Atualizar(Vacinacao vacinacao) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            Vacinacao vacinacaosEditar = buscarCodigo(vacinacao.getCodigoVacinacao());
            vacinacaosEditar.setNomeVacina(vacinacao.getNomeVacina());
             session.update(vacinacao);
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
    public  List< Vacinacao>  listar (){
         Session session = HibernateUtil.getSessionFactory().openSession();
         List<Vacinacao> vacinacaoses =null;
         try{
             Query consulta = session.getNamedQuery("Vacinacao.findAll");
             vacinacaoses = consulta.list();
             
         } catch(RuntimeException ex){
             throw  ex;
         }
         finally{
             session.close();
         }
         return  vacinacaoses;
        
    }
    
    // Buscar por Código
    
     public Vacinacao  buscarCodigo( long  codigo){
         Session session = HibernateUtil.getSessionFactory().openSession();
         Vacinacao vacinacao =null;
         try{
             Query consulta = session.getNamedQuery("Vacinacao.findByCodigoVacinacao");
             consulta.setLong("codigoVacinacao", codigo);
             vacinacao =(Vacinacao) consulta.uniqueResult();
             
         } catch(RuntimeException ex){
             throw  ex;
         }
         finally{
             session.close();
         }
         return  vacinacao;
        
    }

    
}
