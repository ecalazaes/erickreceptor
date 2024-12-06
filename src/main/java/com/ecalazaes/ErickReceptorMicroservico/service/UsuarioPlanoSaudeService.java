package com.ecalazaes.ErickReceptorMicroservico.service;

import com.ecalazaes.ErickReceptorMicroservico.entities.UsuarioPlanoSaude;
import com.ecalazaes.ErickReceptorMicroservico.repositories.UsuarioPlanoSaudeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioPlanoSaudeService {

    @Autowired
    private UsuarioPlanoSaudeRepository repository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "fila.usuarios")
    public void consumirUsuario(String usuarioJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            UsuarioPlanoSaude usuario = objectMapper.readValue(usuarioJson, UsuarioPlanoSaude.class);
            repository.save(usuario);
            System.out.println("Usuário salvo no banco: " + usuario);
        } catch (Exception e) {
            System.err.println("Erro ao processar mensagem: " + e.getMessage());
        }
    }
}
