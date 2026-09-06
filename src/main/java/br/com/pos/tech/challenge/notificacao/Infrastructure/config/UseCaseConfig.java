package br.com.pos.tech.challenge.notificacao.Infrastructure.config;

import br.com.pos.tech.challenge.notificacao.Application.ports.EnviarNotificacaoPort;
import br.com.pos.tech.challenge.notificacao.Application.usecases.ProcessarLembreteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public ProcessarLembreteUseCase processarLembreteUseCase(EnviarNotificacaoPort enviarNotificacaoPort) {
        return new ProcessarLembreteUseCase(enviarNotificacaoPort);
    }
}