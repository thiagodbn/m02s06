package tech.clamed.tarefas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BemVindoController {
    @GetMapping("/clamed/hello")
    public String greetUser(@RequestParam(name = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "! Seja bem-vindo!";
    }
}
