package ar.edu.unlam.recycloud.app.recycommerce;

import ar.edu.unlam.recycloud.app.utils.ResponseParser;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static ar.edu.unlam.recycloud.conf.ConfigConstants.RECYCOMMERCE_HOST_KEY;

@Service
public class CustomerRepository {

    private static final String USER_PATH = "/api/v1/user/";
    private final String RECYCOMMERCE_HOST;
    private final ResponseParser responseParser;

    public CustomerRepository(Environment environment, ResponseParser responseParser) {
        this.RECYCOMMERCE_HOST = environment.getProperty(RECYCOMMERCE_HOST_KEY);
        this.responseParser = responseParser;
    }

    public Customer create(Customer usuario) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(
                RECYCOMMERCE_HOST + USER_PATH, usuario, Customer.class
        );
    }

    public String getSession(Customer usuario) {
        return null;
    }
}
