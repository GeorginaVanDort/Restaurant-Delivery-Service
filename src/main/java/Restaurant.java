import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import org.sql2o.*;

public class Restaurant {
  public String name;
  public String cuisine;
  public String hours;
  public String address;
  public String price;
  public int restaurantid;

  public Restaurant (String name, String cuisine, String hours, String address, String price, int restaurantid) {
    this.name = name;
    this.cuisine = cuisine;
    this.hours = hours;
    this.address = address;
    this.price = price;
    this.restaurantid = restaurantid;
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

  public int getResId() {
    return restaurantid;
  }


  @Override
  public boolean equals(Object otherRestaurant) {
    if(!(otherRestaurant instanceof Restaurant)) {
      return false;
    } else {
      Restaurant newRestaurant = (Restaurant) otherRestaurant;
      return this.getName().equals(newRestaurant.getName()) && this.getCuisine().equals(newRestaurant.getCuisine()) && this.getHours().equals(newRestaurant.getHours()) && this.getAddress().equals(newRestaurant.getAddress()) && this.getPrice().equals(newRestaurant.getPrice()) &&
      this.getResId() == newRestaurant.getResId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO restaurants(name, cuisine, hours, address, price, id) VALUES (:name, :cuisine, :hours, :address, :price, :restaurantid);";
        con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("cuisine", this.cuisine)
        .addParameter("hours", this.hours)
        .addParameter("address", this.address)
        .addParameter("price", this.price)
        .addParameter("restaurantid", this.restaurantid)
        .executeUpdate();
    }
  }

  public static List<Restaurant> all() {
    String sql = "SELECT * FROM restaurants;";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(Restaurant.class);
    }
  }

  public static Restaurant find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM restaurants where id=:id";
      Restaurant restaurant = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Restaurant.class);
        return restaurant;
    }
  }

  public void delete() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "delete from restaurants where id=:restaurantid;";
        con.createQuery(sql)
          .addParameter("restaurantid", this.restaurantid)
          .executeUpdate();
      }
    }
}
