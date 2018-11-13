package state;

public class RentableState implements State {
	private Article article;
	
	public RentableState(Article article) {
		this.article = article;
	}

	@Override
	public void rent() {
		this.article.setState(article.getRentedState());
	}

	@Override
	public void bringBack() {
		throw new StateException("Can't return an article in the Rentable state!");
	}

	@Override
	public void remove() {
		this.article.setState(article.getRemovedState());
	}

	@Override
	public void repair() {
		throw new StateException("Can't repair an article in the Rentable state!");
	}
	
	@Override
	public String toString() {
		return "Available";
	}
}
