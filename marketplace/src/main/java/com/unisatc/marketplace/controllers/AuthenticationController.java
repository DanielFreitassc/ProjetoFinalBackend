package com.unisatc.marketplace.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unisatc.marketplace.dtos.AuthenticationRecordDTO;
import com.unisatc.marketplace.dtos.LoginResponseDTO;
import com.unisatc.marketplace.dtos.RegisterRecordDTO;
import com.unisatc.marketplace.infra.security.TokenService;
import com.unisatc.marketplace.models.UserEntity;
import com.unisatc.marketplace.repositories.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
 
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private TokenService tokenService;


    public AuthenticationController(AuthenticationManager authenticationManager, UserRepository userRepository,TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationRecordDTO data) {
        UserDetails userDetails = userRepository.findByLogin(data.login());
        if (!(userDetails instanceof UserEntity)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não encontrado");
        }

        UserEntity user = (UserEntity) userDetails;
        if(user.isAccountLocked()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\n \"message\" : \"A conta está bloqueada. Por favor, tente novamente mais tarde.\" \n}");
        }

        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken(user);
            user.resetLoginAttempts();
            userRepository.save(user);

            return ResponseEntity.ok(new LoginResponseDTO(token));
        } catch (Exception e) {
            user.incrementLoginAttempts();
            if(user.getLoginAttempts() >= 4) {
                user.lockAccount();
            }
            userRepository.save(user);
            int remainingAttempts = 4 - user.getLoginAttempts();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(String.format(" {\n \"message\" : \"Email ou senha incorreto, Tentativas restantes:  %d\" \n}", remainingAttempts) );
        }
    }
       
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRecordDTO data ) {
        if(this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserEntity newUser = new UserEntity(data.name(), data.login(), encryptedPassword, data.role());    
        this.userRepository.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastrado com sucesso");
    }
}
