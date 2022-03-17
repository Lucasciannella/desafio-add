package com.desafioadd.crud.repository;

import com.desafioadd.crud.model.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface EscolaRepo extends JpaRepository<Escola,Long> {
}
