import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.math.*;


public class MenuItem {
  private int id;
  private int restaurantId;
  private double price;
  private String itemName;

  public MenuItem(int restaurantId, double price, String itemName, int id){
    this.restaurantId = restaurantId;
    this.price = price;
    this.itemName = itemName;
    this.id = id;
  }

  public int getRestaurantId(){
    return restaurantId;
  }

  public double getPrice(){
    return price;
  }

  public String getItemName(){
    return itemName;
  }

  public int getId(){
    return id;
  }

  @Override
  public boolean equals(Object otherMenuItem) {
    if(!(otherMenuItem instanceof MenuItem)) {
      return false;
    } else {
      MenuItem newMenuItem = (MenuItem) otherMenuItem;
      return this.getItemName().equals(newMenuItem.getItemName()) && this.getRestaurantId() == (newMenuItem.getRestaurantId()) &&
      this.getPrice() == (newMenuItem.getPrice()) &&
      this.getId() == (newMenuItem.getId());
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO menuitems (restaurantId, price, itemName, id) VALUES (:restaurantId, :price, :itemName, :id)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("restaurantId", this.restaurantId)
        .addParameter("price", this.price)
        .addParameter("itemName", this.itemName)
        .addParameter("id", this.id)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<MenuItem> all() {
    String sql = "SELECT * FROM menuitems;";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(MenuItem.class);
    }
  }

  public static MenuItem find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM menuitems where id=:id";
      MenuItem menuItem = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(MenuItem.class);
        return menuItem;
    }
  }

  public static List<MenuItem> findByRestaurant(int restaurantId) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM menuitems where restaurantId = :restaurantId";
      List<MenuItem> menuItem = con.createQuery(sql)
        .addParameter("restaurantId", restaurantId)
        .executeAndFetch(MenuItem.class);
        return menuItem;
    }
  }


  // public static List<MenuItem> findByRestaurant(int restaurantId) {
  //   String sql = "SELECT * FROM menuitems where restaurantid = :restaurantId;";
  //   try(Connection con = DB.sql2o.open()) {
  //     return con.createQuery(sql)
  //     .throwOnMappingFailure(false)
  //     .executeAndFetch(MenuItem.class);
  //   }
  // }

  public void delete() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "delete from menuitems where id = :id;";
        con.createQuery(sql)
          .addParameter("id", this.id)
          .executeUpdate();
      }
    }
}
