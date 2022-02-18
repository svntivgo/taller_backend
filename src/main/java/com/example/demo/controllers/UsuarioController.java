package com.example.demo.controllers;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    /**
     * Obtiene todos los usuario de la DB
     * @return JSON de todos los usuarios
     */
    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuario () {
        return usuarioService.obtenerUsuario();
    }

    /**
     * Guarda un usuario en la DB
     * @param usuario JSON con la información del usuario
     * @return JSON con la información del usuario
     */
    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }

    /**
     * Obtiene un usuario de la DB por su ID
     * @param id del usuario
     * @return JSON con la información del usuario
     */
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId (@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    /**
     * Obtiene una lista de usuarios por su prioridad
     * @param prioridad
     * @return JSON con la información de los usuarios
     */
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad (@RequestParam("prioridad") Integer prioridad) {
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    /**
     * Elimina un usuario por su ID
     * @param id
     * @return Mensaje de resultado
     */
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId (@PathVariable("id") Long id) {
        Boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No se pudo eliminar el usuario con id " + id;
        }
    }

    /**
     * Elimina todos los usuarios
     * @return Mensaje de resultado
     */
    @DeleteMapping(path = "/eliminar-todos")
    public String eliminarTodos () {
        Boolean ok = this.usuarioService.eliminarTodosLosUsuarios();
        if (ok) {
            return "Se eliminaron todos los usuarios";
        } else {
            return "No se pudieron eliminar todos los usuarios";
        }
    }

    /**
     * Obtiene un usuario por su nombre
     * @param nombre
     * @return JSON con la información del usuario
     */
    @GetMapping(path = "/q")
    public ArrayList<UsuarioModel> obtenerUsuarioPornombre (@RequestParam("nombre") String nombre) {
        return this.usuarioService.obtenerPorNombre(nombre);
    }

}
