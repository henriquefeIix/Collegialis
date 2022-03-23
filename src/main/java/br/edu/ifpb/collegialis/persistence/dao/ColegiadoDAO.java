package br.edu.ifpb.collegialis.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import br.edu.ifpb.collegialis.model.Colegiado;
import br.edu.ifpb.collegialis.model.Curso;

public class ColegiadoDAO extends GenericDAO<Colegiado, Long> {

    @SuppressWarnings("unchecked")
    public List<Colegiado> findByCurso(Curso curso) {
        try {
            Query query = super.entityManager.createQuery("SELECT c FROM Colegiado c WHERE c.curso = ?1 AND c.dataTermino IS NOT NULL");
            return query.setParameter(1, curso).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
