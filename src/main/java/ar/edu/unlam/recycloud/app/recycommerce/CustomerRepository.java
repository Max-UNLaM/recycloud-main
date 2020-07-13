package ar.edu.unlam.recycloud.app.recycommerce;

import ar.edu.unlam.recycloud.app.recycommerce.models.Customer;
import ar.edu.unlam.recycloud.app.recycommerce.models.CustomerLogin;
import com.google.gson.Gson;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static ar.edu.unlam.recycloud.conf.ConfigConstants.RECYCOMMERCE_HOST_KEY;

@Service
public class CustomerRepository {

    private static final String USER_PATH = "/api/v1/user/";
    private static final String LOGIN_PATH = "/index.php?route=account/login";
    private final String RECYCOMMERCE_HOST;
    private final Gson gson;

    public CustomerRepository(Environment environment, Gson gson) {
        this.RECYCOMMERCE_HOST = environment.getProperty(RECYCOMMERCE_HOST_KEY);
        this.gson = gson;
    }

    public void create(Customer usuario) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String request = gson.toJson(usuario);
        HttpEntity<String> entity = new HttpEntity<>(request, headers);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(
                RECYCOMMERCE_HOST + USER_PATH, entity, String.class
        );
    }

    public ResponseEntity<String> login(CustomerLogin credentials) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        final CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setRedirectStrategy(new LaxRedirectStrategy())
                .build();
        factory.setHttpClient(httpClient);
        restTemplate.setRequestFactory(factory);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("email", credentials.getEmail());
        map.add("password", credentials.getPassword());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        return restTemplate.postForEntity(RECYCOMMERCE_HOST + LOGIN_PATH, request, String.class);
    }
}
