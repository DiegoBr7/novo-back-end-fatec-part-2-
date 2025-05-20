package br.com.trampuu.trampuu.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Veiculo;

    private int id_Motorista;

    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private String cor;
    private double capacidadeDeCarga;
    private String tipo;

}
