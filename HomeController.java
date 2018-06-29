package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomeController implements Initializable
{
	Stage currStage;

	@FXML
    private TextField fname;
	
	@FXML
	private RadioButton malerbtn;
	
	@FXML
	private RadioButton femalerbtn;
    
    @FXML
    private Button back1;
    
    @FXML
    private Button next1;
    @FXML
    private TextField password;
    
    @FXML
    private TextField cpassword;
    @FXML
    private TextField emailid;
    
    
    String name,namel,passw,cpassw,mail;
    
    @FXML
    private ComboBox<String> quali;
    @FXML
    private TextField lname;
    
    
    public void setCurrStage(Stage stage){
        this.currStage = stage;
   }
    @FXML
	public void back1(ActionEvent event) throws IOException
	{
		
	       FXMLLoader loader = new FXMLLoader(getClass().getResource("javafx.fxml"));
	       Pane myPane = null;
	       myPane = loader.load();
	       SampleController controller = (SampleController) loader.getController();

	       controller.setCurrStage(this.currStage);	    
	       Scene scene = new Scene(myPane);
	       this.currStage.setScene(scene);
            
	       
	}
    @FXML
	public void next1(ActionEvent event) throws IOException
	{
		name=fname.getText();
		namel=lname.getText();
		passw=password.getText();
		cpassw=cpassword.getText();
		mail=emailid.getText();
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("lastpage.fxml"));
	   Pane myPane = null;
	       myPane = loader.load();
	       LastPageController controller2 = (LastPageController) loader.getController();

	       controller2.setCurrStage(this.currStage);	    
	       Scene scene = new Scene(myPane);
	       this.currStage.setScene(scene);
          
		
		 MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
		 MongoCredential credential = MongoCredential.createCredential("sampleUser", "Rohan", 
		         "password".toCharArray()); 
		      System.out.println("Connected to the database successfully");  
		      MongoDatabase database = mongo.getDatabase("Rohan"); 
		      MongoCollection<Document> collection = database.getCollection("SignUp"); 
		      System.out.println("Collection sampleCollection selected successfully");

		      Document document = new Document() 
		      .append("F_Name", name)
		      .append("L_Name", namel) 
		      .append("Email",mail) 
		      .append("Password", passw) 
		      .append("Confirm_Password", cpassw);  
		      collection.insertOne(document); 
		      System.out.println("Document inserted successfully"); 
		      
		      // Retrieving a collection 
		      // Getting the iterable object 
		     
		      System.out.println("Collection sampleCollection selected successfully"); 

	      
	       
	} 


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	
		ToggleGroup toggleGrp = new ToggleGroup();
		malerbtn.setToggleGroup(toggleGrp);
		malerbtn.setSelected(true);
		femalerbtn.setToggleGroup(toggleGrp);
		
		
		quali.getItems().addAll( "Student",
	            "House Wife",
	            "Self Employed",
	            "Buisness",
	            "Corporate",
	            "Unemployed");
		quali.setValue("Student");
	fname.getText();
	
	}
}
