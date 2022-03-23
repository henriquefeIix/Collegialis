package br.edu.ifpb.collegialis.persistence.dao;

import javax.persistence.Query;

import br.edu.ifpb.collegialis.model.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario, Long> {

    public Usuario findByUsername(String username) {
        try {
            Query query = super.entityManager.createQuery("SELECT u FROM Usuario u WHERE u.matricula = ?1");
            return (Usuario) query.setParameter(1, username).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
