package br.edu.ifpb.collegialis.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.collegialis.model.Curso;
import br.edu.ifpb.collegialis.persistence.dao.CursoDAO;

public class CursoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CursoDAO cursoDAO;

    public List<Curso> consultar() {
        return this.cursoDAO.findAll();
    }

}
