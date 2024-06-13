package uz.pdp.g34commentservice;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import uz.pdp.g34commentservice.entity.Comment;
import uz.pdp.g34commentservice.repo.CommentRepository;

@SpringBootApplication
public class G34CommentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(G34CommentServiceApplication.class, args);
    }


    public CommandLineRunner commandLineRunner(CommentRepository commentRepository) {
        return args -> {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Comment[]> response = restTemplate.exchange(
                    "https://jsonplaceholder.typicode.com/comments",
                    HttpMethod.GET,
                    null,
                    Comment[].class
            );

            if (response.getStatusCode() == HttpStatus.OK) {
                Comment[] comments = response.getBody();
                commentRepository.saveAll(List.of(comments));
            }
        };
    }

}
