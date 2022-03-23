package br.edu.ifpb.collegialis.util;

import java.io.Serializable;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordUtils implements Serializable {

    private static final long serialVersionUID = 1L;

    public static String generate(String senha) {
        return BCrypt.withDefaults().hashToString(12, senha.toCharArray());
    }

    public static boolean verify(String senha, String hash) {
        return BCrypt.verifyer().verify(senha.toCharArray(), hash).verified;
    }

}
