package br.edu.ifpb.collegialis.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.collegialis.model.Usuario;
import br.edu.ifpb.collegialis.service.UsuarioController;

@Named
@SessionScoped
public class UsuarioBean extends GenericBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String user;

    private Usuario usuario;

    private String senha;

    @Inject
    private UsuarioController usuarioController;

    private List<Usuario> usuarios;

    @PostConstruct
    public void init() {
        this.usuarios = this.usuarioController.consultar();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String login() {
        if (this.usuarioController.validar(user, senha)) {
            this.usuario = this.usuarioController.consultar(user);
            this.addMessage(FacesMessage.SEVERITY_INFO, "Login efetuado com sucesso.", null);
            return "pretty:dashboard";
        } else {
            this.addMessage(FacesMessage.SEVERITY_ERROR, "Verifique suas credenciais e tente novamente.", null);
            return "pretty:login";
        }
    }

    public String logout() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ((HttpSession) fc.getExternalContext().getSession(false)).invalidate();
        this.addMessage(FacesMessage.SEVERITY_INFO, "Logout efetuado com sucesso.", null);
        return "pretty:login";
    }

}
