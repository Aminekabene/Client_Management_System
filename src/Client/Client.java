package Client;

public class Client {
	
	//attributes
	private static long client_Num = 000000L;
	private String name;
	private String last_Name;
	private String Email;
	private long phone_Number;
	private String address;
	private String city;
	private String postal_Code;
	
	//default constructor
	public Client() {
		++client_Num;
		name = null;
		last_Name = null;
		Email = null;
		phone_Number = 0000000000L;
		address = null;
		city = null;
		postal_Code = null;
	}
	
	//parameter constructor
	public Client(String name, String last_name, String Email, long phone_Number, String address, String city, String postal_Code) {
		++client_Num;
		this.name = name;
		this.last_Name = last_name;
		this.Email = Email;
		this.phone_Number = phone_Number;
		this.address = address;
		this.city = city;
		this.postal_Code = postal_Code;
	}
	
	//copy constructor
	public Client (Client aClient) {
		client_Num = aClient.client_Num;
		name = aClient.name;
		last_Name = aClient.last_Name;
		Email = aClient.Email;
		phone_Number = aClient.phone_Number;
		address = aClient.address;
		city = aClient.city;
		postal_Code = aClient.postal_Code;
	}
	
	//Accessors
	public long getClientNumber() {
		return client_Num;
	}
	
	public  String getName() {
		return name;
	}
	
	public  String getLastName() {
		return last_Name;
	}
	
	public  String getEmail() {
		return Email;
	}
	
	public  long getPhoneNumber() {
		return phone_Number;
	}
	
	public  String getAddress() {
		return address;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getPostalCode() {
		return postal_Code;
	}
	
	//Mutators
	public void setClientNumber(long n) {
		Client.client_Num = n;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLastName(String last_Name) {
		this.last_Name= last_Name;
	}
	
	public void setEmail(String email) {
		this.Email = email;
	}
	
	public void setPhoneNumber(long phone_Number) {
		this.phone_Number = phone_Number;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setPostalCode(String postal_Code) {
		this.postal_Code = postal_Code;
	}
	
	//toString method
	public String toString() {
		return client_Num + ", " + name + ", " + last_Name + ", "  + Email + ", " + phone_Number +  ", " + address + ", "+ city + " " + postal_Code;
	}
	
	//equals method
	public boolean equals(Client otherClient) {
		return client_Num == otherClient.client_Num && name.equals(otherClient.name) && last_Name.equals(otherClient.last_Name) && phone_Number == otherClient.phone_Number
				&& Email.equals(otherClient.Email) && address.equals(otherClient.address) && city.equals(otherClient.city) 
				&& postal_Code.equals(otherClient.postal_Code);
	}
}
