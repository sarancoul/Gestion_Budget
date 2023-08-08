package com.gestionBudget.tpBudget.emailConfig;

public interface IEmailService {

    // envoyer un simple email
    String sendSimpleMail(EmailDetails details);
}
