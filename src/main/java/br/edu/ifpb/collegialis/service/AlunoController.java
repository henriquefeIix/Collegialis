package br.edu.ifpb.collegialis.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.collegialis.model.Aluno;
import br.edu.ifpb.collegialis.persistence.dao.AlunoDAO;

public class AlunoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AlunoDAO alunoDAO;

    public List<Aluno> consultar() {
        return this.alunoDAO.findAll();
    }

}
