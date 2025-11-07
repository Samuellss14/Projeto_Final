package com.ssjl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssjl.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

}
