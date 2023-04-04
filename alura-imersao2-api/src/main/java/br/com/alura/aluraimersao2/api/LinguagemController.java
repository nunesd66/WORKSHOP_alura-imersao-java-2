package br.com.alura.aluraimersao2.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LinguagemController {
    // TODO: finalizar o CRUD
    // TODO: deixar status corretos
    // TODO: querys de filtros

    @Autowired
    private LinguagemRepository repositorio;
    
    @GetMapping(value = "/linguagens")
    public List<Linguagem> obterLinguagens() {
        return repositorio.findAll();
    }
    
    @PostMapping(value = "/linguagens")
    public Linguagem salvarLinguagens(@RequestBody Linguagem linguagem) {
        return repositorio.save(linguagem);
    }
}
