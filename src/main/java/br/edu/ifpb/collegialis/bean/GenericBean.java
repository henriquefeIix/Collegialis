package br.edu.ifpb.collegialis.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class GenericBean {

    public void setFlash(String nome, Object valor) {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put(nome, valor);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().keep(nome);
    }

    public Object getFlash(String nome) {
        return FacesContext.getCurrentInstance().getExternalContext().getFlash().get(nome);
    }

    public String getRequestURL() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        return ((HttpServletRequest) ec.getRequest()).getRequestURL().toString();
    }

    public void addMessage(FacesMessage.Severity severity, String message, String detail) {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage msg = new FacesMessage(severity, message, detail);
        fc.addMessage(null, msg);
    }

}
