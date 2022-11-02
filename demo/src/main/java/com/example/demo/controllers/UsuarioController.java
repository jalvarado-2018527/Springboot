package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuario(){
        return usuarioService.obtenerUsuario();
    }
    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }
    @GetMapping( path = "/{id}")
    public Optional<UsuarioModel> obtenerPorId(@PathVariable("id")Long id){
        return this.usuarioService.obtenerPorId(id);
    }
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@PathParam("prioridad")Integer prioridad){
        return this.usuarioService.obtenePorPrioridad(prioridad);
    }
    @DeleteMapping(path = "/{id}")
    public String eliminarPorid(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "se elimino el usuario con id " + id;
        }else {
            return "no pudo eliminar el usuario id "+ id;
        }
    }
}
