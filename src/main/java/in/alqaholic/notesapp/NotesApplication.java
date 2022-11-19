package in.alqaholic.notesapp;

import java.util.HashMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class NotesApplication {

  @RestController
  class TestController {
    @GetMapping("/api/me")
    public ResponseEntity<?> testAuth() {
      var result = new HashMap<>();

      return ResponseEntity.ok(result);
    }
  }

  public static void main(String[] args) {
    SpringApplication.run(NotesApplication.class, args);
  }
}
