package br.com.pos.tech.challenge.notificacao.Infrastructure.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FILA_NOTIFICACOES = "notificacoes.fila";
    public static final String FILA_NOTIFICACOES_DLQ = "notificacoes.fila.dlq";
    public static final String EXCHANGE_DLX = "notificacoes.dlx";
    public static final String ROUTING_KEY_DLQ = "notificacoes.dlq.rk";

    @Bean
    public Queue filaNotificacoes() {
        return QueueBuilder.durable(FILA_NOTIFICACOES)
                .deadLetterExchange(EXCHANGE_DLX)
                .deadLetterRoutingKey(ROUTING_KEY_DLQ)
                .build();
    }

    @Bean
    public Queue filaNotificacoesDlq() {
        return QueueBuilder.durable(FILA_NOTIFICACOES_DLQ).build();
    }

    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(EXCHANGE_DLX);
    }

    @Bean
    public Binding deadLetterBinding() {
        return BindingBuilder.bind(filaNotificacoesDlq())
                .to(deadLetterExchange())
                .with(ROUTING_KEY_DLQ);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}