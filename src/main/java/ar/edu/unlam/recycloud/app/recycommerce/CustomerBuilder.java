package ar.edu.unlam.recycloud.app.recycommerce;

import ar.edu.unlam.recycloud.app.recycommerce.models.Customer;
import ar.edu.unlam.recycloud.app.recycommerce.models.CustomerLogin;
import ar.edu.unlam.recycloud.app.usuario.Login;
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

    public CustomerLogin buildCredentials(Login usuario) {
        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.setEmail(usuario.getEmail());
        customerLogin.setPassword(usuario.getPassword());
        return customerLogin;
    }

    public CustomerLogin buildCredentials(Usuario usuario) {
        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.setEmail(usuario.getEmail());
        customerLogin.setPassword(usuario.getPassword());
        return customerLogin;
    }

}
