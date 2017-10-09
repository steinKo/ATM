package steinKo.ATM.presentation.win;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class Keypad extends GridPane {
	private TextArea display;
	public Keypad()
	{
		       super();

                display = new TextArea();
                setColumnIndex(display,1);
                getChildren().add(display);
				addButton("1",1,4);
				addButton("2",2, 4);
				addButton("3",3, 4);
				addButton("4",1, 3);
				addButton("5",2, 3);
				addButton("6",3, 3);
				addButton("7",1, 2);
				addButton("8",2, 2);
			    addButton("9",3, 2);
			    addButton("0",1, 5);
			    addButton(".",2, 5);
			    Button ceButton;
			    ceButton = new Button("CE");
			    ceButton.setOnAction((event)-> display.deletePreviousChar());	
			    add(ceButton,3, 5);
			    
				
			
			}
	private void addButton(String navn,int kolonne,int rad)
	{
		Button button;
		button = new Button(navn);
		add(button ,kolonne, rad);
	
		class MinEventHandler implements EventHandler<ActionEvent>{
			 
            @Override
            public void handle(ActionEvent event)
            {   
               display.appendText(button.getText());
              
            }
            
           }
		button.setOnAction(new MinEventHandler());
	}
	
	public TextArea hentDisplay()
	{
		return display;
	}
	public void resetDisplay() {
		display.setText("");
		
	}
			

}
