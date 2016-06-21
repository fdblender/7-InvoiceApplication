/* Create an application that allows users to create an invoice application. 
 * An invoice application will prompt the user for items purchased, 
 * including quantity. It will look up the items in the "database" 
 * you have created in the last project. 
 * It will print a line item of the item number, description, quantity and price. 
 * An Invoice class would contain multiple line item class objects.
 * Users should be able to input data until they run out and then the application
 * will print out an invoice of all the data including a subtotal, tax and grand total.
 * F. Blendermann
 */
import java.util.Scanner;

public class InvoiceApp {
	static int NO_ITEMS = 6;
	static float TAX_RATE = .06f;

	// loads the invoice database with test data
	public static InvoiceDatabase loadDatabase() {
		InvoiceDatabase invoiceDB = new InvoiceDatabase(NO_ITEMS);
		invoiceDB.addItem("J001", "Java", "Good book about Java", 25f, 0f);
		invoiceDB.addItem("P002", "Python", "Good book about Python", 25f, 0f);
		invoiceDB.addItem("H002", "HTML", "Good book about HTML", 20f, 0f);
		invoiceDB.addItem("C003", "CSS", "Good book about CSS", 40f, 0f);
		invoiceDB.addItem("JS02", "JavaScript", "Book about JavaScript", 15f, 0f);
		invoiceDB.addItem("O222", "Oracle", "Good book about Oracle", 75f, 0f);
		return invoiceDB;
	}
	
	// takes an invoice database, returns a report database with the quantity & price
	public static InvoiceDatabase loadReport(InvoiceDatabase invDB) {
		InvoiceDatabase reportDB = new InvoiceDatabase(NO_ITEMS);
		Scanner scan = new Scanner(System.in);	
		boolean more = true;
		String cont = "";
		InvoiceClass inv;
		String item;
		int quantity = 0;
		
		while (more) {
			// get item and quantity
			System.out.print("Enter the item: ");
			item = scan.next();
			System.out.print("Enter the quantity: ");
			quantity = scan.nextInt();
			//scan.hasNextLine();
			
			// search for the item in the database
			inv = invDB.getItem(item);
			
			// if the item is found, add the item to the report with the quantity
			if (inv != null) {
				System.out.println(inv.getDisplayText());
				reportDB.addItem(inv.getItemNo(), inv.getItem(), inv.getDesc(), 
						inv.getPrice(), quantity);
			}
			// are there more to enter?
			System.out.print("Do you want to enter more (y/n)? ");
			cont = scan.next();
			if (cont.toLowerCase().equals("n")) {
				more = false;
			}
		}
		return reportDB;
	}
	
	// uses the report database to print the report, calculating tax & totals
	public static void printReport(InvoiceDatabase reportDB) {
		float taxRate, price;
		float subtotal = 0.0f;
		float total = 0.0f;
		float tax = 0.0f;
		String anyStr = "";
		InvoiceClass inv;
		
		System.out.println("\n--------------------------- INVOICE REPORT ----------------------------");
		System.out.println("Num  |       Item |               Description "
				+ "| Price  | Quant | Total");
		for (int i=0; i < NO_ITEMS; i++) {		
			inv = reportDB.getItem(i);
			if (inv != null) {
				System.out.print(inv.getDisplayText());				
				// get price from database, multiply by quantity and add to subtotal
				subtotal += (inv.getPrice() * inv.getQuantity());				
				System.out.println("   | "+InvoiceClass.getFormattedPrice(subtotal));				
			}
		}
		System.out.println("---------------------------- TAX & TOTAL ------------------------------");
		
		anyStr = InvoiceClass.getFormattedPrice(subtotal);
		System.out.println("Subtotal: "+anyStr);
		tax = subtotal * TAX_RATE;
		anyStr = InvoiceClass.getFormattedPrice(tax);
		System.out.println("Tax Rate:   "+TAX_RATE);
		System.out.println("Tax:       "+anyStr);
		total = subtotal + tax;
		anyStr = InvoiceClass.getFormattedPrice(total);
		System.out.println("Total:    "+anyStr);	
		System.out.println("-----------------------------------------------------------------------");
	}
	
	
	public static void main(String[] args) {
		
		InvoiceDatabase invoiceDB;
		InvoiceDatabase reportDB;
		
		// load the invoice database with test data
		invoiceDB = loadDatabase();
		
		// prompt the user to enter invoices for the report
		reportDB = loadReport(invoiceDB);
		
		// print the report
		printReport(reportDB);

	}
}