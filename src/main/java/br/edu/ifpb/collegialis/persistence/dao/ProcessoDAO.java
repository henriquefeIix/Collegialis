package br.edu.ifpb.collegialis.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import br.edu.ifpb.collegialis.enumeration.ProcessoStatus;
import br.edu.ifpb.collegialis.model.Processo;
import br.edu.ifpb.collegialis.model.Usuario;

public class ProcessoDAO extends GenericDAO<Processo, Long> {

    @SuppressWarnings("unchecked")
    public List<Processo> findByCoordenador(Usuario usuario) {
        try {
            Query query = super.entityManager.createQuery("SELECT p FROM Processo p JOIN p.requisitante r WHERE r.curso.coordenacao.coordenador = ?1");
            return query.setParameter(1, usuario).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Processo> findByCoordenador(Usuario usuario, ProcessoStatus status) {
        try {
            Query query = super.entityManager.createQuery("SELECT p FROM Processo p JOIN p.requisitante r WHERE r.curso.coordenacao.coordenador = ?1 AND p.status = ?2");
            return query.setParameter(1, usuario).setParameter(2, status).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Processo> findByRelator(Usuario usuario) {
        try {
            Query query = super.entityManager.createQuery("SELECT p FROM Processo p WHERE p.relator = ?1 AND p.status <> ?2");
            return query.setParameter(1, usuario).setParameter(2, ProcessoStatus.JULGADO).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Processo> findByRequisitante(Usuario usuario) {
        try {
            Query query = super.entityManager.createQuery("SELECT p FROM Processo p WHERE p.requisitante = ?1");
            return query.setParameter(1, usuario).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
