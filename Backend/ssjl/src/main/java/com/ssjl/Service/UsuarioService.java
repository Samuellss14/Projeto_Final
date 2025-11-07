package com.ssjl.Service;

import com.ssjl.Entities.Usuario;
import com.ssjl.Repository.UsuarioRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Long id, Usuario updatedUsuario) {
        Optional<Usuario> existingUsuario = usuarioRepository.findById(id);
        if (existingUsuario.isPresent()) {
            updatedUsuario.setId(id);
            return usuarioRepository.save(updatedUsuario);
        }
        return null;
    }

    public Boolean deleteUsuario(Long id) {
        Optional<Usuario> existingUsuario = usuarioRepository.findById(id);
        if (existingUsuario.isPresent()) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}