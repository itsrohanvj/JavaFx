package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LastPageController implements Initializable 
{
	
	  @FXML
	    private Button close;
	 
	  
	  @FXML
	  private TableView<Usermaster> tableView;
	  @FXML
	  private TextField searchf;
	  
	  @FXML
	  private Button searchb;
	  @FXML
	  private Text textarea;
	  
	  
	
	@FXML private TableColumn<Usermaster, String> name;
	  @FXML private TableColumn<Usermaster, String> namel;
	  @FXML private TableColumn<Usermaster, String> mail;
	  @FXML private TableColumn<Usermaster, String> passw;
	  @FXML private TableColumn<Usermaster, String> cpassw;
	public void setCurrStage(Stage stage) {
		
		
	
	}
	
	@FXML
	public void close(ActionEvent event) throws IOException
	{
		 Stage stage = (Stage) close.getScene().getWindow();
		    // do what you have to do
		    stage.close();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		name.setCellValueFactory(new PropertyValueFactory("name"));
		namel.setCellValueFactory(new PropertyValueFactory("namel"));
		mail.setCellValueFactory(new PropertyValueFactory("mail"));
		passw.setCellValueFactory(new PropertyValueFactory("passw"));
		cpassw.setCellValueFactory(new PropertyValueFactory("cpassw"));
		ObservableList<Usermaster> data = FXCollections.observableArrayList();
		
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		MongoCredential credential = MongoCredential.createCredential("sampleUser", "Rohan", 
		         "password".toCharArray()); 
		      System.out.println("Connected to the database successfully");  
		      MongoDatabase database = mongo.getDatabase("Rohan"); 
		      MongoCollection<Document> collection = database.getCollection("SignUp"); 
		
		      FindIterable<Document> iterDoc = collection.find(); 
	      

	      for(Document doc : iterDoc)
	      {
	    	  
	    	  Usermaster usermaster = new Usermaster();
	    	  String name = doc.getString("F_Name");
	    	  usermaster.name.set(name);
	    	  String namel = doc.getString("L_Name");
	    	  usermaster.namel.set(namel);
	    	  String mail = doc.getString("Email");
	    	  usermaster.mail.set(mail);
	    	  String passw = doc.getString("Password");
	    	  usermaster.passw.set(passw);
	    	  String cpassw = doc.getString("Confirm_Password");
	    	  usermaster.cpassw.set(cpassw);
	    	  data.add(usermaster);
	      }
	      tableView.getItems().setAll(data);
	      
	    
	}
	
	@FXML
	public void searchb(ActionEvent event) throws IOException
	{	
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		MongoCredential credential = MongoCredential.createCredential("sampleUser", "Rohan", 
		         "password".toCharArray());  
		      MongoDatabase database = mongo.getDatabase("Rohan"); 
		 MongoCollection<Document> collection = database.getCollection("SignUp"); 
			
	      FindIterable<Document> iterDoc = collection.find();
	      
	String found=	searchf.getText().toString();

	      for(Document doc : iterDoc)
	      {
	    	  
	    	  
	    	  String name = doc.getString("F_Name");
	    	  if(name.equals(found))
	    	  {
	    		  textarea.setText(found);
	    	  }
	    		  
	      }
	    	  
	    
	}

}



