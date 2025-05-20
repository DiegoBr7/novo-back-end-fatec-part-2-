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
    private String telefone;
    private String email;
    private int cnh;

//    @Version
//    private Long version;

    public int getId_Motorista() {
        return id_Motorista;
    }

    public void setId_Motorista(int id_Motorista) {
        this.id_Motorista = id_Motorista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCnh() {
        return cnh;
    }

    public void setCnh(int cnh) {
        this.cnh = cnh;
    }
}
