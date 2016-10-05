import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;


public class CustomerTest {
  private Customer testCustomer;
  private Customer firstCustomer;
  private Customer secondCustomer;

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void initialize() {
  testCustomer = new Customer("Henry", "503-123-4567", "Beaverton, Oregon");
  testCustomer.save();
  firstCustomer = new Customer("Bennett", "422-982-9375", "Portland");
  firstCustomer.save();
  secondCustomer = new Customer("Harriet", "503-321-7654", "McMinnville, Oregon");
  secondCustomer.save();
  }

  @Test
  public void customer_instantiatesCorrectly_true() {
    assertEquals(true, testCustomer instanceof Customer);
  }

  @Test
  public void getCustomerName_customerInstantiatesWithName_Henry() {
  assertEquals("Henry", testCustomer.getCustomerName());
  }

  @Test
  public void getPhone_customerInstantiatesWithPhone_String() {
  assertEquals( "503-123-4567", testCustomer.getPhone());
  }

  @Test
  public void equals_returnsTrueIfNameAndPhoneAreSame_true() {
    Customer anotherCustomer = new Customer("Henry", "503-123-4567", "Beaverton, Oregon");
    assertTrue(testCustomer.equals(anotherCustomer));
  }

  @Test
  public void save_insertsObjectIntoDatabase_Customer() {
    assertTrue(Customer.all().get(0).equals(testCustomer));
  }

  @Test
  public void all_returnsAllInstancesOfCustomer_true() {
    assertEquals(true, Customer.all().get(0).equals(testCustomer));
    assertEquals(true, Customer.all().get(1).equals(secondCustomer));
  }

  @Test
   public void save_assignsIdToObject() {
     Customer savedCustomer = Customer.all().get(0);
     assertEquals(testCustomer.getId(), savedCustomer.getId());
   }

   @Test
    public void find_returnsCustomerWithSameId_secondCustomer() {
      assertEquals(Customer.find(secondCustomer.getId()), secondCustomer);
  }
    // @Test
    // public void saveOrderTime_recordsOrderTimeOfCreationInDatabase() {
    //  Customer testCustomer = new Customer("Henry", "503-123-4567");
    //  testCustomer.save();
    //  Timestamp savedCustomerOrderTime = Customer.find(testCustomer.getId()).getOrderTime();
    //  Timestamp rightNow = new Timestamp(new Date().getTime());
    //  assertEquals(rightNow.getDay(), savedCustomerOrderTime.getDay());
    // }

}
