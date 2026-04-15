/**
 *
 * @author RODRISTARK17
 * 
 */

package com.mycompany.pokemongame;


// We declare the "Pokemons" class as an abstract type. We'll use it as a template or guide for implementing the rest of the program, including classes, methods, and objects.
public abstract class Pokemons{
    
    // We create the attributes of the characteristics of the object, of the pokemon.
    protected int pokedexNum;
    protected int season;
    protected String Name;
    protected String Gender;
    protected double weight;
    
    // We create the attack methods of the object, of the pokemon.
    protected abstract void tackleAttack();
    protected abstract void scratchAttack();
    protected abstract void biteAttack();
    
}