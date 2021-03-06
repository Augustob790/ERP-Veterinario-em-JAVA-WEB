

package DAO;

import Controlle.Servico;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ServicoDao {
    //metodo de salvar
    public void Salvar(Servico servico ) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            session.save(servico);
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
    public void Excluir(Servico servico ) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            session.delete(servico);
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
    public void Atualizar(Servico servico) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            Servico servicosEditar = buscarCodigo(servico.getCodigoServico());
            servicosEditar.setNomeServico(servico.getNomeServico());
             session.update(servico);
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
    public  List< Servico>  listar (){
         Session session = HibernateUtil.getSessionFactory().openSession();
         List<Servico> servicoses =null;
         try{
             Query consulta = session.getNamedQuery("Servico.findAll");
             servicoses = consulta.list();
             
         } catch(RuntimeException ex){
             throw  ex;
         }
         finally{
             session.close();
         }
         return  servicoses;
        
    }
    
    // Buscar por Código
    
     public Servico  buscarCodigo( long  codigo){
         Session session = HibernateUtil.getSessionFactory().openSession();
         Servico servico =null;
         try{
             Query consulta = session.getNamedQuery("Servico.findByCodigoServico");
             consulta.setLong("codigoServico", codigo);
             servico =(Servico) consulta.uniqueResult();
             
         } catch(RuntimeException ex){
             throw  ex;
         }
         finally{
             session.close();
         }
         return  servico;
        
    }

    
}
