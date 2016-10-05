import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;


public class CustomerTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  Customer customer = new Customer("Henry", "503-123-4567", "123 fourth St");

  @Test
  public void customer_instantiatesCorrectly_true() {
    Customer testCustomer = customer;
    assertEquals(true, testCustomer instanceof Customer);
  }

  @Test
  public void getCustomerName_customerInstantiatesWithName_Henry() {
    Customer testCustomer = customer;
  assertEquals("Henry", testCustomer.getCustomerName());
  }

  @Test
  public void getCustomerPhone_customerInstantiatesWithPhone_String() {
    Customer testCustomer = customer;
  assertEquals( "503-123-4567", testCustomer.getCustomerPhone());
  }

  @Test
  public void equals_returnsTrueIfNameAndPhoneAreSame_true() {
    Customer testCustomer = customer;
    Customer anotherCustomer = new Customer("Henry", "503-123-4567", "123 fourth St");
    assertTrue(testCustomer.equals(anotherCustomer));
  }

  @Test
  public void save_insertsObjectIntoDatabase_Customer() {
    Customer testCustomer = customer;
    testCustomer.save();
    assertTrue(Customer.all().get(0).equals(testCustomer));
  }

  @Test
  public void all_returnsAllInstancesOfCustomer_true() {
    Customer testCustomer = customer;
    Customer secondCustomer = new Customer("Harriet", "503-321-7654", "474 NW fdh");
    secondCustomer.save();
    assertEquals(true, Customer.all().get(0).equals(testCustomer));
    assertEquals(true, Customer.all().get(1).equals(secondCustomer));
  }

  @Test
   public void save_assignsIdToObject() {
     Customer testCustomer = customer;
     testCustomer.save();
     Customer savedCustomer = Customer.all().get(0);
     assertEquals(testCustomer.getId(), savedCustomer.getId());
   }

   @Test
    public void find_returnsCustomerWithSameId_secondCustomer() {
      Customer testCustomer = customer;
      testCustomer.save();
      Customer secondCustomer = new Customer("Harriet", "503-321-7654", "474 NW fdh");
      secondCustomer.save();
      assertEquals(Customer.find(secondCustomer.getId()), secondCustomer);
  }
    // @Test
    // public void saveOrderTime_recordsOrderTimeOfCreationInDatabase() {
    //    Customer testCustomer = customer;
    //  testCustomer.save();
    //  Timestamp savedCustomerOrderTime = Customer.find(testCustomer.getId()).getOrderTime();
    //  Timestamp rightNow = new Timestamp(new Date().getTime());
    //  assertEquals(rightNow.getDay(), savedCustomerOrderTime.getDay());
    // }

}
