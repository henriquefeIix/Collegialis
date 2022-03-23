package br.edu.ifpb.collegialis.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import br.edu.ifpb.collegialis.enumeration.ReuniaoStatus;
import br.edu.ifpb.collegialis.model.Reuniao;
import br.edu.ifpb.collegialis.model.Usuario;

public class ReuniaoDAO extends GenericDAO<Reuniao, Long> {

    @SuppressWarnings("unchecked")
    public List<Reuniao> findByStatus(Usuario usuario, ReuniaoStatus status) {
        try {
            Query query = super.entityManager.createQuery("SELECT r FROM Reuniao r WHERE ?1 MEMBER OF r.colegiado.membros AND r.status = ?2");
            return query.setParameter(1, usuario).setParameter(2, status).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Reuniao> findByUsuario(Usuario usuario) {
        try {
            Query query = super.entityManager.createQuery("SELECT r FROM Reuniao r WHERE ?1 MEMBER OF r.colegiado.membros");
            return query.setParameter(1, usuario).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
