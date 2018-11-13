package state;

public class DamagedState implements State {
private Article article;
	
	public DamagedState(Article article) {
		this.article = article;
	}

	@Override
	public void rent() {
		throw new StateException("Can't rent a damaged article!");
	}

	@Override
	public void bringBack() {
		throw new StateException("Can't return a damaged article!");
	}

	@Override
	public void remove() {
		article.setState(article.getRemovedState());
	}

	@Override
	public void repair() {
		article.setState(article.getRentableState());
	}
	
	@Override
	public String toString() {
		return "Damaged";
	}
}
