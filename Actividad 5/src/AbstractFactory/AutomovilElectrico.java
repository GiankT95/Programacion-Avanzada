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
public class AutomovilElectrico extends Automovil{

    public AutomovilElectrico(String marca, String color){
        this.marca = marca;
        this.color = color;
        this.setTipo("electrico");
    }
    
    @Override
    public void fabricarAutomovil() {
        System.out.println("Nuevo vehiculo "+this.getTipo()+" marca " +this.getMarca()+ " de color " +this.getColor()+ " ha sido fabricado");
    }
    
}
