// package Arena.Characters;
// import Arena.Arena;
import java.util.Random;

public class Character {
	private static String[] nameList = {"Zero Cool","Boogie","Goldie","Freeman"};

    public static Random generator = new Random();
     
    public String name = "";
    
    public int strength = 10;
    public int health = 50;
    public int defense = 5;
     
    // Default constructor
    public Character(){       
        // Pick a character name at random
        this.name = nameList[Arena.generator.nextInt(nameList.length)];
    }
     
    // Overload constructor
    public Character(int strength, int defense, int health){
        this();
        this.strength = strength;
        this.defense = defense;
        this.health = health;     
    }
     
     
    // The code to run when this character attacks
    public int attack(Character target){
     
        // Apply damage formula
        int damageDealt = this.strength + generator.nextInt(this.strength) - this.strength / 2;
         
        // Tell the target to take this much damage, then return the amount of damage the target took.
        return target.takeDamage(damageDealt);
         
    }
     
    // The code to run when this character takes some damage
    public int takeDamage(int damage){
         
        // Apply defense formula
        int damageTaken = damage + this.defense;
         
        // Subtract the final damage number from this character's health
        this.health -= damageTaken;
         
        return damageTaken;
    }
     
}