package com.aulas.codigos.service;

import java.util.List;
import java.util.Optional;

import com.aulas.codigos.model.Produto;
import com.aulas.codigos.repository.ProdutoRepository;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    };

    public Produto create(Produto p) {
        return produtoRepository.save(p);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto update(Produto p) {
        return produtoRepository.saveAndFlush(p);
    }

    public Produto findProdutoId(Long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (produtoOptional.isPresent()) {
            return produtoOptional.get();
        }

        return null;
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
}
