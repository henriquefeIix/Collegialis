package br.edu.ifpb.collegialis.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import br.edu.ifpb.collegialis.model.Colegiado;

@FacesConverter("ColegiadoConverter")
public class ColegiadoConverter extends SelectItemsBaseConverter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().trim().equals("")) {
            return "";
        } else {
            return ((Colegiado) value).getId().toString();
        }
    }

}
