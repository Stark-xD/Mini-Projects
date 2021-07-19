
public class Game {

	public static void main(String[] args) {
		Player1 player = new Player1("Amit", "Sword", 100);
//		System.out.println(player.getName());
//		System.out.println(player.getHealth());
//		System.out.println(player.getWeapon());
//		player.damageBy_gun1();
//		player.damageBy_gun2();
//		player.damageBy_gun2();
//		player.heal();
		
		Player2 strongPlayer = new Player2("Stark", "Bazuka", 100, true);
		strongPlayer.damageBy_gun1();
		strongPlayer.damageBy_gun2();
		strongPlayer.damageBy_gun2();
		strongPlayer.heal();
	}

}
