package com.example.yonny.servicedesk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Yonny on 25/09/2017.
 */

public class UsuarioRepository {


    private static UsuarioRepository repository = new UsuarioRepository();
    private HashMap<String, Usuario> usuarios = new HashMap<>();

    public static UsuarioRepository getInstance() {
        return repository;
    }

    private UsuarioRepository() {

        saveUsuario(new Usuario("Yonny1", "123456", "Yonny Rivera", "Cliente"));
        saveUsuario(new Usuario("Yonny2", "1234567", "Yonny Rivera1", "Supervisor"));
        saveUsuario(new Usuario("Yonny3", "12345678", "Yonny Rivera2", "Técnico"));

    }

    private void saveUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    public List<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios.values());
    }
}
