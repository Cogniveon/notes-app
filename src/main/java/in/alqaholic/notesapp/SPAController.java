package in.alqaholic.notesapp;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SPAController {
  private String respondWithIndex(Model model)
      throws StreamReadException, DatabindException, IOException {
    // create ObjectMapper instance
    ObjectMapper mapper = new ObjectMapper();

    // read JSON file and convert it to a Map
    Map<?, ?> manifest =
        mapper.readValue(new ClassPathResource("manifest.json").getInputStream(), Map.class);

    model.addAttribute("manifest", manifest);
    return "index.html";
  }

  @RequestMapping(value = "/")
  public String index(final Model model)
      throws StreamReadException, DatabindException, IOException {
    return respondWithIndex(model);
  }

  @RequestMapping(value = "/{path:^(?!api|static).*}/**")
  public String indexPattern(final Model model)
      throws StreamReadException, DatabindException, IOException {
    return respondWithIndex(model);
  }
}
