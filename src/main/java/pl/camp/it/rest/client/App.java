package pl.camp.it.rest.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import pl.camp.it.rest.client.model.ResponseMessage;
import pl.camp.it.rest.client.model.User;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class App {
    public static void main(String[] args) {
        String url = "http://localhost:8080/user";

        RestTemplate restTemplate = new RestTemplate();

        /*ResponseMessage responseMessage = restTemplate.getForObject(url,
                ResponseMessage.class,
                new HashMap<>());

        System.out.println(responseMessage.getMessage());
        System.out.println(responseMessage.getStatusCode());
        Object o = responseMessage.getContent();
        LinkedHashMap mapa = (LinkedHashMap) o;
        System.out.println(mapa.get("login"));*/

        ResponseMessage<User> response = restTemplate.exchange(url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ResponseMessage<User>>() {}).getBody();

        System.out.println(response.getContent().getLogin());
    }
}
