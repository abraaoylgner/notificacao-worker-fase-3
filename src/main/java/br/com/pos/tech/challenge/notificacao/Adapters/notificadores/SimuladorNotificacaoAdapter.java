package br.com.pos.tech.challenge.notificacao.Adapters.notificadores;

import br.com.pos.tech.challenge.notificacao.Application.ports.EnviarNotificacaoPort;
import br.com.pos.tech.challenge.notificacao.Domain.entities.Lembrete;
import org.springframework.stereotype.Component;

@Component
public class SimuladorNotificacaoAdapter implements EnviarNotificacaoPort {

    @Override
    public void enviar(Lembrete lembrete) {
        System.out.println("=========================================");
        System.out.println("🔔 DISPARANDO NOTIFICAÇÃO...");
        System.out.println("ID do Paciente: " + lembrete.pacienteId());
        System.out.println("Sua consulta (" + lembrete.consultaId() + ") está agendada para: " + lembrete.dataHora());
        System.out.println("Status: " + lembrete.mensagem());
        System.out.println("✅ E-mail/SMS enviado com sucesso!");
        System.out.println("=========================================");
    }
}