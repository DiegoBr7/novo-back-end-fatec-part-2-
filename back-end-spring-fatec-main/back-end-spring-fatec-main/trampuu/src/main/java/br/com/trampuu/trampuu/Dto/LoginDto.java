package br.com.trampuu.trampuu.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    @NotBlank
    private String nome;

    @NotBlank
    private String senha;

    public LoginDto(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
}