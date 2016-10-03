import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;


public class CustomerTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void customer_instantiatesCorrectly_true() {
    Customer testCustomer = new Customer("Henry", "503-123-4567");
    assertEquals(true, testCustomer instanceof Customer);
  }
  @Test
  public void getCustomerName_customerInstantiatesWithName_Henry() {
  Customer testCustomer = new Customer("Henry", "503-123-4567");
  assertEquals("Henry", testCustomer.getCustomerName());
  }
  @Test
  public void getPhone_customerInstantiatesWithPhone_String() {
  Customer testCustomer = new Customer("Henry", "503-123-4567");
  assertEquals( "503-123-4567", testCustomer.getPhone());
  }
  @Test
  public void equals_returnsTrueIfNameAndPhoneAreSame_true() {
    Customer firstCustomer = new Customer("Henry", "503-123-4567");
    Customer anotherCustomer = new Customer("Henry", "503-123-4567");
    assertTrue(firstCustomer.equals(anotherCustomer));
  }
  @Test
  public void save_insertsObjectIntoDatabase_Customer() {
    Customer testCustomer = new Customer("Henry", "503-123-4567");
    testCustomer.save();
    assertTrue(Customer.all().get(0).equals(testCustomer));
  }
  @Test
  public void all_returnsAllInstancesOfCustomer_true() {
    Customer firstCustomer = new Customer("Henry", "503-123-4567");
    firstCustomer.save();
    Customer secondCustomer = new Customer("Harriet", "503-321-7654");
    secondCustomer.save();
    assertEquals(true, Customer.all().get(0).equals(firstCustomer));
    assertEquals(true, Customer.all().get(1).equals(secondCustomer));
  }
  @Test
   public void save_assignsIdToObject() {
     Customer testCustomer = new Customer("Henry", "503-123-4567");
     testCustomer.save();
     Customer savedCustomer = Customer.all().get(0);
     assertEquals(testCustomer.getId(), savedCustomer.getId());
   }
   @Test
    public void find_returnsCustomerWithSameId_secondCustomer() {
      Customer firstCustomer = new Customer("Henry", "503-123-4567");
      firstCustomer.save();
      Customer secondCustomer = new Customer("Harriet", "503-321-7654");
      secondCustomer.save();
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
