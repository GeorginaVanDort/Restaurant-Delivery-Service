import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class Customer {
  private String customerName;
  private String customerPhone;
  private String customerAddress;
  private Timestamp orderTime;
  private int id;


  public Customer(String customerName, String customerPhone, String customerAddress){
    this.customerName = customerName;
    this.customerPhone = customerPhone;
    this.customerAddress = customerAddress;
    this.orderTime = orderTime;

  }
  public String getCustomerName(){
    return customerName;
  }

  public String getCustomerPhone(){
    return customerPhone;
  }

  public int getId(){
    return id;
  }

  public String getCustomerAddress(){
    return customerAddress;
  }

  public Timestamp getOrderTime(){
    return orderTime;
  }

  @Override
  public boolean equals(Object otherCustomer){
   if (!(otherCustomer instanceof Customer)) {
     return false;
   } else {
     Customer newCustomer = (Customer) otherCustomer;
     return this.getCustomerName().equals(newCustomer.getCustomerName()) &&
     this.getCustomerPhone().equals(newCustomer.getCustomerPhone());
   }
 }

 public static List<Customer> all() {
    String sql = "SELECT * FROM customerdetails";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Customer.class);
    }
  }

  public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO customerdetails (customername, customerphone, customeraddress, ordertime) VALUES (:customerName, :customerPhone, :customerAddress, now())";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("customerName", this.customerName)
      .addParameter("customerPhone", this.customerPhone)
      .addParameter("customerAddress", this.customerAddress)
      .throwOnMappingFailure(false)
      .executeUpdate()
      .getKey();
    }
  }

  public static Customer find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM customerdetails where id=:id";
      Customer customer = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Customer.class);
      return customer;
    }
  }

  public void saveOrder() {
    
  }
}
