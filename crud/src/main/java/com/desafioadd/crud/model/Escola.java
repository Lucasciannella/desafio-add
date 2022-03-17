package com.desafioadd.crud.model;


import javax.persistence.*;

@Entity
@Table(name = "escola")
public class Escola {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_enderco")
    private Endereco endereco;

}
