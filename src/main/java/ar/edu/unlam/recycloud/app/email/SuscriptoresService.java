package ar.edu.unlam.recycloud.app.email;

import org.springframework.stereotype.Service;

@Service
public class SuscriptoresService {

    private final SuscriptoresRepository suscriptoresRepository;
    private final EmailService emailService;

    public SuscriptoresService(SuscriptoresRepository suscriptoresRepository, EmailService emailService) {
        this.suscriptoresRepository = suscriptoresRepository;
        this.emailService = emailService;
    }

    public void verificarSiYaExiste(String email){
        if(suscriptoresRepository.verificarSiYaExiste(email) == null){
            Suscriptores s = new Suscriptores();
            s.setEmail(email);
            suscriptoresRepository.save(s);
            emailService.sendEmail(email,"Suscripción a RecyCloud", "Gracias por suscribirte a RecyCloud");
        }
    }
}
