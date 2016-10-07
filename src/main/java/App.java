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
      // List<MenuItem> restaurantMenu = MenuItem.findByRestaurant(2);
      // model.put("menuitems", restaurantMenu);
      model.put("menuitems", MenuItem.all());
      model.put("template", "templates/Orderforms.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/new-order", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String phone = request.queryParams("phone");
      String address = request.queryParams("address");
      // int restaurantid = Integer.parseInt(request.queryParams("restaurantid"));
      Customer newCustomer = new Customer(name, phone, address);
      newCustomer.save();
        model.put("menuitems", MenuItem.all());
      model.put("Customer", newCustomer);
      model.put("template", "templates/Orderforms.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

   }
}
