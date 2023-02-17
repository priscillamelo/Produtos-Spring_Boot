package com.aulas.codigos.controller;

import java.util.List;

import com.aulas.codigos.model.Produto;
import com.aulas.codigos.service.ProdutoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ProdutoController {
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService service) {
        this.produtoService = service;
    }

    @RequestMapping(value = { "/", "/produtos" })
    public String getHome(Model model) {

        List<Produto> produtos = produtoService.findAll();
        model.addAttribute("listaProdutos", produtos);

        return "index";
    }

    @RequestMapping("/cadastrar")
    public String getCadastrarProduto(Model model) {
        Produto p = new Produto();
        model.addAttribute("produto", p);

        return "cadastrar";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String doSalvar(@ModelAttribute @Valid Produto p, Errors errors) {
        if(errors.hasErrors()){
            return "cadastrar";
        } else {
            produtoService.create(p);
            return "redirect:/";
        }
    }

    @RequestMapping("/deletar/{id}")
    public String doDeletar(@PathVariable(name = "id") Long id) {
        produtoService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public String doEditar(@PathVariable(name = "id") Long id, Model model) {
        Produto p = produtoService.findProdutoId(id);
        model.addAttribute("produto", p);

        return "cadastrar";
    }
}
