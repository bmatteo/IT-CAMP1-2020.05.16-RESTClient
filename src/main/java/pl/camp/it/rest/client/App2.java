package pl.camp.it.rest.client;

import org.springframework.web.client.RestTemplate;
import pl.camp.it.rest.client.model.User;

import java.util.HashMap;
import java.util.Map;

public class App2 {
    public static void main(String[] args) {
        String url = "http://localhost:8080/getUser2";

        RestTemplate restTemplate = new RestTemplate();


        User user = restTemplate.getForObject(url,
                User.class,
                new HashMap<>());

        System.out.println(user.getLogin());
        System.out.println(user.getPass());
    }
}
