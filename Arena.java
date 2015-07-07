// package Arena;
// import Arena.Characters.*;
// import Arena.Characters.Character;

import java.util.Random;
import java.util.Scanner;

public class Arena {
     
    // Create a random number generator for everyone to use. This is easier than every character having their own.
    // the "static" keyword means that there will only ever be one of these.
    public static Random generator = new Random();
     
    public static void main(String[] args) {
    	
    	//declaring a Scanner
    	Scanner input = new Scanner(System.in);
         
        // Create 2 instances of Character
        Butcher player1 = new Butcher();
        // Picks a name from nameList, strength, defense, health
        Character player2 = new Character(10,10,100);
        // overloading 
        player2.name = "Steve";   
        
        int choice = -1;
        int stabDamage = 0;
        // both have to be true to continue.
        // no try-catch for the sake of simplicity.
        while(choice != 3 && player1.health > 0){
        	if(player1.stab){
        		player2.health -= player1.stabDamage;
        	}
        	System.out.print(player1.name + " vs. " + player2.name + "\n" + player1.health + " HP vs. " + player2.health + " HP (Stab Damage: " + player1.stabDamage + ")" + "\n\nWhat do?\n1.Attack!\n2.Show Stats\n3.Run Away!\nChoose your fate: ");
        	choice = input.nextInt();
        	// choose to attack
        	if(choice == 1){
        		System.out.println("What kind of attack?\n1.Melee\n2.Throw Cleaver(" + player1.cleavers + " remaining)");
        		int attackType = input.nextInt();
        		// melee attack
        		if(attackType == 1){
        			System.out.println("You did " + player1.attack(player2) + " damage.\n"+ player2.name + " attacks! You took  " + player2.attack(player1) + " damage.\n");
        			// cleaver attack, why is this an 'else-if' instead of just an 'else'?
        		}else if(attackType == 2){
        			player1.stab = true;
        			if(player1.cleavers > 0){
        				player1.stabDamage++;
        				player1.cleavers--;
        				System.out.println("You cleaver'd " + player1.cleaverize(player2) + " damage.\n"+ player2.name + " attacks! You took  " + player2.attack(player1) + " damage.\n");
        			}	
        		}
        	} else if(choice == 2){
                showStats(player1);
                showStats(player2);
                System.out.println("\n");
            }
        }
        // always close the Scanner after use. Why is this outside of the while-loop?
    	input.close();
    	// we are dead or chose to quit.
        System.out.println("Goodbye!");
        
    } // end main

    public static void showStats(Character player){
        System.out.println(player.name + " - Strength: " + player.strength + ", Defense: " + player.defense);
    }
 
}