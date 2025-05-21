package com.tech_challenge.agendamento_service.service;

import com.tech_challenge.agendamento_service.model.Usuario;
import com.tech_challenge.agendamento_service.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(String nome, String email, String senha, String tipo) {
        Usuario usuario = Usuario.builder()
                .nome(nome)
                .email(email)
                .senha(senha)
                .tipo(tipo)
                .ativo(true)
                .build();
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario desativarUsuario(Long id) {
        Usuario usuario = buscarPorId(id);
        usuario.setAtivo(false);
        return usuarioRepository.save(usuario);
    }
}