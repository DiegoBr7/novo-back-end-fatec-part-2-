package br.com.trampuu.trampuu.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String email;

}