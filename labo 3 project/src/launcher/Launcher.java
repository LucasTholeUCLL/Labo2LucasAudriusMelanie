package launcher;

import java.util.ArrayList;

import app.ShopApp;
import domain.Shop;
import state.Article;

public final class Launcher {

	public static void main(String[] args) {
		ArrayList<Article> articles = new ArrayList<Article>();
		
		Article a1 = new Article("Article one", 5.00);
		Article a2 = new Article("Arcticle two", 10.00);
		a2.setState(a2.getRentedState());
		Article a3 = new Article("Article three", 20.00);
		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
		
		Shop shop = new Shop(articles);
		ShopApp app = new ShopApp(shop);
		
		
		app.launch();

	}

}
