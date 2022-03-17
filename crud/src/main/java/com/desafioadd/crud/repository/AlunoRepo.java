package com.desafioadd.crud.repository;


import com.desafioadd.crud.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepo  extends JpaRepository<Aluno,Long> {
}
