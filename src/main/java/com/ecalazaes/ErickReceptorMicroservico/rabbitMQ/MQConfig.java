package com.ecalazaes.ErickReceptorMicroservico.rabbitMQ;

import com.ecalazaes.ErickReceptorMicroservico.dto.UsuarioPlanoSaudeDTO;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MQConfig {
    @RabbitListener(queues = "Fila") // Nome da fila que você está ouvindo
    public void receberMensagem(@Payload UsuarioPlanoSaudeDTO usuarioPlanoSaudeDTO) {
        // Aqui você pode processar a mensagem
        System.out.println("Mensagem recebida: " + usuarioPlanoSaudeDTO.getNome());
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(AmqpAdmin amqpAdmin, Jackson2JsonMessageConverter jackson2JsonMessageConverter) {
        RabbitTemplate template = new RabbitTemplate();
        template.setMessageConverter(jackson2JsonMessageConverter);
        return template;
    }

}
