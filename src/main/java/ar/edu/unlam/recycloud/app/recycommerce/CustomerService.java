package ar.edu.unlam.recycloud.app.recycommerce;

import ar.edu.unlam.recycloud.app.usuario.Usuario;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import static ar.edu.unlam.recycloud.conf.ConfigConstants.RECYCOMMERCE_STATUS_KEY;

@Service
public class CustomerService {

    private final CustomerBuilder customerBuilder;
    private final CustomerRepository customerRepository;
    private final String RECYCOMMERCE_ENABLED;

    public CustomerService(CustomerBuilder customerBuilder, CustomerRepository customerRepository, Environment environment) {
        this.customerBuilder = customerBuilder;
        this.customerRepository = customerRepository;
        this.RECYCOMMERCE_ENABLED = environment.getProperty(RECYCOMMERCE_STATUS_KEY);
    }

    public void save(Usuario usuario) {
        if (this.RECYCOMMERCE_ENABLED.equals("enabled")) {
            this.customerRepository.create(this.customerBuilder.build(usuario));
        }
    }
}
