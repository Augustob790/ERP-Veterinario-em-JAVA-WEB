

package Util;

import Controlle.Controleestoque;
import DAO.ControleEstoqueDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("estoqueConverter")
public class ControleEstoqueConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent componente, String valor) {
        try {

            Long codigo = Long.parseLong(valor);
            ControleEstoqueDao dao = new ControleEstoqueDao();
            Controleestoque prod = dao.buscarCodigo(codigo);

            return prod;

        } catch (RuntimeException ex) {
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent componente, Object objeto) {

        try {

            Controleestoque prod = (Controleestoque) objeto;
            Integer codigo = prod.getCodigoProduto();
            return codigo.toString();

        } catch (RuntimeException ex) {
            return null;
        }
    }

}
