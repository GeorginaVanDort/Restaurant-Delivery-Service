import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import spark.ModelAndView;
import java.sql.Timestamp;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/CasaLola", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/CasaLola.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/orderform", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Restaurant newRestaurant = new Restaurant("happyHouse", "Chinese", "Late Night", "ChinaTown", "$$");
      newRestaurant.save();
      model.put("restaurant", newRestaurant);
      model.put("template", "templates/Orderforms.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());





  }
}
