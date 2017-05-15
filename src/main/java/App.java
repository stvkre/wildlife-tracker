import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        // This tells our app that if Heroku sets a port for us, we need to use that port.
        // Otherwise, if they do not, continue using port 4567.

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        setPort(port);

// get information about animals from index.vtl
     get("/", (req, res) -> {
       Map<String, Object> model = new HashMap<>();
       model.put("animals", Animal.allAnimals());
       model.put("template", "templates/index/vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());
  }
}
