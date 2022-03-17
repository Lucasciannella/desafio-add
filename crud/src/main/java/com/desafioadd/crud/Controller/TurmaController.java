package com.desafioadd.crud.Controller;

import com.desafioadd.crud.model.Aluno;
import com.desafioadd.crud.model.Turma;
import com.desafioadd.crud.repository.AlunoRepo;
import com.desafioadd.crud.repository.TurmaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TurmaController {


    private final TurmaRepo repository;

    public TurmaController(TurmaRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/turma")
    public ResponseEntity<?> GetAll(){

        try{
            List<Turma> lista = repository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @GetMapping("/turma/{id}")
    public ResponseEntity<Turma> getById(@PathVariable Long id){

        try{
            Optional<Turma> uniOptional = repository.findById(id);

            if(uniOptional.isPresent()){
                Turma turmaUnid= uniOptional.get();
                return  new ResponseEntity<>(turmaUnid,HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/turma/salvar")
    public Turma create(@RequestBody Turma novaTurma){
        return repository.save(novaTurma);
    }


    @DeleteMapping("/turma/deletar/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
