package com.tech_challenge.agendamento_service.graphql.resolver;

import com.tech_challenge.agendamento_service.model.Usuario;
import com.tech_challenge.agendamento_service.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UsuarioResolver {

    @Autowired
    private UsuarioService usuarioService;

    @MutationMapping
    public Usuario criarUsuario(String nome, String email, String senha, String tipo) {
        return usuarioService.criarUsuario(nome, email, senha, tipo);
    }

    @QueryMapping
    public Usuario buscarUsuario(Long id) {
        return usuarioService.buscarPorId(id);
    }

    @QueryMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @MutationMapping
    public Usuario desativarUsuario(Long id) {
        return usuarioService.desativarUsuario(id);
    }
}