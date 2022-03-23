package br.edu.ifpb.collegialis.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.collegialis.model.Professor;
import br.edu.ifpb.collegialis.persistence.dao.ProfessorDAO;

public class ProfessorController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ProfessorDAO professorDAO;

    public List<Professor> consultar() {
        return this.professorDAO.findAll();
    }
}
