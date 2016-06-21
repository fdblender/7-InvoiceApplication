import java.text.NumberFormat;

public class InvoiceClass {
	private String itemNo;
	private String item;
	private String desc;
	private float price;
	private float quantity;

	public InvoiceClass() {
		itemNo = "";
		item = "";
		desc = "";
		price = 0f;
	}

	public InvoiceClass(String no, String item, String desc, float price, float quantity) {
		this.itemNo = no;
		this.item = item;
		this.desc = desc;		
		this.price = price;
		this.quantity = quantity;
	}

	public void setItemNo(String no) {
		this.itemNo = no;
	}

	public String getItemNo() {
		return this.itemNo;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getPrice() {
		return this.price;
	}
	
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getQuantity() {
		return this.quantity;
	}

	public String getFormattedPrice() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(this.price);
	}
	
	public static String getFormattedPrice(float price) {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(price);
	}

	public String getDisplayText() {
		return (this.itemNo + " | " + String.format("%10s",this.item) + " | " + String.format("%25s",this.desc) + " | " 
				+ getFormattedPrice()+ " | " + getQuantity());
	}

}