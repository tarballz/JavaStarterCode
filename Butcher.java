// package Arena.Characters;
// import Arena.Arena;
import java.util.Random;

public class Butcher extends Character {
	public int cleavers = 5;
	public boolean stab = false;
	public int stabDamage = 0;
	
	public Butcher(){
		// super() runs the default constructor from the parent class
		super();
		this.strength = 6;
		this.defense = 10;
	}
	
	 public int attack(Character target){
		 Random rand = new Random();
		 int buff = rand.nextInt(2);
		 // damage algorithm
		 int damage = this.strength + generator.nextInt(this.strength) - this.strength / 2;
		 // if he hurts himself
		 if(buff == 0){
			 this.health -= damage;
			 System.out.println("Oh no! Butter fingers :( , you took " + damage + " damage");
			 //return target.takeDamage(0);
			 return 0;
		 }
		 // if he does triple damage
		 if(buff == 1){
			 System.out.println("Triple damage!");
			 damage *= 3;
		 }
		 // normal attack
		 return target.takeDamage(damage);
		 
	  }
	 
	 public int cleaverize(Character target){
		// damage algorithm
		int damage = this.strength + generator.nextInt(this.strength) - this.strength / 2;
		return target.takeDamage(damage);
	 }
}
