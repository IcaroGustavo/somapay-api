package br.com.somapay.desafio.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.somapay.desafio.config.EmailAMQPConfig;
import br.com.somapay.desafio.dto.EmailDto;
import br.com.somapay.desafio.dto.TransferenciaDto;
import br.com.somapay.desafio.exception.EmailNaoEnviadoException;

@Service
public class EmailService {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviaEmail(TransferenciaDto transferenciaDto) {
        try {

            EmailDto emailDto = new EmailDto();
            emailDto.setEmailFrom("canalteuprimo@gmail.com");
            emailDto.setEmailTo("icarogustavo.dev@gmail.com");
            emailDto.setOwnerRef("SOMAPAY");
            emailDto.setSubject("Transferência Recebida!");
            emailDto.setText("Olá! Você recebeu R$: " + transferenciaDto.getValor());

            String json = new ObjectMapper().writeValueAsString(emailDto);
            rabbitTemplate.convertAndSend(EmailAMQPConfig.EXCHANGE_NAME, "", json);

        } catch (Exception e) {
            System.out.println(e.getCause());
            throw new EmailNaoEnviadoException();
        }
    }
}
