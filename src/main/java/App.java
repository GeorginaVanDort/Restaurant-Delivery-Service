
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

    get("/Oasis", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/Oasis.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/Subs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/SubsStation.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/Decarlipage", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/Decarli.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/ThaiBloom", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/ThaiBloom.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/PhoVan", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/PhoVan.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/orderform", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Restaurant newRestaurant = new Restaurant("happyHouse", "Chinese", "Late Night", "ChinaTown", "$$", 2);
      newRestaurant.save();
      // MenuItem restaurantMenu = new MenuItem.find(MenuItem.all().getId())
      model.put("restaurant", newRestaurant);
      model.put("menuitems", MenuItem.all());
      model.put("template", "templates/Orderforms.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

   }
}
