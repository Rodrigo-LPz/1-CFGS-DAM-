/**
 *
 * @author RODRISTARK17
 * 
 */

package com.mycompany.pokemongame;

// Pokemon 'Pikachu'.
public class Pikachu extends Pokemons implements I_Lightning{
    
    // We must declare at least one parameter for each class we implement. This parameter will be an empty character.
    public Pikachu(){
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
    
    // Implementation of the different Lightning-type special attacks.
    @Override
    public void thundershockAttack(){
        System.out.println("    1. thundershockAttack\n");
    }
    @Override
    public void thunderpunchAttack(){
        System.out.println("    2. thunderpunchAttack\n");
    }
    @Override
    public void dischargeAttack(){
        System.out.println("    3. dischargeAttack");
    }
}