package state;

public class RemovedState implements State {
	private Article article;
	
	public RemovedState(Article article) {
		this.article = article;
	}

	@Override
	public void rent() {
		throw new StateException("Can't rent a removed article!");
	}

	@Override
	public void bringBack() {
		throw new StateException("Can't return a removed article!");
	}

	@Override
	public void remove() {
		throw new StateException("Can't remove a removed article!");
	}

	@Override
	public void repair() {
		throw new StateException("Can't repair a removed article!");
	}
	
	@Override
	public String toString() {
		return "Removed";
	}
}
