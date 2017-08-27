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
public interface FabricaVehiculo {
    
    public abstract Automovil crearAutomovil(String marca, String color);
    public abstract Scooter crearScooter(String marca, String color);
}
