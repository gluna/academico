package academico.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import academico.controllers.CentroController;
import academicos.modelos.Centro;

@FacesConverter( value="convertCentro", forClass = Centro.class )  
public class CentroConverter implements Converter, Serializable{

	private static final long serialVersionUID = 8725502730380317654L;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String centro) {
		
		CentroController controller = new CentroController();
		Centro cent = new Centro();
		for(Centro c : controller.getCentros() ) {
			if(c.getCDCENTRO().equals(centro)) {
				return c; 
			}
		}
		return cent;
	}
	
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object centro) {
		//String cdcentro = "";
		if(centro != "") {
			Centro c = (Centro)centro;
			return c.getCDCENTRO() != null && !c.getCDCENTRO().isEmpty() ? c.getCDCENTRO() : null;
		}
		return "";
	}
	
}