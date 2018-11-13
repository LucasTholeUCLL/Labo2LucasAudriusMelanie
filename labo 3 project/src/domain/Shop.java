package domain;

import java.util.ArrayList;
import java.util.List;

import state.*;


public class Shop {
	private List<Article> articles;
	
	public Shop() {
		this.articles = new ArrayList<Article>();
	}
	
	public Shop(ArrayList<Article> articles) {
		this.articles = articles;
	}
	
	public void addArticle(Article article) {
		if (article == null) throw new IllegalArgumentException("Article cant be null");
		this.articles.add(article);
	}
	
	public List<Article> getArticles() {
		return this.articles;
	}
	
	public List<Article> getRentableArticles() {
		ArrayList<Article> list = new ArrayList<>();
		for (Article a : this.articles) {
			if (a.getState().equals(a.getRentableState())) list.add(a);
		}
		return list;
	}
}
