/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

/**
 *
 * @author Asus
 */
public class ScooterGasolina extends Scooter{

    public ScooterGasolina(String color, String marca){
        this.color = color;
        this.marca = marca;
        this.setTipo("gasolina");
    }
    
    @Override
    public void fabricarScooter() {
        System.out.println("Nueva scooter " +this.getTipo()+ " de marca " +this.getMarca()+ " y color " +this.getColor()+ " ha sido fabricada");
    }
    
}
