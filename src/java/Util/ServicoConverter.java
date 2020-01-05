

package Util;

import Controlle.Servico;
import DAO.ServicoDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("servicoConverter")
public class ServicoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent componente, String valor) {
        try {

            Long codigo = Long.parseLong(valor);
            ServicoDao dao = new ServicoDao();
            Servico servico = dao.buscarCodigo(codigo);

            return servico;

        } catch (RuntimeException ex) {
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent componente, Object objeto) {

        try {

            Servico servico = (Servico) objeto;
            Integer codigo = servico.getCodigoServico();
            return codigo.toString();

        } catch (RuntimeException ex) {
            return null;
        }
    }

}
