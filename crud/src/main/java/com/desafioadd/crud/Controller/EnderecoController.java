package com.desafioadd.crud.Controller;

import com.desafioadd.crud.model.Aluno;
import com.desafioadd.crud.model.Endereco;
import com.desafioadd.crud.repository.AlunoRepo;
import com.desafioadd.crud.repository.EnderecoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api")
public class EnderecoController {


    private final EnderecoRepo repository;

    public EnderecoController(EnderecoRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/endereco")
    public ResponseEntity<?> GetAll(){

        try{
            List<Endereco> lista = repository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @GetMapping("/endereco/{id}")
    public ResponseEntity<Endereco> getById(@PathVariable Long id){

        try{
            Optional<Endereco> uniOptional = repository.findById(id);

            if(uniOptional.isPresent()){
                Endereco enderecoUnid = uniOptional.get();
                return  new ResponseEntity<>(enderecoUnid,HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/endereco/salvar")
    public Endereco create(@RequestBody Endereco novoEndereco){
        return repository.save(novoEndereco);
    }


    @DeleteMapping("/endereco/deletar/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
