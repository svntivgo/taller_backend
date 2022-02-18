package com.example.demo.services;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuario () {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public ArrayList<UsuarioModel> obtenerPorNombre (String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    public UsuarioModel guardarUsuario (UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId (Long id) {
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerPorPrioridad (Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public Boolean eliminarUsuario (Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public Boolean eliminarTodosLosUsuarios () {
        try {
            usuarioRepository.deleteAll();
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
