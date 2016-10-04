import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.math.*;

public class MenuItemTest {

  @Rule
    public DatabaseRule database = new DatabaseRule();

  MenuItem menuitem = new MenuItem("KungPao Chicken", 1, 12.50);

  @Test
    public void menuItem_instantiatesCorrectly_true(){
      MenuItem testMenuItem = menuitem;
      assertEquals(true, testMenuItem instanceof MenuItem);
    }

  @Test
    public void save_savesIntoDatabase_true() {
      MenuItem testMenuItem = menuitem;
      testMenuItem.save();
      assertTrue(MenuItem.all().get(0).equals(testMenuItem));
    }

  @Test
    public void equals_returnsTrueIfItemNamesAretheSame() {
       MenuItem firstMenuItem = menuitem;
       MenuItem secondMenuItem = menuitem;
       assertTrue(firstMenuItem.equals(secondMenuItem));
     }

  @Test
    public void all_returnsAllInstancesOfMenuItem_true() {
       MenuItem firstMenuItem = menuitem;
       firstMenuItem.save();
       MenuItem secondMenuItem = new MenuItem("Burger", 2, 12.50);
       secondMenuItem.save();
       assertEquals(true, MenuItem.all().get(0).equals(firstMenuItem));
       assertEquals(true, MenuItem.all().get(1).equals(secondMenuItem));
   }

  @Test
    public void save_assignsIdToObject_True() {
       MenuItem testMenuItem = menuitem;
       testMenuItem.save();
       MenuItem savedMenuItem = MenuItem.all().get(0);
       assertEquals(testMenuItem.getId(), savedMenuItem.getId());
   }

  @Test
   public void find_returnsMenuItemWithSameId_secondMenuItem() {
       MenuItem firstMenuItem = menuitem;
       firstMenuItem.save();
       MenuItem secondMenuItem = menuitem;
       secondMenuItem.save();
       assertEquals(MenuItem.find(secondMenuItem.getId()), secondMenuItem);
   }

   @Test
   public void delete_deletesMenuItem_true(){
     MenuItem firstMenuItem = menuitem;
     firstMenuItem.save();
     firstMenuItem.delete();
     assertEquals(null, Restaurant.find(firstMenuItem.getId()));
   }








}
