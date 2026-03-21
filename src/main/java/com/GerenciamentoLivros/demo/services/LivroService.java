package com.GerenciamentoLivros.demo.services;

import com.GerenciamentoLivros.demo.model.LivrosModel;
import com.GerenciamentoLivros.demo.repositores.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivrosModel> findAll() {
        return livroRepository.findAll();
    }

    public Optional<LivrosModel> findById(Long id) {
        return livroRepository.findById(id);
    }

    public LivrosModel cadastroLivro(LivrosModel livrosModel) {
        return livroRepository.save(livrosModel);
    }

    public void  deleteById(Long id) {
        livroRepository.deleteById(id);
    }

    public LivrosModel update(Long id, LivrosModel livrosModel) {
        LivrosModel newLivro = livroRepository.findById(id).get();
        newLivro.setAutor(livrosModel.getAutor());
        newLivro.setTitulo(livrosModel.getTitulo());
        newLivro.setAnoPublicacao(livrosModel.getAnoPublicacao());
        return livroRepository.save(livrosModel);
    }

}
