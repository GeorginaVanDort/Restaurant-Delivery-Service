import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.math.*;


public class Order {
  private int id;
  private int menuid;
  private int quantity;
  private int cusotmerid;
  private Timestamp ordertime;


  public Order(int menuid, int quantity, int cusotmerid, Timestamp ordertime){
    this.menuid = menuid;
    this.quantity = quantity;
    this.cusotmerid = cusotmerid;
    this.ordertime = ordertime;
  }

  public int getMenuid(){
    return menuid;
  }

  public int getQuantity(){
    return quantity;
  }

  public int getCusotmerid(){
    return cusotmerid;
  }

  public Timestamp getOrdertime(){
    return ordertime;
  }

  public int getId(){
    return id;
  }

}
