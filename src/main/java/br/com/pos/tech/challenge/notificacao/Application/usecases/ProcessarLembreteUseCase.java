package br.com.pos.tech.challenge.notificacao.Application.usecases;

import br.com.pos.tech.challenge.notificacao.Application.ports.EnviarNotificacaoPort;
import br.com.pos.tech.challenge.notificacao.Domain.entities.Lembrete;

import java.util.Map;

public class ProcessarLembreteUseCase {

    private final EnviarNotificacaoPort enviarNotificacaoPort;

    public ProcessarLembreteUseCase(EnviarNotificacaoPort enviarNotificacaoPort) {
        this.enviarNotificacaoPort = enviarNotificacaoPort;
    }

    public void executar(Map<String, Object> payload) {
        // Converte o payload genérico da mensageria para a entidade de Domínio
        Lembrete lembrete = new Lembrete(
                String.valueOf(payload.get("consultaId")),
                String.valueOf(payload.get("pacienteId")),
                String.valueOf(payload.get("dataHora")),
                String.valueOf(payload.get("mensagem"))
        );

        // Chama a porta de saída para efetivar o envio
        enviarNotificacaoPort.enviar(lembrete);
    }
}