/**
 *
 * @author RODRISTARK17
 * 
 */

package com.mycompany.pokemongame;

// Pokemon 'Bulbasaur'.
public class Bulbasaur extends Pokemons implements I_Plant{
    
    // We must declare at least one parameter for each class we implement. This parameter will be an empty character.
    public Bulbasaur(){
    }
    
    // Implementation of the different generic attacks.
    @Override
    protected void tackleAttack(){
        System.out.println("    1. tackleAttack\n");
    }
    @Override
    protected void scratchAttack(){
        System.out.println("    2. scratchAttack\n");
    }
    @Override
    protected void biteAttack(){
        System.out.println("    3. biteAttack");
    }
    
    // Implementation of the different Plant-type special attacks.
    @Override
    public void leechseedAttack(){
        System.out.println("    1. leechseedAttack\n");
    }
    @Override
    public void razorleafAttack(){
        System.out.println("    2. razorleafAttack\n");
    }
    @Override
    public void sporeAttack(){
        System.out.println("    3. sporeAttack");
    }
}