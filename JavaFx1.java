package application;

import java.awt.Insets;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage; 
import javafx.geometry.Pos; 
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.control.RadioButton;  
import javafx.scene.control.TextField; 
import javafx.scene.control.ToggleGroup;  
import javafx.scene.paint.Color;  
import javafx.scene.text.Font;  
import javafx.scene.control.Tooltip; 
import javafx.scene.text.FontPosture;  
import javafx.scene.text.FontWeight;  
import javafx.scene.Group;
import javafx.scene.control.*;
//import javafx.css.*;
import javafx.scene.control.PasswordField;
public class JavaFx1 extends Application{  
		String checkuser, checkpass;
	    
	    public void start(Stage primaryStage) throws Exception {  
	          
	        Button signin=new Button("Sign in\t"); 
	        Button sgnup=new Button("New User? Sign Up.\t");
	        Text text = new Text();  
	        Text text2 = new Text();
	        GridPane root=new GridPane();    
	        root.getStylesheets().add("login.css");  
	        root.getChildren();  
	     Scene scene=new Scene(root,800,700,Color.CADETBLUE);   
	       text.setFont(Font.font("Cambria",FontWeight.BOLD,FontPosture.REGULAR,25));  
	        text.setFill(Color.ORANGE);   
	       // text.setStroke(Color.RED);     
	      //  text.setStrokeWidth(0.60);    
	        text.setText("Hello People!");
	        ComboBox<String> quali = new ComboBox<String>();
	       quali.getItems().addAll(
	            "Student",
	            "House Wife",
	            "Self Employed",
	            "Buisness",
	            "Corporate",
	            "Unemployed"
	        );   
	        quali.setValue("Student");
	     
	        primaryStage.setTitle("Login/Sign Up");  
	        primaryStage.setScene(scene);  
	        primaryStage.show(); 
	        ToggleGroup group = new ToggleGroup();  
	        RadioButton button1 = new RadioButton("Male");  
	        RadioButton button2 = new RadioButton("Female");  
	        button1.setToggleGroup(group);  
	        button2.setToggleGroup(group);  
	        Text first_name=new Text("Username:");  
	     first_name.setFont(Font.font("Cambria",FontPosture.ITALIC,20));
	        Text last_name=new Text("Password:");
	      last_name.setFont(Font.font("Cambria",FontPosture.ITALIC,20));
	    
	        TextField tf1=new TextField();  
	       
	        tf1.setPromptText("Enter Username"); 
	        PasswordField tf2=new PasswordField();  
	        tf2.setPromptText("Enter Password");  
	   
	        tf1.setFont(Font.font("Cambria",15));
	        tf2.setFont(Font.font("Cambria",15));
	        root.add(text,0,0);
	        root.add(first_name,0,1);  
	        root.add(tf1,1,1);
	        root.add(last_name,0,2);
	        root.add(tf2,1,2);
	        
	        root.add(signin,1,5);
	       
	        root.add(text2,1,9);
	  //      root.setGridLinesVisible(true);
	      	        
    	        	signin.setOnAction(new EventHandler<ActionEvent>() {  
   	            	 

	            @Override  
	            public void handle(ActionEvent arg0) {  
	    checkuser=tf1.getText().toString();        	
	   checkpass=tf2.getText().toString();
  	 if(checkuser.equals("rohan")&& checkpass.equals("hello"))
	       {

	            	    GridPane root2=new GridPane();
	            	    Scene scene2=new Scene(root2,800,700);
	            	    root2.getChildren();
	            	    root2.getStylesheets().add("login.css");  
		            	   primaryStage.setTitle("second JavaFX Application");  
		            	   primaryStage.setScene(scene2);  
		            	  
		        	        primaryStage.show();
	       
	            	    Button btn2=new Button("Back");
	        	        btn2.setOnAction(new EventHandler<ActionEvent>() {  
	        	              
	        	            @Override  
	        	            public void handle(ActionEvent arg0) {  
	     
	        	            	text2.setText("");
	        	            		primaryStage.setScene(scene);
	        	            		primaryStage.show();
	        	            }  
	        	        });
	            	    
	        	       
	        	        root2.addRow(0, btn2);
	        	        Button btn3=new Button("Close");
	        	        btn3.setOnAction(new EventHandler<ActionEvent>() {  
	        	              
	       
	        	            public void handle(ActionEvent arg0) {  
	        	            		primaryStage.close();
	        	            }                  
	        	        });
	        	        root2.addRow(4, btn3);
	       }
  	 else{ 
  		 text2.setText("Wrong Password or username!!");
  		text2.setFont(Font.font("Cambria",FontPosture.REGULAR,14)); 
  		text2.setFill(Color.RED); 
  		 tf1.setText("");
  		tf2.setText("");
  	 }
	            }
	          
	            {
	      		  Tooltip tool=new Tooltip();  
	      		  
	      		    tool.setText("Enter Correct Password");
	      		    tf2.setTooltip(tool);
	      		 }
	        });
    	        	sgnup.setOnAction(new EventHandler<ActionEvent>() {  
    	        		
    	        		 public void handle(ActionEvent arg0) {        
    	        			 GridPane root3=new GridPane();
    	        		
    	        			
    	        		root3.getColumnConstraints().add(new ColumnConstraints(250)); // column 1 is 100 wide
    	        		    root3.getColumnConstraints().add(new ColumnConstraints(250));
    	        		  root3.setPrefSize(900, 800);
    	        		  ColumnConstraints column1 = new ColumnConstraints(100,100,Double.MAX_VALUE);
    	        		     column1.setHgrow(Priority.ALWAYS);
    	        		   
    	        			 Scene sgnup=new Scene(root3,900,800);
    	        			 root3.setAlignment(Pos.CENTER_LEFT);
    	        			 root3.setVgap(10);
    	        			// root3.setHgap(10);
    	        			// root3.setPadding(new Insets(10, 10, 10, 10));
    	        			 Text detailstext = new Text("Enter the details.");  
    	        			 detailstext.setFont(Font.font("Cambria",FontWeight.BOLD,FontPosture.REGULAR,25));  
    	        		        detailstext.setFill(Color.GREEN);   
    	        		        Text fname = new Text("First Name:");
    	        		        Text lname = new Text("Last Name:");
    	        		        fname.setFont(Font.font("Cambria",FontPosture.ITALIC,17));
    	        		        lname.setFont(Font.font("Cambria",FontPosture.ITALIC,17));
    	        		        TextField tf3=new TextField();
    	        		        TextField tf4=new TextField();
    	        		        PasswordField pf1=new PasswordField(); 
    	        		        PasswordField pf2=new PasswordField(); 
    	        			 
    	        		        tf3.setPromptText("Enter First Name"); 
    	        		        tf4.setPromptText("Enter Last Name");
    	        		        Text pass1 = new Text("Password:");
    	        		   
    	        		        Text email = new Text("Email:");
    	        		        email.setFont(Font.font("Cambria",FontPosture.ITALIC,17));
    	        		        TextField emailid=new TextField();
    	        		     emailid.setPromptText("Enter Correct email"); 
    	        		        
    	        		        pass1.setFont(Font.font("Cambria",FontPosture.ITALIC,17));
    	        		        Text pass2 = new Text("Confirm Password:");
    	        		        pass2.setFont(Font.font("Cambria",FontPosture.ITALIC,17));
    	        		        pf1.setPromptText("Enter Strong Password");
    	        		        pf2.setPromptText("Enter Password Again");
    	        		        
    	        		        Text gender = new Text("Select your gender:");
    	        		        gender.setFont(Font.font("Cambria",FontWeight.BOLD,FontPosture.REGULAR,17));
    	        		        
    	        		        Text qualif = new Text("Select your Qualification:");
    	        		        qualif.setFont(Font.font("Cambria",FontWeight.BOLD,FontPosture.REGULAR,17));
    	        		        
    	        		        root3.getChildren();
    	        		 root3.getStylesheets().add("login.css"); 
    	        		 
    		 
    	  primaryStage.setTitle("Sign Up");  
    	        		   primaryStage.setScene(sgnup);  
    	        		  
    	        	      primaryStage.show();
    	        	      Button btn3=new Button("Back");
  	        	        btn3.setOnAction(new EventHandler<ActionEvent>() {  
  	        	              
  	       
  	        	            public void handle(ActionEvent arg0) {  
  	        	            	text2.setText("");	
  	        	            	primaryStage.setScene(scene);
  	        	            		primaryStage.show();
  	        	            		
  	        	            }  
  	        	        });
  	        	      
  	        root3.setGridLinesVisible(true);
  	    	root3.add(detailstext,0,1);
  	    
  	    	root3.add(fname,0,2);
  	    	root3.add(lname,0,3);
  	    	root3.add(tf3,1,2);
  	    	root3.add(tf4,1,3);  
  	    	
  	    	root3.add(pass1,0,5);
  	    	root3.add(pf1,1,5);
  	    	root3.add(pass2,0,6);
  	    	root3.add(pf2,1,6);
  	    	
  	    	root3.add(email, 0, 4);
  	    	root3.add(emailid, 1, 4);
  	    	
  	    	root3.add(gender, 0, 7);
  	    	root3.add(button1,0,8);
	    	root3.add(button2,0,9);
	    	
	    	root3.add(qualif, 0, 10);
	    	root3.add(quali, 0, 11);
  	        
	    	root3.add(btn3,0,20);
    	        		 
    	        		 } 
    	        		 });
    	        	root.setVgap(5);
	    root.add(sgnup, 1, 6);    
	    }   	       
    	 
    	    
	    
	    public static void main (String[] args)  
	    {  
	        launch(args);  
	    }  
	  
	}  

