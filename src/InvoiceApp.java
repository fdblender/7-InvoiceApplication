import java.util.Scanner;

public class InvoiceApp {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);	
		boolean more = true;
		String cont;
		String item;
		int NO_ITEMS = 6;
		InvoiceClass invoice;
		Double taxRate, price;
		Double subtotal = 0.0;
		Double grandtotal = 0.0;
		Double tax = 0.0;
		int quantity = 0;
		String report[][] = new String[50][];
		
		InvoiceDatabase invoiceDB = new InvoiceDatabase(NO_ITEMS);
		invoiceDB.addItem("J001", "Java", "Good book about Java", 25f);
		invoiceDB.addItem("P002", "Python", "Good book about Python", 25f);
		invoiceDB.addItem("H002", "HTML", "Good book about HTML", 20f);
		invoiceDB.addItem("C003", "CSS Book", "Good book about CSS", 40f);
		invoiceDB.addItem("JS02", "JavaScript Book", "Good book about JavaScript", 15f);
		invoiceDB.addItem("O222", "Oracle Book", "Good book about Oracle", 75f);
		
		/*for (int i = 0; i < NO_ITEMS; i++) {			
			
		}*/
		
		invoice = invoiceDB.getItem("Java");
			
		System.out.println(invoice.getDisplayText());	
		
		while (more) {
			// get item and quantity
			System.out.print("Enter the item: ");
			item = scan.next();
			System.out.print("Enter the quantity: ");
			quantity = scan.nextInt();
			scan.hasNextLine();
			
			// get price from database, multiply by quantity and add to subtotal
			invoice = invoiceDB.getItem(item);
			subtotal += invoice.getPrice() * quantity;
			
			System.out.println(invoice.getDisplayText());
			System.out.print("Enter more (y/n)? ");
			cont = scan.next();
			
			if (cont.toLowerCase().equals("n")) {
				more = false;
			}
		}	
			
		
	}

}
