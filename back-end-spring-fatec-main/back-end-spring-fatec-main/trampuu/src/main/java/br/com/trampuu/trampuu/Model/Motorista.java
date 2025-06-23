package br.com.trampuu.trampuu.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor; // <--- IMPORTANTE

@Entity
@Getter
@Setter
@NoArgsConstructor // <--- ESSA LINHA É O QUE FALTAVA
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Motorista;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private int cnh;
    private String veiculo;



}
