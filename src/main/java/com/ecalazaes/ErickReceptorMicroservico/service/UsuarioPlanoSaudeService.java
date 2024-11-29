package com.ecalazaes.ErickReceptorMicroservico.service;

import com.ecalazaes.ErickReceptorMicroservico.dto.UsuarioPlanoSaudeDTO;
import com.ecalazaes.ErickReceptorMicroservico.repositories.UsuarioPlanoSaudeRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioPlanoSaudeService {

    private UsuarioPlanoSaudeRepository repository;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public UsuarioPlanoSaudeService(UsuarioPlanoSaudeRepository repository, RabbitTemplate rabbitTemplate) {
        this.repository = repository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "Fila")
    private void subscribe(UsuarioPlanoSaudeDTO usuario){
        System.out.println(usuario.getNome());
    }
}
