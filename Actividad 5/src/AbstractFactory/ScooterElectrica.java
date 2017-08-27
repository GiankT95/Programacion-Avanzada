package AbstractFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class ScooterElectrica extends Scooter{
    
    public ScooterElectrica(String color, String marca){
        this.color = color;
        this.marca = marca;
        this.setTipo("electrica");
    }

    @Override
    public void fabricarScooter() {
        System.out.println("Nueva scooter "+this.getTipo()+" marca " +this.getMarca()+ " de color " +this.getColor()+ " fabricada");
    }
    
    
}
