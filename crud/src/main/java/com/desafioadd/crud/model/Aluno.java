package com.desafioadd.crud.model;


import lombok.*;


import javax.persistence.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
public class Aluno {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dataDeNascimento")
    private Date dataDeNascimento;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;



}
