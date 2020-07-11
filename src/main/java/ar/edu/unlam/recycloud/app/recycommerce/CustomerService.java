package ar.edu.unlam.recycloud.app.recycommerce;

import ar.edu.unlam.recycloud.app.usuario.Login;
import ar.edu.unlam.recycloud.app.usuario.Usuario;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<String> login(Login usuario) {
        return this.customerRepository.login(this.customerBuilder.buildCredentials(usuario));
    }

    public ResponseEntity<String> login(Usuario usuario) {
        return this.customerRepository.login(this.customerBuilder.buildCredentials(usuario));
    }
}
