package br.com.pos.tech.challenge.notificacao.Adapters.mensageria;

import br.com.pos.tech.challenge.notificacao.Adapters.dtos.NotificacaoPayloadDto;
import br.com.pos.tech.challenge.notificacao.Application.usecases.ProcessarLembreteUseCase;
import br.com.pos.tech.challenge.notificacao.Infrastructure.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoConsumer {

    private final ProcessarLembreteUseCase processarLembreteUseCase;

    public NotificacaoConsumer(ProcessarLembreteUseCase processarLembreteUseCase) {
        this.processarLembreteUseCase = processarLembreteUseCase;
    }

    @RabbitListener(queues = RabbitMQConfig.FILA_NOTIFICACOES)
    public void receberNotificacao(NotificacaoPayloadDto payload) {
        processarLembreteUseCase.executar(
                payload.consultaId(),
                payload.pacienteId(),
                payload.dataHora(),
                payload.mensagem()
        );
    }
}