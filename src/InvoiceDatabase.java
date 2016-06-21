public class InvoiceDatabase {
	
	private InvoiceClass[] invoiceDB;
	private int noItems;
	
	public InvoiceDatabase (int noItems) {
		invoiceDB = new InvoiceClass[noItems];
		noItems = 0;		
	}
	
	public void addItem (String no, String item, String desc, float price, float quantity) {
		InvoiceClass newitem = new InvoiceClass(no, item, desc, price, quantity);
		invoiceDB[noItems] = newitem;
		this.noItems++;		
	}
	
	// get item matching the requested string
	public InvoiceClass getItem(String item) {
		System.out.println("No of items in database: "+this.noItems);
		for (int i=0;i<this.noItems;i++) {
			this.invoiceDB[i].getDisplayText();
			if (this.invoiceDB[i].getItem().toLowerCase().equals(item)) {				
				return this.invoiceDB[i];
			}
		}		
		return null;		
	}
	
	// get item matching the index to the database
	public InvoiceClass getItem(int index) {
		if (index >= this.noItems) {
			return null;
		} else {
			return this.invoiceDB[index];	
		}
	}

}