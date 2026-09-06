package br.com.pos.tech.challenge.notificacao.Application.ports;

import br.com.pos.tech.challenge.notificacao.Domain.entities.Lembrete;

public interface EnviarNotificacaoPort {
    void enviar(Lembrete lembrete);
}