package in.alqaholic.notesapp;

import java.util.HashMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {ReactiveUserDetailsServiceAutoConfiguration.class})
public class NotesApplication {

  @RestController
  class TestController {
    @GetMapping("/api/me")
    public ResponseEntity<?> testAuth(
        @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
        @AuthenticationPrincipal OAuth2User oauth2User) {
      var result = new HashMap<>();

      result.put("userName", oauth2User.getName());
      result.put("clientName", authorizedClient.getClientRegistration().getClientName());
      result.put("userAttributes", oauth2User.getAttributes());

      return ResponseEntity.ok(result);
    }
  }

  public static void main(String[] args) {
    SpringApplication.run(NotesApplication.class, args);
  }
}
