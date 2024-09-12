package br.com.smarttec.api_clientes.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientePostDto {

    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String observacoes;
}
