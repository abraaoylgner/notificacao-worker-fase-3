package br.com.pos.tech.challenge.notificacao.Infrastructure.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FILA_NOTIFICACOES = "notificacoes.fila";

    @Bean
    public Queue filaNotificacoes() {
        return QueueBuilder.durable(FILA_NOTIFICACOES).build();
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}