package Driver;

import java.sql.Date;
import java.util.Calendar;

import Client.Client;
import Client.Invoice;
import Database.Manage;


public class Driver {
	
	public static String getStatsForCities() throws Exception {
		String cities[];
		cities = Manage.getAllCities();
		int count = 0;
		
		for(int k=0; k<cities.length; k++) {
			if(cities[k].equals(cities[k-1])) {
				count++;
			}
		}
		
		return null;
	}

	public static void main(String[] args) throws Exception {
		
		Client c1 = new Client("john", "doe", "johndoe@gmail.com", 5148456598L, "54 oliver Street", "pierrefonds", "H8P 0Y6");
		Client c2 = new Client("joe", "miller", "joemiller@gmail.com", 5148596253L, "67 coco", "montreal", "K9S 5D3");
		
		Manage.createTable();
		/*
		Manage.post(c2);
		System.out.println(Manage.getClient(3L));
		Manage.deleteClient(3);
		/System.out.println(Manage.getNumberofClient());
		
		Client[] ca = Manage.getAllClient();
		
		for(int j=0;j<ca.length;j++) {
			System.out.println(ca[j]);
		}
      */
		String c[];
		
		c = Manage.getAllCities();
		
		for(int i=0; i<c.length; i++) {
			System.out.println(c[i]);
		}

	}
	
	
	
	

}
