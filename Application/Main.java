package Application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.UsedProduct;
import entities.Product;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.print("Customs free: ");
				Double customsFree = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFree));
			} else if(ch == 'u') {
				System.out.print("Manufacture date: (DD/MM/YYYY)");
				String dataString = sc.next();
				LocalDate data = LocalDate.parse(dataString, fmt1);
				list.add(new UsedProduct(name, price, data));
			} else {
				list.add(new Product(name, price));
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS: ");
		
		for(Product x : list) {
			System.out.println(x.priceTag());
		}
		
		
		
		sc.close();
	}

}
