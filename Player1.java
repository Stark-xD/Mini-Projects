
public class Player1 {
	private String name;
	private int health;
	private String weapon;
		
	public Player1(String name, String weapon, int health) {
		this.name = name;
		this.health = health;
		this.weapon = weapon;
	}
		
	public void damageBy_gun1(){
		health -= 40;
		if (health < 1) 
			health = 0;
			
		System.out.println("Got hit by Gun1. Health is reduced by 40" + ". New health is "+ health);
		if (health == 0)
			System.out.println(name + " is dead.");
	}
		
	public void damageBy_gun2() {
		health -= 20;
		if (health < 1) 
			health = 0;
			
		System.out.println("Got hit by Gun2. Health is reduced by 20" + ". New health is "+ health);
		if (health == 0)
			System.out.println(name + " is dead.");
	}
	
	public void heal() {
		if (this.health < 1)
			System.out.println(getName() + " is already dead. Heal doesn't possible");
		else {
			this.health = 100;
			System.out.println("New health is " + this.health);
		}
	}
	
	public String getName() {
        return name;
    }
	
    public String getWeapon() {
        return weapon;
    }

    public int getHealth() {
        return health;
    }
}
