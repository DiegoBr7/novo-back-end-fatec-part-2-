package br.com.trampuu.trampuu.Controller;

import br.com.trampuu.trampuu.Dto.LoginDto;
import br.com.trampuu.trampuu.Model.Cliente;
import br.com.trampuu.trampuu.Services.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.CredentialExpiredException;

@RestController
@RequestMapping("auth/login")
@CrossOrigin(origins = "*")

public class LoginController {

    @Autowired
    private LoginService loginService;
    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid LoginDto loginDto){
        try {
            Cliente cliente = loginService.autenticar(loginDto.getNome() , loginDto.getSenha());
        return ResponseEntity.ok(cliente);
        }catch (CredentialExpiredException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor: " + e.getMessage());
        }
    }

}