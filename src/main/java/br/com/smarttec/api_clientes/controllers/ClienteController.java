package br.com.smarttec.api_clientes.controllers;

import br.com.smarttec.api_clientes.dtos.ClientePostDto;
import br.com.smarttec.api_clientes.dtos.ClientePutDto;
import br.com.smarttec.api_clientes.entities.Cliente;
import br.com.smarttec.api_clientes.repositories.ClienteRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    @PostMapping
    public String post(@RequestBody ClientePostDto dto) {

        try {

            Cliente cliente = new Cliente();
            cliente.setNome(dto.getNome());
            cliente.setEmail(dto.getEmail());
            cliente.setCpf(dto.getCpf());
            cliente.setTelefone(dto.getTelefone());
            cliente.setObservacoes(dto.getObservacoes());

            ClienteRepository clienteRepository = new ClienteRepository();
            clienteRepository.create(cliente);

            return "Cliente cadastrado com sucesso!";

        } catch (Exception e) {

            return "Erro: " + e.getMessage();
        }
    }

    @PutMapping
    public String put(@RequestBody ClientePutDto dto) {

        try {

            ClienteRepository clienteRepository = new ClienteRepository();
            Cliente cliente = clienteRepository.findById(dto.getIdCliente());

            if (cliente != null) {

                cliente.setNome(dto.getNome());
                cliente.setEmail(dto.getEmail());
                cliente.setCpf(dto.getCpf());
                cliente.setTelefone(dto.getTelefone());
                cliente.setObservacoes(dto.getObservacoes());

                clienteRepository.update(cliente);

                return "Cliente atualizado com sucesso.";
            }
            else {
                return "Cliente não encontrado";
            }

        } catch (Exception e) {
            return "Erro : " + e.getMessage();
        }
    }

    @DeleteMapping
    public String delete() {
        //TODO
        return null;
    }

    @GetMapping
    public String getAll() {
        //TODO
        return null;
    }
}