package com.aulas.codigos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.aulas.codigos.error_handling.ApiMessages;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank (message = ApiMessages.Erro_nome)
    private String nome;

    private String descricao;

    @Min(value = 0, message = ApiMessages.Erro_preco)
    private float preco;
}
