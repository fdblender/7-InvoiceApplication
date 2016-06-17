import java.text.NumberFormat;

public class InvoiceClass {
	private String itemNo;
	private String item;
	private String desc;
	private float price;

	public InvoiceClass() {
		itemNo = "";
		item = "";
		desc = "";
		price = 0f;
	}

	public InvoiceClass(String no, String item, String desc, float price) {
		this.itemNo = no;
		this.item = item;
		this.desc = desc;		
		this.price = price;
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

	public String getFormattedPrice() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(this.price);
	}

	public String getDisplayText() {
		return (this.itemNo + " | " + this.item + " | " + this.desc + " | " + getFormattedPrice());
	}

}
