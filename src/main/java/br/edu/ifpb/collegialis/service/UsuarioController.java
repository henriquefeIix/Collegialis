package br.edu.ifpb.collegialis.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.collegialis.model.Usuario;
import br.edu.ifpb.collegialis.persistence.dao.UsuarioDAO;
import br.edu.ifpb.collegialis.util.PasswordUtils;

public class UsuarioController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario;

    @Inject
    private UsuarioDAO usuarioDAO;

    public List<Usuario> consultar() {
        return this.usuarioDAO.findAll();
    }

    public Usuario consultar(String username) {
        return this.usuarioDAO.findByUsername(username);
    }

    public boolean validar(String username, String senha) {
        if ((usuario = this.consultar(username)) == null) {
            return false;
        } else {
            return PasswordUtils.verify(senha, usuario.getSenha());
        }
    }

}
