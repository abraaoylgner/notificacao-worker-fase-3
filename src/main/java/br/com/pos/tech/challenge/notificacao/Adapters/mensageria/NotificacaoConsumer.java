package br.com.pos.tech.challenge.notificacao.Adapters.mensageria;

import br.com.pos.tech.challenge.notificacao.Application.usecases.ProcessarLembreteUseCase;
import br.com.pos.tech.challenge.notificacao.Infrastructure.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotificacaoConsumer {

    private final ProcessarLembreteUseCase processarLembreteUseCase;

    public NotificacaoConsumer(ProcessarLembreteUseCase processarLembreteUseCase) {
        this.processarLembreteUseCase = processarLembreteUseCase;
    }

    @RabbitListener(queues = RabbitMQConfig.FILA_NOTIFICACOES)
    public void receberNotificacao(Map<String, Object> payload) {
        // O Consumer atua apenas como um "Controller" de mensageria.
        // Ele recebe o dado e repassa para o caso de uso.
        processarLembreteUseCase.executar(payload);
    }
}