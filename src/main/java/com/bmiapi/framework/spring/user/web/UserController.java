package com.bmiapi.framework.spring.user.web;

import com.bmiapi.framework.spring.user.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService service) {
        this.userService = service;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "JSon com o UUID do usuário criado."),
            @ApiResponse(code = 400, message = "Valor inválido informado no body da request."),
            @ApiResponse(code = 500, message = "Ocorreu erro interno no servidor."),
    })
    @PostMapping
    public CreateUserWebOutput createUser(@RequestBody UserWebInput user) {

        return userService.createUser(user);
    }

    @GetMapping
    public List<UserWebOutput> findAll() {
        return userService.findAll();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "JSon com o UUID do usuário criado."),
            @ApiResponse(code = 404, message = "Usuário não encontrado para o Id informado."),
            @ApiResponse(code = 500, message = "Ocorreu erro interno no servidor."),
    })
    @GetMapping("/{id}/user")
    public UserWebOutput findById(@PathVariable UUID id) {
        return userService.findById(id);
    }

}
