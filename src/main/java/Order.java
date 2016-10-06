import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.math.*;


public class Order {
  private int id;
  private int menuItemId;
  private int quantity;
  private double subtotal;

  public Order(int menuItemId, int quantity, double subtotal){
    this.menuItemId = menuItemId;
    this.quantity = quantity;
    this.subtotal = subtotal;
  }

  public int getMenuItemId(){
    return menuItemId;
  }

  public int getQuantity(){
    return quantity;
  }

  public int getId(){
    return id;
  }

  public double getSubtotal(){
    return subtotal;
  }


  @Override
  public boolean equals(Object otherOrder){
   if (!(otherOrder instanceof Order)) {
     return false;
   } else {
     Order newOrder = (Order) otherOrder;
     return this.getMenuItemId() == (newOrder.getMenuItemId()) &&
            this.getQuantity() == (newOrder.getQuantity()) &&
            this.getSubtotal() == (newOrder.getSubtotal());
   }
 }

 public static List<Order> all() {
    String sql = "SELECT * FROM ordereditems";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql)
     .throwOnMappingFailure(false)
     .executeAndFetch(Order.class);
    }
  }

  public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO ordereditems (menuitem_id, quantity, subtotal) VALUES (:menuItemId, :quantity, :subtotal)";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("menuItemId", this.menuItemId)
      .addParameter("quantity", this.quantity)
      .addParameter("subtotal", this.subtotal)
      .throwOnMappingFailure(false)
      .executeUpdate()
      .getKey();
    }
  }

  public static Order find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM ordereditems where id=:id";
      Order order = con.createQuery(sql)
      .addParameter("id", id)
      .throwOnMappingFailure(false)
      .executeAndFetchFirst(Order.class);
      return order;
    }
  }

  public void saveFinalOrder(Customer customer) {
    try(Connection con = DB.sql2o.open()) {
      String joinQuery = "insert into finalorders (ordereditems_id, customerdetails_id) values (:ordereditems_id, :customerdetails_id);";
      con.createQuery(joinQuery)
      .addParameter("id", this.getId())
      .addParameter("customerdetails_id", customer.getId())
      .addParameter("ordereditems_id", this.getId())
      .executeUpdate();
    }
  }

  // public List<Order> getOrderedItemsByCustomer() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "SELECT ordereditems.* FROM blogs JOIN blog_tag ON (blogs.id = blog_tag.blog_id) JOIN tags ON (blog_tag.tag_id = tags.id) WHERE blogs.id = :blog_id;";
  //     return con.createQuery(sql)
  //     .addParameter("blog_id", this.id)
  //     .executeAndFetch(Tag.class);
  //   }
  // }


  public void delete() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "delete from ordereditems where id = :id;";
        con.createQuery(sql)
          .addParameter("id", this.id)
          .executeUpdate();
      }
    }


  public void update(int menuid, int quantity, int customerid) {
    try (Connection con = DB.sql2o.open()){
      String sql = "update ordereditems set menuitem_id = :menuItemId, quantity = :quantity, subtotal = :subtotal where id=:id";
      con.createQuery(sql)
      .addParameter("menuItemId", menuItemId)
      .addParameter("quantity", quantity)
      .addParameter("subtotal", subtotal)
      .addParameter("id", id)
      .executeUpdate();
    }
  }


  // public List<Order> getOrdersByCustomerID() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "SELECT blogs.* FROM tags JOIN blog_tag ON (tags.id = blog_tag.tag_id) JOIN blogs ON (blog_tag.blog_id = blogs.id) WHERE tags.id = :tag_id";
  //     return con.createQuery(sql)
  //       .addParameter("tag_id", this.id)
  //       .executeAndFetch(Blog.class);
  //   }
  // }

//







}
