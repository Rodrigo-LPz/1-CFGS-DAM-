/**
 *
 * @author RODRISTARK17
 * 
 */

package com.mycompany.pokemongame;

// Pokemon 'Squirtle'.
public class Squirtle extends Pokemons implements I_Water{
    
    // We must declare at least one parameter for each class we implement. This parameter will be an empty character.
    public Squirtle(){
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
    
    // Implementation of the different Water-type special attacks.
    @Override
    public void hydropumpAttack(){
        System.out.println("    1. hydropumpAttack\n");
    }
    @Override
    public void bubbleAttack(){
        System.out.println("    2. bubbleAttack\n");
    }
    @Override
    public void watergunAttack(){
        System.out.println("    3. watergunAttack");
    }
}