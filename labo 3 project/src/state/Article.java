package state;

public class Article {
	private State rentableState;
	private State rentedState;
	private State damagedState;
	private State removedState;
	
	private String name;
	private double price;;

	private boolean damaged;
	
	State state = rentableState;
	
	public Article(String name, double price) {
		this.rentableState=new RentableState(this);
		this.rentedState=new RentedState(this);
		this.damagedState=new DamagedState(this);
		this.removedState=new RemovedState(this);
		
		this.setState(this.getRentableState());
		
		this.damaged = false;
		
		setName(name);
		setPrice(price);
	}
	
	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name can't be empty!");
		this.name = name;
	}
	
	public void setPrice(double price) {
		if (price < 0) throw new IllegalArgumentException("Price can't be negative");
		this.price = price;
	}
	
	public void setState(State state) {
		this.state = state;
	}

	public State getRentableState() {
		return rentableState;
	}

	public State getRentedState() {
		return rentedState;
	}


	public State getDamagedState() {
		return damagedState;
	}


	public State getRemovedState() {
		return removedState;
	}


	public boolean isDamaged() {
		return damaged;
	}

	public void setDamaged(boolean damaged) {
		this.damaged = damaged;
	}

	public State getState() {
		return state;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	@Override
	public String toString() {
		return name + " - price: " + price + " - State: " + this.getState().toString();
	}
	
}
