package app;

import javax.swing.JOptionPane;

import domain.Shop;
import state.Article;

public class ShopApp {
	private Shop shop;
	
	public ShopApp(Shop shop) {
		this.shop = shop;
	}
	
	public void launch() {
		String input = "-1";
		while (!input.equals("0")) {
			input = JOptionPane.showInputDialog("1. Add party item"+
												"\n2. Remove party item"+
												"\n3. Rent party item"+
												"\n4. Return party item"+
												"\n5. Repair party item"+
												"\n6. Show available party items"+
												"\n \n0. Stop\n  \nMake your choice");
			switch (input) {
				case "1":
					this.addPartyItem();
					break;
				/*case "2":
					this.removePartyItem();
					break;*/
				case "4":
					this.returnPartyItem();
					break;
				case "6":
					this.getAvailable();
					break;
			default:
			}
		}
	}
	
	private void getAvailable() {
		String output = "Available Party items:\n";
		for (Article a : shop.getRentableArticles()) {
			output+="\n" + a.toString();
		}
		JOptionPane.showMessageDialog(null, output);
	}
	
	private void addPartyItem() {
		try {
			String name = JOptionPane.showInputDialog("Enter the name for the party item:");
			double price = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of the party item:"));
			Article article = new Article(name, price);
			this.shop.addArticle(article);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "An error occured:\n \n" + e.getMessage());
			addPartyItem();
		}
	}
	
	/*private void removePartyItem() {
		String input = JOptionPane.showInputDialog(null, "Choose article to remove", "test", JOptionPane.QUESTION_MESSAGE, null, choices, choices);
	}*/
	
	private void returnPartyItem() {
		
	}
}
