import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
  DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/food_delivery_test", null, null);
  }

  // @Override
  // protected void after() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String deleteMenuItemsQuery = "DELETE FROM menuitems *;";
  //     String deleteCustomersQuery = "DELETE FROM customerdetails *;";
  //     String deleteRestaurantsQuery = "DELETE FROM restaurants *;";
  //     con.createQuery(deleteRestaurantsQuery).executeUpdate();
  //     con.createQuery(deleteMenuItemsQuery).executeUpdate();
  //     con.createQuery(deleteCustomersQuery).executeUpdate();
  //   }
  // }
}
