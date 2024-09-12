package br.com.smarttec.api_clientes.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientePutDto {

    private Integer idCliente;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String observacoes;

}
