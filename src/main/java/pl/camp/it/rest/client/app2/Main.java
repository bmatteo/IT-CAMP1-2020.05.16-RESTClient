package pl.camp.it.rest.client.app2;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.camp.it.rest.client.app2.model.Post;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String urlGet = "https://jsonplaceholder.typicode.com/posts";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Post>> responseEntity;

        responseEntity = restTemplate.exchange(urlGet,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Post>>() {});

        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getStatusCodeValue());
        System.out.println(responseEntity.getHeaders());
        System.out.println(responseEntity.getBody().get(0));

        String urlPost = "https://jsonplaceholder.typicode.com/posts";

        Post postToSend = new Post();
        postToSend.setUserId(10);
        postToSend.setTitle("Java CAMP");
        postToSend.setBody("Rest API");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-type", "application/json; charset=UTF-8");

        HttpEntity<Post> request = new HttpEntity<>(postToSend, httpHeaders);

        ResponseEntity<Post> postResponse = restTemplate.exchange(urlPost,
                HttpMethod.POST,
                request,
                Post.class);

        System.out.println(postResponse.getStatusCode());
        System.out.println(postResponse.getHeaders());
        System.out.println(postResponse.getBody());
    }
}
