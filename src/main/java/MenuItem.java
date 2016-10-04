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



}
