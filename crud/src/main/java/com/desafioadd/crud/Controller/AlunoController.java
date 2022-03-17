package com.desafioadd.crud.Controller;


import com.desafioadd.crud.model.Aluno;
import com.desafioadd.crud.repository.AlunoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AlunoController {

    private final AlunoRepo repository;

    public AlunoController(AlunoRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/aluno")
    public ResponseEntity<?> GetAll(){

        try{
            List<Aluno> lista = repository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @GetMapping("/aluno/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable Long id){

        try{
            Optional<Aluno> uniOptional = repository.findById(id);

            if(uniOptional.isPresent()){
                Aluno alunoUnid = uniOptional.get();
                return  new ResponseEntity<>(alunoUnid,HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/aluno/salvar")
    public Aluno create(@RequestBody Aluno novoAluno){
        return repository.save(novoAluno);
    }


    @DeleteMapping("/aluno/deletar/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }






}



