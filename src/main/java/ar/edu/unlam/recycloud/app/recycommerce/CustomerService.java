package ar.edu.unlam.recycloud.app.recycommerce;

import ar.edu.unlam.recycloud.app.usuario.Usuario;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerBuilder customerBuilder;
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerBuilder customerBuilder, CustomerRepository customerRepository) {
        this.customerBuilder = customerBuilder;
        this.customerRepository = customerRepository;
    }

    public void save(Usuario usuario) {
        this.customerRepository.create(this.customerBuilder.build(usuario));
    }

    public String getSession(Usuario usuario) {
        return this.customerRepository.getSession(this.customerBuilder.build(usuario));
    }
}
