import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.math.*;

public class MenuItemTest {
  private MenuItem testMenuItem;
  private MenuItem firstMenuItem;
  private MenuItem secondMenuItem;

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Before
    public void initialize() {
      testMenuItem = new MenuItem (1, 12.50, "KungPao Chicken", 1);
      testMenuItem.save();
      firstMenuItem = new MenuItem (2, 11.50, "Chow Mein", 2);
      firstMenuItem.save();
      secondMenuItem = new MenuItem (3, 20.50, "Peking Duck", 3);
      secondMenuItem.save();
    }


  @Test
    public void menuItem_instantiatesCorrectly_true(){
      assertEquals(true, testMenuItem instanceof MenuItem);
    }

  @Test
    public void save_savesIntoDatabase_true() {
      assertEquals(true, testMenuItem.getId()>0);
    }

  @Test
    public void equals_returnsTrueIfItemNamesAretheSame() {
      assertTrue(testMenuItem.equals(testMenuItem));
     }

  @Test
    public void all_returnsAllInstancesOfMenuItem_true() {
       secondMenuItem = new MenuItem(2, 12.50, "Burger", 2);
       assertEquals(true, MenuItem.all().size() > 0);

   }

  @Test
    public void save_assignsIdToObject_True() {
      MenuItem savedMenuItem = MenuItem.all().get(0);
      assertEquals(testMenuItem.getId(), savedMenuItem.getId());
   }

  @Test
   public void find_returnsMenuItemWithSameId_secondMenuItem() {
       assertEquals(MenuItem.find(firstMenuItem.getId()), firstMenuItem);
   }

   @Test
   public void delete_deletesMenuItem_true(){
     firstMenuItem.delete();
     testMenuItem.delete();
     secondMenuItem.delete();
     assertEquals(null, Restaurant.find(firstMenuItem.getId()));
   }

   @Test
   public void findByRestaurant_fetchesAllMenuItemsWithSameResID_true(){
     assertEquals(MenuItem.findByRestaurant(2), firstMenuItem);
   }
}
