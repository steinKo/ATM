package steinKo.ATM.unitTest.Presentation.win;

import org.testfx.framework.junit.ApplicationTest;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import steinKo.ATM.presentation.win.ATMViewerComponent;
import javafx.scene.Scene;



public class ATMViewerTest extends ApplicationTest{
         private ATMViewerComponent atmViewer;
	 @Override
	    public void start(Stage stage) throws Exception {
		    Pane lerret = new Pane();
	
		    atmViewer = new ATMViewerComponent();
	        Scene scene = new Scene(lerret, 800, 600);
	        stage.setScene(scene);
	        lerret.getChildren().add(atmViewer.creatComponent());
	        stage.show();
	    }
	 
	 
}

