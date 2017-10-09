package steinKo.ATM.unitTest.Presentation.win;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.testfx.framework.junit.ApplicationTest;

import javafx.stage.Stage;
import steinKo.ATM.Category.UnitTest;
import steinKo.ATM.presentation.win.Keypad;
import javafx.scene.Scene;

@Category(UnitTest.class)
public class KeyadTest extends ApplicationTest{
         private Keypad keypad;
        ;
	 @Override
	  public void start(Stage stage) throws Exception {
		   keypad = new Keypad();
	      Scene scene = new Scene(keypad, 800, 600);
	       stage.setScene(scene);
	       stage.show();
	   }
	 
	
	 @BeforeClass 
	 public static void setupHeadlessMode(){
		 
	 if(Boolean.getBoolean("headLess"))
	    {
		    System.setProperty("testfx.robot", "glass");
	        System.setProperty("testfx.headless", "true");
	        System.setProperty("prism.order", "sw");
	        System.setProperty("prism.text", "t2k");;

	     }
	      
	 }

	@Test
	   public void shouldRecordInDisplay() {
	         given:
	     clickOn("1");
	       clickOn("2");
	       clickOn("3");
	       clickOn("4");
	       clickOn("5");
	        clickOn("6");
	        clickOn("7");
	        clickOn("8");
	       clickOn("9");
	       //clickOn(".");
	       clickOn("0");
	       clickOn("0");
	      assertEquals("12345678900",keypad.hentDisplay().getText());
	        
	   }
	    
	  @Test
	  public void shouldClearInDisplay() {
	         given:
	         clickOn("1");
	         clickOn("2");
	         clickOn("3");
	          clickOn("CE");
	       assertEquals("12",keypad.hentDisplay().getText());
	        
	   }
	    
	    @Test
	    public void shouldResetInDisplay() {
	         given:
	        clickOn("1");
	        clickOn("2");
	       clickOn("3");
	      keypad.resetDisplay();
	      assertEquals("",keypad.hentDisplay().getText());
	        
	   }

		

}
