import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Restaurant {
  public String name;
  public String cuisine;
  public String hours;
  public String address;
  public String price;
  public int id;

  public Restaurant (String name, String cuisine, String hours, String address, String price) {
    this.name = name;
    this.cuisine = cuisine;
    this.hours = hours;
    this.address = address;
    this.price = price;
    this.save();
  }

  public String getName() {
    return name;
  }

  public String getCuisine() {
    return cuisine;
  }

  public String getHours() {
    return hours;
  }

  public String getAddress() {
    return address;
  }

  public String getPrice() {
    return price;
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object otherRestaurant) {
    if(!(otherRestaurant instanceof Restaurant)) {
      return false;
    } else {
      Restaurant newRestaurant = (Restaurant) otherRestaurant;
      return this.getName().equals(newRestaurant.getName()) && this.getCuisine().equals(newRestaurant.getCuisine()) && this.getHours().equals(newRestaurant.getHours()) && this.getAddress().equals(newRestaurant.getAddress()) && this.getPrice().equals(newRestaurant.getPrice());
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO restaurant (name, cuisine, hours, address, price) VALUES (:name, :cuisine, :hours, :address, :price)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("cuisine", this.cuisine)
        .addParameter("hours", this.hours)
        .addParameter("address", this.address)
        .addParameter("price", this.price)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Restaurant> all() {
    String sql = "SELECT * FROM restaurant;";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(Restaurant.class);
    }
  }

  public static Restaurant find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM restaurant where id=:id";
      Restaurant restaurant = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Restaurant.class);
        return restaurant;
    }
  }


}
