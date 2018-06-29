package application;

import java.io.IOException;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SampleController //implements Initializable
{ 
	
	String user;
	String pass;
	
	@FXML
	private Button signin;
	
	@FXML
	private Button signup;
	
	Stage currStage;

    public void setCurrStage(Stage stage){
         this.currStage = stage;
    }
    @FXML
    private Button back1;
    
    @FXML
    private TextField uname;
    @FXML
    private Text wrongpass;							
    @FXML
    private PasswordField pword;
    
    @FXML
	public void signIn(ActionEvent event) throws IOException
	{
    	user=uname.getText().toString();
		
    	MongoClient mongo = new MongoClient( "localhost" , 27017 );
		MongoCredential credential = MongoCredential.createCredential("sampleUser", "Rohan", 
		         "password".toCharArray());  
		      MongoDatabase database = mongo.getDatabase("Rohan"); 
		 MongoCollection<Document> collection = database.getCollection("SignUp"); 
			
	      FindIterable<Document> iterDoc = collection.find();
	      for(Document doc : iterDoc)
	      {
	    	  
	    	  
	    	  String name = doc.getString("F_Name");
	    	  if(user.equals(name))
	    	  {
	    		  FXMLLoader loader = new FXMLLoader(getClass().getResource("loginpage.fxml"));
	   	       Pane myPane = loader.load();
	   	       Scene scene = new Scene(myPane);
	   	       
	   	       LoginController controller = (LoginController) loader.getController();

	   	       controller.setCurrStage(this.currStage);	 
	   	       currStage.setTitle("Login");
	   	       currStage.setScene(scene);
	   	       }
	    	  else
	    		  wrongpass.setText("Wrong Username or Password");	  
	      }
	    		  
	      
	}
			
		
    
    		
			
	

	
	@FXML
	public void signUp(ActionEvent event) throws IOException
	{
		/*ProcessBuilder pb = new ProcessBuilder();
        pb.command("set path=C:\\Program Files\\MongoDB\\Server\\3.4\\bin","mongod --dbpath D:\\javadocs");
        Process p;
        try {
            p = pb.start();
            System.out.println(p.isAlive());
            p.destroyForcibly();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();*/
        //} 
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("SignupNew.fxml"));
	       Pane myPane = loader.load();
	       Scene scene = new Scene(myPane);
	       
	       HomeController controller = (HomeController) loader.getController();

	       controller.setCurrStage(this.currStage);	 
	       currStage.setTitle("Registration");
	       currStage.setScene(scene);
	       //currStage.show();
	   
	}

	
	

	}
