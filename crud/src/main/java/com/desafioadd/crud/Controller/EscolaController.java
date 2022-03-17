package com.desafioadd.crud.Controller;


import com.desafioadd.crud.model.Escola;

import com.desafioadd.crud.repository.EscolaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class EscolaController {

    private final EscolaRepo repository;

    public EscolaController(EscolaRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/escola")
    public ResponseEntity<?> GetAll(){

        try{
            List<Escola> lista = repository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @GetMapping("/escola/{id}")
    public ResponseEntity<Escola> getById(@PathVariable Long id){

        try{
            Optional<Escola> uniOptional = repository.findById(id);

            if(uniOptional.isPresent()){
                Escola escolaUnid = uniOptional.get();
                return  new ResponseEntity<>(escolaUnid,HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/escola/salvar")
    public Escola create(@RequestBody Escola novaEscola){
        return repository.save(novaEscola);
    }


    @DeleteMapping("/escola/deletar/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
