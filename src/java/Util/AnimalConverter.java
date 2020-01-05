

package Util;

import Controlle.Animais;
import DAO.AnimaisDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("animaisConverter")
public class AnimalConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent componente, String valor) {
        try {

            Long codigo = Long.parseLong(valor);
            AnimaisDao dao = new AnimaisDao();
            Animais animais = dao.buscarCodigo(codigo);

            return animais;

        } catch (RuntimeException ex) {
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent componente, Object objeto) {

        try {

            Animais animais = (Animais) objeto;
            Integer codigo = animais.getCodigoAnimais();
            return codigo.toString();

        } catch (RuntimeException ex) {
            return null;
        }
    }

}
