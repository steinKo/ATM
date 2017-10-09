package steinKo.ATM.presentation.win;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import steinKo.ATM.domain.ATM;
import steinKo.ATM.domain.Bank;
import steinKo.ATM.service.ATMService;

public class ATMViewerComponent {

	@Autowired
	private ATMService atm;
    TextArea display;
	public Keypad pad;

	public ATMViewerComponent() {
		
	}

	public VBox creatComponent()
	{    
		VBox components;
		display = new TextArea(atm.display());
		components = new VBox();
		pad = new Keypad();
		components.getChildren().addAll(pad,display,creatButtons());
		return components;
	}

	private HBox creatButtons()
	{   HBox buttons;
	    buttons = new HBox();
	    Button buttonA = new Button("A");
	    buttonA.setOnAction((event)->{ atm.buttomAPushed(hentpadDislplay());refresh(); });
	    Button buttonB = new Button("B");
	    buttonB.setOnAction((event)-> {atm.buttomBPushed(hentpadDislplay());refresh();});
	    Button buttonC = new Button("C");
	    buttonB.setOnAction((event)-> {atm.buttomCPushed(hentpadDislplay());refresh();});
	    buttons.getChildren().addAll(buttonA,buttonB,buttonC);
	    return buttons;
	}

	private void refresh()
	{ 
		display.setText(atm.display());
		pad.resetDisplay();
		
	}

	private String hentpadDislplay()
	{
	   return pad.hentDisplay().getText();
	}
}