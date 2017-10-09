package steinKo.ATM;



import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import steinKo.ATM.presentation.win.ATMViewerComponent;


@SpringBootApplication
public class ATMViewer extends Application {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(ATMViewer.class);
	ATMViewerComponent data = new ATMViewerComponent();
	
	@Override
	public void init() throws Exception {
	    SpringApplication.run(ATMViewer.class);
	    }
	@Override
	public void start(Stage vindu) throws Exception {
		
		
		Pane lerret = new Pane();
		Scene scene = new Scene(lerret, 900, 700);
		vindu.setScene(scene);
		vindu.setTitle("ATM");
		lerret.getChildren().add(data.creatComponent());
		vindu.show();
	}
	
	static public void main(String args[])
	{
		launch(args);
		
		
	}
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
        	 
            LOGGER.info("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                LOGGER.info(beanName);
            }

        };
    }
		
	
}
