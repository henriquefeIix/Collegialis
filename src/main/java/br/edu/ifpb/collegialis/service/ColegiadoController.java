package br.edu.ifpb.collegialis.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.collegialis.interceptor.Transactional;
import br.edu.ifpb.collegialis.model.Colegiado;
import br.edu.ifpb.collegialis.model.Curso;
import br.edu.ifpb.collegialis.persistence.dao.ColegiadoDAO;

public class ColegiadoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ColegiadoDAO colegiadoDAO;

    @Transactional
    public Colegiado cadastrar(Colegiado colegiado) {
        return this.colegiadoDAO.insert(colegiado);
    }

    public List<Colegiado> consultar() {
        return this.colegiadoDAO.findAll();
    }

    public Colegiado consultar(Long id) {
        return this.colegiadoDAO.find(id);
    }

    public boolean isAtivo(Curso curso) {
        return this.colegiadoDAO.findByCurso(curso).isEmpty();
    }

}
