/*
 *
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
 *
 * @author RODRISTARK17
 *
 */

package com.mycompany.pokemongame;

// We create the parent class, superclass, with which to start towards the other classes.
public class Game{
    
    // We declare the main method, to handle objects, pokemos, and make references to classes and/or attributes of these.
    public static void main(String[] args){
        // We assign each of the created 'pokemons' (Bulbasaur, Charmander, Squirtle and Pikachu) their object reference.
        Bulbasaur bulbasaur = new Bulbasaur();
        Charmander charmander = new Charmander();
        Squirtle squirtle = new Squirtle();
        Pikachu pikachu = new Pikachu();
        
        // We call each of the methods of each of the Pokémon, that is, we instantiate/relate each created object with its respective attacks.
            // For 'Bulbasaur'.
            System.out.println("Generic Attacks - Pokemons: ");
            bulbasaur.tackleAttack();
            bulbasaur.scratchAttack();
            bulbasaur.biteAttack();
            
            System.out.println("\n\nBulbasaur's Plant-Type Special Attacks: ");
            bulbasaur.leechseedAttack();
            bulbasaur.razorleafAttack();
            bulbasaur.sporeAttack();
            
            System.out.println("\n--------------------------------------------------\n");
            
            // For 'Charmander'.
            System.out.println("Generic Attacks - Pokemons: ");
            charmander.tackleAttack();
            charmander.scratchAttack();
            charmander.biteAttack();
            
            System.out.println("\n\nCharmander's Fire-Type Special Attacks: ");
            charmander.flamethrowerAttack();
            charmander.firepunchAttack();
            charmander.emberAttack();
            
            System.out.println("\n--------------------------------------------------\n");
            
            // For 'Squirtle'.
            System.out.println("Generic Attacks - Pokemons: ");
            squirtle.tackleAttack();
            squirtle.scratchAttack();
            squirtle.biteAttack();
            
            System.out.println("\n\nSquirtle's Water-type Special Attacks: ");
            squirtle.hydropumpAttack();
            squirtle.bubbleAttack();
            squirtle.watergunAttack();
            
            System.out.println("\n--------------------------------------------------\n");
            
            // For 'Pikachu'.
            System.out.println("Generic Attacks - Pokemons: ");
            pikachu.tackleAttack();
            pikachu.scratchAttack();
            pikachu.biteAttack();
            
            System.out.println("\n\nPikachu's Lightning-Type Special Attacks: ");
            pikachu.thundershockAttack();
            pikachu.thunderpunchAttack();
            pikachu.dischargeAttack();
    }
}