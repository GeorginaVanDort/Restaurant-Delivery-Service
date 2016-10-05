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
  private String phone;
  private String address;
  private int id;

  public Customer(String customerName, String phone, String address) {
    this.customerName = customerName;
    this.phone = phone;
    this.address = address;
  }
  public String getCustomerName(){
    return customerName;
  }

  public String getPhone(){
    return phone;
  }

  public int getId(){
    return id;
  }

  public String getAddress(){
    return address;
  }


  @Override
  public boolean equals(Object otherCustomer){
   if (!(otherCustomer instanceof Customer)) {
     return false;
   } else {
     Customer newCustomer = (Customer) otherCustomer;
     return this.getCustomerName().equals(newCustomer.getCustomerName()) &&
            this.getPhone().equals(newCustomer.getPhone());
   }
 }

 public static List<Customer> all() {
    String sql = "SELECT * FROM customers";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Customer.class);
    }
  }

  public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO customers (customername, phone) VALUES (:customername, :phone)";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("customername", this.customerName)
      .addParameter("phone", this.phone)
      .addParameter("address", this.address)
      .executeUpdate()
      .getKey();
    }
  }

  public static Customer find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM customers where id=:id";
      Customer customer = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Customer.class);
      return customer;
    }
  }
}
