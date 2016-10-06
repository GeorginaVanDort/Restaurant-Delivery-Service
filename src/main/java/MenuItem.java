import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.math.*;


public class MenuItem {
  private int id;
  private String itemName;
  private int restaurantId;
  private double price;

  public MenuItem(String itemName, int restaurantId, double price){
    this.itemName = itemName;
    this.restaurantId = restaurantId;
    this.price = price;
  }

  public String getItemName(){
    return itemName;
  }

  public int getRestaurantId(){
    return restaurantId;
  }

  public double getPrice(){
    return price;
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
      return this.getItemName().equals(newMenuItem.getItemName()) && this.getRestaurantId() == (newMenuItem.getRestaurantId());
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO menuitems (itemName, restaurantId, price) VALUES (:itemName, :restaurantId, :price)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("itemName", this.itemName)
        .addParameter("restaurantId", this.restaurantId)
        .addParameter("price", this.price)
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
    String sql = "SELECT * FROM menuitems where restaurantid = :restaurantId;";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(MenuItem.class);
    }
  }
  
  public void delete() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "delete from menuitems where id = :id;";
        con.createQuery(sql)
          .addParameter("id", this.id)
          .executeUpdate();
      }
    }
}
