package application;

import javafx.beans.property.SimpleStringProperty;

public class Usermaster{    

	 
	   public SimpleStringProperty name = new SimpleStringProperty(); 
	   public SimpleStringProperty namel = new SimpleStringProperty();
	   public SimpleStringProperty mail = new SimpleStringProperty();
	   public SimpleStringProperty passw = new SimpleStringProperty();
	   public SimpleStringProperty cpassw = new SimpleStringProperty();
	   
	public String getName() {
		return name.get();
	}
	public String getNamel() {
		return namel.get();
	}
	public String getMail() {
		return mail.get();
	}
	public String getPassw() {
		return passw.get();
	}
	public String getCpassw() {
		return cpassw.get();
	}
	
	   
	   
	
	   
	   
	   

	
	}
