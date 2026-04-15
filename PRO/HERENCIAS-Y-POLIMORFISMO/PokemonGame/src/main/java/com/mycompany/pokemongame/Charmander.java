/**
 *
 * @author RODRISTARK17
 * 
 */

package com.mycompany.pokemongame;

// Pokemon 'Charmander'.
public class Charmander extends Pokemons implements I_Fire{
    
    // We must declare at least one parameter for each class we implement. This parameter will be an empty character.
    public Charmander(){
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
    
    // Implementation of the different Fire-type special attacks.
    @Override
    public void flamethrowerAttack(){
        System.out.println("    1. flamethrowerAttack\n");
    }
    @Override
    public void firepunchAttack(){
        System.out.println("    2. firepunchAttack\n");
    }
    @Override
    public void emberAttack(){
        System.out.println("    3. emberAttack");
    }
}