import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.math.*;


public class Order {
  private int id;
  private int menuid;
  private int quantity;
  private int customerid;
  private Timestamp ordertime;


  public Order(int menuid, int quantity, int customerid){
    this.menuid = menuid;
    this.quantity = quantity;
    this.customerid = customerid;
  }

  public int getMenuId(){
    return menuid;
  }

  public int getQuantity(){
    return quantity;
  }

  public int getCustomerId(){
    return customerid;
  }

  public Timestamp getOrdertime(){
    return ordertime;
  }

  public int getId(){
    return id;
  }

  @Override
  public boolean equals(Object otherOrder){
   if (!(otherOrder instanceof Order)) {
     return false;
   } else {
     Order newOrder = (Order) otherOrder;
     return this.getMenuId() == (newOrder.getMenuId()) &&
            this.getQuantity() == (newOrder.getQuantity()) &&
            this.getCustomerId() == (newOrder.getCustomerId());
   }
 }

 public static List<Order> all() {
    String sql = "SELECT * FROM orders";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Order.class);
    }
  }

  public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO orders (menuid, quantity, customerid, ordertime) VALUES (:menuid, :quantity, :customerid, now())";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("menuid", this.menuid)
      .addParameter("quantity", this.quantity)
      .addParameter("customerid", this.customerid)
      .executeUpdate()
      .getKey();
    }
  }

  public static Order find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM orders where id=:id";
      Order order = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Order.class);
      return order;
    }
  }

  public void delete() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "delete from orders where id = :id;";
        con.createQuery(sql)
          .addParameter("id", this.id)
          .executeUpdate();
      }
    }

  public void update(int menuid, int quantity, int customerid) {
    try (Connection con = DB.sql2o.open()){
      String sql = "update orders set menuid = :menuid, quantity = :quantity, customerid = :customerid where id=:id";
      con.createQuery(sql)
      .addParameter("menuid", menuid)
      .addParameter("quantity", quantity)
      .addParameter("customerid", customerid)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
}
