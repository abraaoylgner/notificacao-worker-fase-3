package br.com.pos.tech.challenge.notificacao.Adapters.notificadores;

import br.com.pos.tech.challenge.notificacao.Application.ports.EnviarNotificacaoPort;
import br.com.pos.tech.challenge.notificacao.Domain.entities.Lembrete;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SimuladorNotificacaoAdapter implements EnviarNotificacaoPort {

    @Override
    public void enviar(Lembrete lembrete) {
        log.info("=========================================");
        log.info("🔔 DISPARANDO NOTIFICAÇÃO...");
        log.info("ID do Paciente: {}", lembrete.pacienteId());
        log.info("Sua consulta ({}) está agendada para: {}", lembrete.consultaId(), lembrete.dataHora());
        log.info("Status: {}", lembrete.mensagem());
        log.info("✅ E-mail/SMS enviado com sucesso!");
        log.info("=========================================");
    }
}