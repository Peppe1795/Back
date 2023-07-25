package it.epicode.be.godfather.model;

public class DrinkLemonade extends Drink {

	@Override
	public String toString() {
		return "DrinkLemonade";
	}

	public DrinkLemonade() {
		super("Lemonade", 1.29, 128d);
	}

}
