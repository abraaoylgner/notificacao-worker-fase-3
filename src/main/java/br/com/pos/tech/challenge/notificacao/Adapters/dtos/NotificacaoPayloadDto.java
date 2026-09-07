package br.com.pos.tech.challenge.notificacao.Adapters.dtos;

public record NotificacaoPayloadDto(
        String consultaId,
        String pacienteId,
        String dataHora,
        String mensagem
) {}