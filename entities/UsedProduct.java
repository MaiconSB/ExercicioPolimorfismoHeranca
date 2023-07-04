package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{

	private DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LocalDate manufacture;
	
	UsedProduct() {}

	public UsedProduct(String name, Double price, LocalDate manufacture) {
		super(name, price);
		this.manufacture = manufacture;
	}

	public LocalDate getManufacture() {
		return manufacture;
	}

	public void setManufacture(LocalDate manufacture) {
		this.manufacture = manufacture;
	}
	 
	@Override
	public String priceTag() {
		return name + " (used) $ " + price + "(Manufacture date: $ " + manufacture.format(fm1) + ")";
	} 

}
