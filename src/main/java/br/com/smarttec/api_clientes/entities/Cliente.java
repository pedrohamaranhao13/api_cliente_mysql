package br.com.smarttec.api_clientes.entities;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cliente {

    private Integer idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String observacoes;

}
