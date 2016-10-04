import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class OrderTest {
  private Order testOrder;
  private Order firstOrder;
  private Order secondOrder;

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void initialize() {
  testOrder = new Order(1, 4, 7);
  testOrder.save();
  firstOrder = new Order(2, 5, 8);
  firstOrder.save();
  secondOrder = new Order(3, 6, 9);
  secondOrder.save();
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteOrdersQuery = "DELETE FROM orders *;";
      con.createQuery(deleteOrdersQuery).executeUpdate();
    }
  }

  @Test
  public void restaurant_instantiatesCorrectly_true() {
    assertEquals(true, testOrder instanceof Order);
  }

  @Test
  public void getMenuId_instantiatesCorrectly_true() {
    assertEquals(1, testOrder.getMenuId());
  }

  @Test
  public void getQuantity_instantiatesCorrectly_true() {
    assertEquals(4, testOrder.getQuantity());
  }

  @Test
  public void getCustomerId_instantiatesCorrectly_true() {
    assertEquals(7, testOrder.getCustomerId());
  }

  @Test
  public void getId_instantiatesCorrectly_true() {
    assertTrue(testOrder.getId() > 0);
  }

  @Test
  public void save_insertsObjectsIntoDB_Order() {
    assertEquals(true, Order.all().get(0).equals(testOrder));
  }

  @Test
  public void all_returnsAllInstancesOfOrder_true() {
    assertEquals(true, Order.all().size() > 0);
  }

  @Test
  public void save_assignsIdToObjects() {
    Order savedOrder = Order.all().get(0);
    assertEquals(testOrder.getId(), savedOrder.getId());
  }

  @Test
  public void find_returnsOrderWithCorrectId_True() {
    assertEquals(Order.find(testOrder.getId()), testOrder);
  }

  @Test
  public void delete_deletesOrders_true(){
    testOrder.delete();
    firstOrder.delete();
    secondOrder.delete();
    assertEquals(null, Order.find(testOrder.getId()));
  }

  @Test
  public void update_updatesClientDescription_true() {
    testOrder.update(3, 2, 1);
    assertEquals(3, Order.find(testOrder.getId()).getMenuId());
  }
}
