package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Client.Client;

public class Manage {
	
	//method to connect to the database
		public static Connection getConnection() throws Exception{
			
			try {
				final String driver = "com.mysql.cj.jdbc.Driver";
				final String url = "jdbc:mysql://localhost/client";
				final String username = "root";
				final String password = "bestdatabase20";
				Class.forName(driver);
				
				Connection conn = DriverManager.getConnection(url,username,password);
				System.out.println("Connected");
				return conn;
			}catch(SQLException e) {System.out.println(e);}
			return null;
		}
		
		//method to create a table
		public static void createTable () throws Exception{
			try {
				Connection con = getConnection();
				PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS client_info (client_number BigInt, name varchar(255), last_name varchar(255), Email varchar(255), phone_Number BigInt, address varchar(255), city varchar(255), postal_Code varchar(255), PRIMARY KEY(client_number))");
				create.executeUpdate();
				
			}catch(SQLException e){System.out.println(e);}
			finally {System.out.println("Function complete");}
		}
	
	//insert the client values inside the database
	public static void post(Client c) throws Exception{
		
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT client_info (client_number, name, last_name, Email, phone_Number, address, city, postal_Code) "
					+ "VALUES('"+c.getClientNumber()+"', '"+c.getName()+"', '"+c.getLastName()+"', '"+c.getEmail()+"', '"+c.getPhoneNumber()+"', '"+c.getAddress()+"', '"+c.getCity()+"', '"+c.getPostalCode()+"')");
			posted.executeUpdate();
		}catch(SQLException e){System.out.println(e);}
		finally {System.out.println("Insert completed");}
	}
	
	// Select an existing client from the database
	public static Client getClient(long cn) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM client_info where client_number = " + cn);
			
			ResultSet result = statement.executeQuery();
			Client c = new Client();
			
			while (result.next()) {
				
				c.setClientNumber(result.getLong("client_number"));
				c.setName(result.getString("name"));
				c.setLastName(result.getString("last_name"));
				c.setEmail(result.getString("Email"));
				c.setPhoneNumber(result.getLong("phone_number"));
				c.setAddress(result.getString("address"));
				c.setCity(result.getString("city"));
				c.setPostalCode(result.getString("postal_code"));
				
			}
			System.out.println("all records have been selested");
			return c;
		}catch(Exception e) {System.out.println(e);}
		return null;
	}
	
	//method to get the total number of clients
	public static int getNumberofClient() throws Exception{
		int count = 0;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT COUNT(*) FROM client_info");
			ResultSet result = statement.executeQuery();
			result.next();
			 count = result.getInt(1);
			return count;
		}catch(Exception e) {System.out.println(e);}
		return count;
	}
	
	// Select an existing client from the database
		public static Client[] getAllClient() throws Exception{
			try {
				Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement("SELECT * FROM client_info");
				ResultSet result = statement.executeQuery();
				
				Client[] c_arr = new Client[getNumberofClient()];
				
				for(int i=0; i<c_arr.length ;i++) {
					while(result.next()) {
					c_arr[i] = new Client();
					c_arr[i].setClientNumber(result.getLong("client_number"));
					c_arr[i].setName(result.getString("name"));
					c_arr[i].setLastName(result.getString("last_name"));
					c_arr[i].setEmail(result.getString("Email"));
					c_arr[i].setPhoneNumber(result.getLong("phone_number"));
					c_arr[i].setAddress(result.getString("address"));
					c_arr[i].setCity(result.getString("city"));
					c_arr[i].setPostalCode(result.getString("postal_code"));
					System.out.println(i);
				}
			}
				System.out.println("all records have been selested");
				return c_arr;
			}catch(Exception e) {System.out.println(e);}
			return null;
		}
	
	
	//Method to delete a client from the database
	public static void deleteClient(long cn) throws Exception{
	try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("DELETE FROM client_info where client_number = " + cn);
		statement.executeUpdate();
		System.out.println("Client deleted");
	     }catch (Exception e) {System.out.println(e);}
	  
	}
	
	//Method to get the current date
	public static String getDate() throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT NOW()");
			
			ResultSet result = statement.executeQuery();
			result.next();
			Date d = result.getDate(1);
		
			String s = d.toString();
			String date = s.substring(0, 4) + s.substring(5, 7) + s.substring(8);
			
			return date;
		     }catch (Exception e) {System.out.println(e);}
		    return null;
		}
	
	//get the cities
	public static String[] getAllCities() throws Exception{
		try {
			String cities[] = new String [getNumberofClient()];
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT city FROM client_info");
			ResultSet result = statement.executeQuery();
			
			for(int j =0; j< cities.length; j++) {
				cities[j] = new String();
				
				if(result.next()== true) {
					cities[j] = result.getString("city");
			  }
			}
			return cities;
		     }catch (Exception e) {System.out.println(e);}
		    return null;
	}
	
	

}
