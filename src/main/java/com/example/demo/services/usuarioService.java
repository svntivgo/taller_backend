package com.example.demo.services;

import com.example.demo.repositories.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class usuarioService {

    @Autowired
    usuarioRepository usuarioRepository;
}
