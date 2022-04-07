package Client;

import java.sql.Date;

import Database.Manage;

public class Invoice {
	
	private Client client;
	private static long partial_invoice_Number = 00000L;
	
	//default constructor
	public Invoice() {
		client = null;
		partial_invoice_Number = 00000L;
	}
	
	//parameter constructor
	public Invoice(Client c) {
		this.client = c;
		partial_invoice_Number ++;
	}
	
	//copy constructor
	public Invoice(Invoice aInvoice) {
		client = aInvoice.client;
		partial_invoice_Number = aInvoice.partial_invoice_Number;
		
	}
	
	//Accessors
	public Client getClient() {
		return client;
	}
	
	public long getPartialInvoiceNumber()  {
		return partial_invoice_Number;
	}
	
	//mutators
	public void setClient(Client c) {
		client = c;
	}
	
	//get the FULL invoice number
	public String getFullInvoiceNumber(Client c) throws Exception {
		return "" + Manage.getDate() + c.getClientNumber() + partial_invoice_Number;
	}

}
