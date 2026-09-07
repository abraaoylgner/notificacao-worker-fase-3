package br.com.pos.tech.challenge.notificacao.Application.usecases;

import br.com.pos.tech.challenge.notificacao.Application.ports.EnviarNotificacaoPort;
import br.com.pos.tech.challenge.notificacao.Domain.entities.Lembrete;

public class ProcessarLembreteUseCase {

    private final EnviarNotificacaoPort enviarNotificacaoPort;

    public ProcessarLembreteUseCase(EnviarNotificacaoPort enviarNotificacaoPort) {
        this.enviarNotificacaoPort = enviarNotificacaoPort;
    }

    public void executar(String consultaId, String pacienteId, String dataHora, String mensagem) {
        if (consultaId == null || consultaId.isBlank() ||
                pacienteId == null || pacienteId.isBlank() ||
                dataHora == null || dataHora.isBlank()) {
            throw new IllegalArgumentException("Payload de notificação inválido: campos obrigatórios ausentes.");
        }

        Lembrete lembrete = new Lembrete(
                consultaId,
                pacienteId,
                dataHora,
                mensagem != null ? mensagem : "Lembrete de consulta agendada"
        );

        enviarNotificacaoPort.enviar(lembrete);
    }
}