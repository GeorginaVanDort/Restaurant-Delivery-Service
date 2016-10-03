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

















}
