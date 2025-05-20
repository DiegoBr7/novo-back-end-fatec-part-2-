package br.com.trampuu.trampuu.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Endereco; // Alterado de int para Long

    @Version // Adicionado para controle de concorrência
    private Integer version;

    private String rua;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Integer cep;
}