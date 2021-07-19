
public class Player2 extends Player1{
	private 
		boolean armour;
		int health;
	
	public Player2(String name, String weapon, int health, boolean armour) {
		super(name, weapon, health);
		this.armour = armour;
		this.health = health;
	}
	
	public void damageBy_gun1() {
		if (armour == true) {
			health -= 20;
			if (health < 1)
				health = 0;
			
			System.out.println("Armour is on. " + "Got hit by gun1. " + "Health is reduced by 20. "
			+ "New health is " + health);
		} else {
			health -= 30;
			if (health < 1)
				health = 0;
			
			System.out.println("Armour is off. " + "Got hit by gun1. " + "Health is reduced by 30. "
			+ "New health is " + health);
		}
		
		if (health == 0)
			System.out.println(getName() + " is dead");
			
	}
	
	public void damageBy_gun2() {
		if (armour == true) {
			health -= 40;
			if (health < 1)
				health = 0;
			
			System.out.println("Armour is on. " + "Got hit by gun2. " + "Health is reduced by 40. "
			+ "New health is " + health);
		} else {
			health -= 50;
			if (health < 1)
				health = 0;
			
			System.out.println("Armour is off. " + "Got hit by gun2. " + "Health is reduced by 50. "
			+ "New health is " + health);
		}
		
		if (health == 0)
			System.out.println(getName() + " is dead");
	}
	
	public void heal() {
		if (this.health < 1)
			System.out.println(getName() + " is already dead. Heal doesn't possible");
		else {
			this.health = 100;
			System.out.println("New health is " + this.health);
		}
	}
	
	
}
