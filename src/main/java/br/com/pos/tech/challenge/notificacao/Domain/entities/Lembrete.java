package br.com.pos.tech.challenge.notificacao.Domain.entities;

public record Lembrete(
        String consultaId,
        String pacienteId,
        String dataHora,
        String mensagem
) {}