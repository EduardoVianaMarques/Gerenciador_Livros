package com.GerenciamentoLivros.demo.Controller;

import com.GerenciamentoLivros.demo.model.LivrosModel;
import com.GerenciamentoLivros.demo.repositores.LivroRepository;
import com.GerenciamentoLivros.demo.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Livros")

public class LivroController {

    @Autowired
    private LivroService livroService;


    @GetMapping
    public ResponseEntity<List<LivrosModel>> findAll() {
        List<LivrosModel> requeste = livroService.findAll();
        return ResponseEntity.ok().body(requeste);
    }


    @GetMapping("/{id}")
    public Optional<LivrosModel> findById(@PathVariable Long id) {
        return livroService.findById(id);
    }


    @PostMapping
    public ResponseEntity<LivrosModel> cadastroLivro(@RequestBody LivrosModel livrosModel) {
        LivrosModel request = livroService.cadastroLivro(livrosModel);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        livroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivrosModel> update(@PathVariable Long id, @RequestBody LivrosModel livrosModel) {
        LivrosModel livros = livroService.update(id, livrosModel);
        return ResponseEntity.ok().body(livros);
    }





}
