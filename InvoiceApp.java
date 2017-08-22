import java.util.Scanner;
import java.text.NumberFormat;

public class InvoiceApp {
	public static void main(String[] args) {
		final double SALES_TAX_PCT = .05;
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")){
			//get input from user
			System.out.print("Enter subtotal: ");
			double subtotal = sc.nextDouble();
			
			//calculate results
			double discountPercent = 0.0;
			if (subtotal >= 100)
				discountPercent = .1;
			else
				discountPercent = 0.0;
			double discountAmount = subtotal * discountPercent;
			double totalBeforeTax = subtotal - discountAmount;
			double salesTax = totalBeforeTax * SALES_TAX_PCT;
			double total = totalBeforeTax + salesTax; 
			
			//format & display result
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			NumberFormat percent = NumberFormat.getPercentInstance();
			//String message = 
			String debuggingMessage = "\nUnformated Results\n" +
					"Discount Percent: 		" + discountPercent + "\n" +
					"Discount amount : 		" + discountAmount + "\n" +
					"Total before tax: 		" + totalBeforeTax + "\n" +
					"Sales tax: 		" + salesTax + "\n" +
					"Invoice total:		 " + total + "\n" + 
				
					"\nFormatted Results\n" +
					"Discount Percent: 		" + percent.format(discountPercent) + "\n" +
					"Discount amount : 		" + percent.format(discountAmount) + "\n" +
					"Total before tax: 		" + percent.format(totalBeforeTax) + "\n" +
					"Sales tax: 		" + percent.format(salesTax) + "\n" +
					"Invoice total:		 " + percent.format(total) + "\n";
			System.out.print(debuggingMessage);
			
			//see if user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}

	}

}
