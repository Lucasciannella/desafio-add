package com.desafioadd.crud.repository;

import com.desafioadd.crud.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;





public  interface EnderecoRepo  extends JpaRepository<Endereco, Long> {
}
