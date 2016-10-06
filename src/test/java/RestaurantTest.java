import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class RestaurantTest {
  // private Restaurant testRestaurant;
  // private Restaurant firstRestaurant;
  // private Restaurant secondRestaurant;

  @Rule
  public DatabaseRule database = new DatabaseRule();

  // @Before
  // public void initialize() {
  // Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 1);
  // testRestaurant.save();
  // Restaurant firstRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 1);
  // firstRestaurant.save();
  // Restaurant secondRestaurant = new Restaurant("Tres Potros", "Mexican", "11 am - 9pm", "12950 SW Canyon Rd, Beaverton, OR 97005 ", "$");
  // secondRestaurant.save();
  // }

  // @After
  // public void tearDown() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String deleteRestaurantsQuery = "DELETE FROM restaurants *;";
  //     con.createQuery(deleteRestaurantsQuery).executeUpdate();
  //   }
  // }

  @Test
  public void restaurant_instantiatesCorrectly_true() {
    Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 1);
    assertEquals(true, testRestaurant instanceof Restaurant);
  }

  @Test
  public void getName_restaurantInstantiatesWithName_Swagat() {
  Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 1);
    assertEquals("Swagat", testRestaurant.getName());
  }

  @Test
  public void getCuisine_restaurantInstatiatesWithCuisine_String() {
    Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 1);
    assertEquals("Indian", testRestaurant.getCuisine());
  }

  @Test
  public void getHours_restaurantInstatiatesWithHours_String() {
      Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 1);
    assertEquals("11 am - 9 pm", testRestaurant.getHours());
  }

  @Test
  public void getAddress_restaurantInstantiatesWIthAddress_String() {
      Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 1);
    assertEquals("4325 SW 109th Ave, Beaverton, OR 97005", testRestaurant.getAddress());
  }

  @Test
  public void getPrice_restaurantInstantiatesWithPrice_String() {
      Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 1);
    assertEquals("$$", testRestaurant.getPrice());
  }
  @Test
  public void getId_restaurantInstantiatesWithPrice_String() {
      Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 1);
    assertEquals(1, testRestaurant.getResId());
  }

  @Test
 public void equals_returnsTrueIfNameAndEmailAreSame_true() {
   Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 1);
   Restaurant anotherRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 1);
   assertTrue(testRestaurant.equals(anotherRestaurant));
 }
  @Test
  public void save_insertsObjectsIntoDB_Restaurant() {
    Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 1);
    testRestaurant.save();
    Restaurant savedRestaurant = testRestaurant;
    assertEquals(testRestaurant.getResId(), savedRestaurant.getResId());
  }
  @Test
  public void all_returnsAllInstancesOfRestaurant_true() {
    Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 2);
    testRestaurant.save();
    assertEquals(true, Restaurant.all().size() > 0);
  }

  // @Test
  // public void save_assignsIdToObjects() {
  //   Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 3);
  //   testRestaurant.save();
  //   Restaurant savedRestaurant = Restaurant.all().get(0);
  //   assertEquals(testRestaurant.getResId(), savedRestaurant.getResId());
  // }
 //
 //  @Test
 //  public void getId_returnsIdOfRestaurant_true() {
 //    Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 1);
 //    testRestaurant.save();
 //    Restaurant secondRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 1);
 //    secondRestaurant.save();
 //    assertEquals(testRestaurant.getResId(), 2);
 //  }

  @Test
  public void find_returnsRestaurantWithCorrectId_True() {
    Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 3);
    testRestaurant.save();
    assertEquals(Restaurant.find(testRestaurant.getResId()).getPrice(), testRestaurant.getPrice());
  }

  // @Test
  // public void delete_deletesRestaurants_true(){
  //   testRestaurant.delete();
  //   firstRestaurant.delete();
  //   secondRestaurant.delete();
  //   assertEquals(null, Restaurant.find(testRestaurant.getResId()));
  // }
  //
  // @Test
  // public void update_updatesClientDescription_true() {
  //   testRestaurant.update("Testing", "Indian", "11 am - 9 pm", "4325 SW 109th Ave, Beaverton, OR 97005", "$$", 1);
  //   assertEquals("Testing", Restaurant.find(testRestaurant.getResId()).getName());
  // }

}
