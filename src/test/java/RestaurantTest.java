import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class RestaurantTest {
  private Restaurant testRestaurant;
  private Restaurant firstRestaurant;
  private Restaurant secondRestaurant;

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void initialize() {
  testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$");
  firstRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$");
  secondRestaurant = new Restaurant("Tres Potros", "Mexican", "11 am - 9pm", "12950 SW Canyon Rd, Beaverton, OR 97005 ", "$");
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteRestaurantsQuery = "DELETE FROM restaurant *;";
      con.createQuery(deleteRestaurantsQuery).executeUpdate();
    }
  }

  @Test
  public void restaurant_instantiatesCorrectly_true() {
    assertEquals(true, testRestaurant instanceof Restaurant);
  }

  @Test
  public void getName_restaurantInstantiatesWithName_Swagat() {
    assertEquals("Swagat", testRestaurant.getName());
  }

  @Test
  public void getCuisine_restaurantInstatiatesWithCuisine_String() {
    assertEquals("Indian", testRestaurant.getCuisine());
  }

  @Test
  public void getHours_restaurantInstatiatesWithHours_String() {
    assertEquals("11 am - 9 pm", testRestaurant.getHours());
  }

  @Test
  public void getAddress_restaurantInstantiatesWIthAddress_String() {
    assertEquals("4325 SW 109th Ave, Beaverton, OR 97005", testRestaurant.getAddress());
  }

  @Test
  public void getPrice_restaurantInstantiatesWithPrice_String() {
    assertEquals("$$", testRestaurant.getPrice());
  }

  @Test
  public void save_insertsObjectsIntoDB_Restaurant() {
    assertEquals(true, Restaurant.all().get(0).equals(testRestaurant));
  }

  @Test
  public void all_returnsAllInstancesOfRestaurant_true() {
    assertEquals(true, Restaurant.all().size() > 0);
  }

  @Test
  public void save_assignsIdToObjects() {
    Restaurant savedRestaurant = Restaurant.all().get(0);
    assertEquals(testRestaurant.getId(), savedRestaurant.getId());
  }

  @Test
  public void getId_returnsIdOfRestaurant_true() {
    Restaurant another = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$");
    Restaurant anotherClone = Restaurant.all().get(3);
    assertEquals(anotherClone.getId(), another.getId());
  }

  @Test
  public void find_returnsRestaurantWithCorrectId_True() {
    Restaurant another = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$");
    assertEquals(Restaurant.find(testRestaurant.getId()), testRestaurant);

  }
}
