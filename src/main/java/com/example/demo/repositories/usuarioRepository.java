package com.example.demo.repositories;

import com.example.demo.models.usuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuarioRepository extends CrudRepository<usuarioModel, Long> {

}
