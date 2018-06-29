package application;
import java.io.IOException;
import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFx2 extends Application {

	 public void start(Stage stage) throws Exception {
		 
		
		  
	 FXMLLoader loader = new FXMLLoader(getClass().getResource("javafx.fxml"));
		 
		   Parent root = loader.load();	       
		   
	        SampleController controller = (SampleController) loader.getController();

	        controller.setCurrStage(stage);	    
	        Scene scene = new Scene(root, 692, 732);
	    
	        stage.setTitle("FXML Welcome");
	        stage.setScene(scene); 
	        stage.show();
	
	
	
	        //Parent root2 = FXMLLoader.load(getClass().getResource("signup.fxml"));
	     
	    
	
	 }
	
	  public static void main (String[] args) throws IOException  
	    {  
	 
		  launch(args); 

Runtime runtime = Runtime.getRuntime();

    Process p1 = runtime.exec("cmd /c start C:\\Users\\rohan.wargia\\Desktop\\run-mongo.bat");
    InputStream is = p1.getInputStream();
    int i = 0;
    while( (i = is.read() ) != -1) {
        System.out.print((char)i);
        System.out.println("heloooo");
        
    
} 


		  
	    }  
	  

}
