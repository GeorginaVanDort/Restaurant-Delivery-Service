import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class RestaurantTest {

  @Test
  public void restaurant_instantiatesCorrectly_true() {
    Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", " 4325 SW 109th Ave, Beaverton, OR 97005", "$$");
    assertEquals(true, testRestaurant instanceof Restaurant);
  }

  @Test
  public void getName_restaurantInstantiatesWithName_Swagat() {
    Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", " 4325 SW 109th Ave, Beaverton, OR 97005", "$$");
    assertEquals("Swagat", testRestaurant.getName());
  }

  @Test
  public void getCuisine_restaurantInstatiatesWithCuisine_String() {
    Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", " 4325 SW 109th Ave, Beaverton, OR 97005", "$$");
    assertEquals("Indian", testRestaurant.getCuisine());
  }

  @Test
  public void getHours_restaurantInstatiatesWithHours_String() {
    Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", " 4325 SW 109th Ave, Beaverton, OR 97005", "$$");
    assertEquals("11 am - 9 pm", testRestaurant.getHours());
  }

  @Test
  public void getAddress_restaurantInstantiatesWIthAddress_String() {
    Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", " 4325 SW 109th Ave, Beaverton, OR 97005", "$$");
    assertEquals("4325 SW 109th Ave, Beaverton, OR 97005", testRestaurant.getAddress());
  }

  @Test
  public void getPrice_restaurantInstantiatesWithPrice_String() {
    Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", " 4325 SW 109th Ave, Beaverton, OR 97005", "$$");
    assertEquals("$$", testRestaurant.getPrice());
  }

  @Test
  public void save_insertsObjectsIntoDB_Restaurant() {
    Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", " 4325 SW 109th Ave, Beaverton, OR 97005", "$$");
    testRestaurant.save();
    assertEquals(true, Restaurant.all().get(0).equals(testRestaurant));
  }

  @Test
  public void all_returnsAllInstancesOfRestaurant_true() {
    Restaurant firstRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", " 4325 SW 109th Ave, Beaverton, OR 97005", "$$");
    firstRestaurant.save();
    Restaurant secondRestaurant = new Restaurant("Tres Potros", "Mexican", "11 am - 9pm", " 12950 SW Canyon Rd, Beaverton, OR 97005 ", "$");
    secondRestaurant.save();
    assertEquals(true, Restaurant.all().get(0).equals(firstRestaurant));
    assertEquals(true, Restaurant.all().get(1).equals(secondRestaurant));

  }

  @Test
  public void save_assignsIdToObjects() {
    Restaurant testRestaurant = new Restaurant("Swagat", "Indian", "11 am - 9 pm", " 4325 SW 109th Ave, Beaverton, OR 97005", "$$");
    testRestaurant.save();
    Restaurant savedRestaurant = Restaurant.all().get(0);
    assertEquals(testRestaurant.getId(), savedRestaurant.getId());
  }
