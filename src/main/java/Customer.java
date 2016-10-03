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
  // private Timestamp orderTime;
  private int id;

  public Customer(String customerName, String phone){
    this.customerName = customerName;
    this.phone = phone;
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
  // public Timestamp getOrderTime(){
  //   return orderTime;
  // }

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

  // public List<Object> getMonsters() {
  //   List<Object> allMonsters = new ArrayList<Object>();
  //
  //   try(Connection con = DB.sql2o.open()) {
  //     String sqlFire = "SELECT * FROM monsters WHERE customerId=:id AND type='fire';";
  //     List<FireMonster> fireMonsters = con.createQuery(sqlFire)
  //       .addParameter("id", this.id)
  //       .throwOnMappingFailure(false)
  //       .executeAndFetch(FireMonster.class);
  //     allMonsters.addAll(fireMonsters);
  //
  //
  //     String sqlWater = "SELECT * FROM monsters WHERE customerId=:id AND type='water';";
  //     List<WaterMonster> waterMonsters = con.createQuery(sqlWater)
  //       .addParameter("id", this.id)
  //       .throwOnMappingFailure(false)
  //       .executeAndFetch(WaterMonster.class);
  //     allMonsters.addAll(waterMonsters);
  //     }
  //     return allMonsters;
  // }


}