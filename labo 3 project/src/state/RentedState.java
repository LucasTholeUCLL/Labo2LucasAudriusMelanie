package state;

public class RentedState implements State {
private Article article;
	
	public RentedState(Article article) {
		this.article = article;
	}

	@Override
	public void rent() {
		throw new StateException("Can't rent a rented article!");
	}

	@Override
	public void bringBack() {
		if (article.isDamaged()) {
			article.setState(article.getDamagedState());
		} else {
			article.setState(article.getRentableState());
		}
	}

	@Override
	public void remove() {
		throw new StateException("Can't remove a rented arcticle!");
	}

	@Override
	public void repair() {
		throw new StateException("Can't repair a rented article!");
	}
	
	@Override
	public String toString() {
		return "Rented out";
	}
}
