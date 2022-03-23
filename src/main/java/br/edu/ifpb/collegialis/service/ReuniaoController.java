package br.edu.ifpb.collegialis.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.collegialis.enumeration.ReuniaoStatus;
import br.edu.ifpb.collegialis.interceptor.Transactional;
import br.edu.ifpb.collegialis.model.Reuniao;
import br.edu.ifpb.collegialis.model.Usuario;
import br.edu.ifpb.collegialis.persistence.dao.ReuniaoDAO;

public class ReuniaoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ReuniaoDAO reuniaoDAO;

    @Transactional
    public Reuniao atualizar(Reuniao reuniao) {
        return this.reuniaoDAO.update(reuniao);
    }

    @Transactional
    public Reuniao cadastrar(Reuniao reuniao) {
        return this.reuniaoDAO.insert(reuniao);
    }

    public List<Reuniao> consultar() {
        return this.reuniaoDAO.findAll();
    }

    public Reuniao consultar(Long id) {
        return this.reuniaoDAO.find(id);
    }

    public List<Reuniao> consultar(Usuario usuario) {
        return this.reuniaoDAO.findByUsuario(usuario);
    }

    public List<Reuniao> consultar(Usuario usuario, ReuniaoStatus status) {
        return this.reuniaoDAO.findByStatus(usuario, status);
    }

}
