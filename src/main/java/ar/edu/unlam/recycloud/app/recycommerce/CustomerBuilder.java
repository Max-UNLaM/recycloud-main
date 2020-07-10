package ar.edu.unlam.recycloud.app.recycommerce;

import ar.edu.unlam.recycloud.app.usuario.Usuario;
import org.springframework.stereotype.Service;

@Service
public class CustomerBuilder {

    public Customer build(Usuario usuario) {
        Customer customer = new Customer();
        customer.setFirstName(usuario.getNombre());
        customer.setLastName(usuario.getApellido());
        customer.setEmail(usuario.getEmail());
        customer.setPassword(usuario.getPassword());
        return customer;
    }

}
