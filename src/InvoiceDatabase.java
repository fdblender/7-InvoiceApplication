
public class InvoiceDatabase {
	
	private InvoiceClass[] invoiceDB;
	private int noItems;
	
	public InvoiceDatabase (int noItems) {
		invoiceDB = new InvoiceClass[noItems];
		noItems = 0;		
	}
	
	public void addItem (String no, String item, String desc, float price) {
		InvoiceClass newitem = new InvoiceClass(no, item, desc, price);
		invoiceDB[noItems] = newitem;
		this.noItems++;		
	}
	
	// get item matching the requested string
	public InvoiceClass getItem(String item) {
		for (int i=0;i<this.noItems;i++) {
			if (this.invoiceDB[i].getItem().equals(item)) {				
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
