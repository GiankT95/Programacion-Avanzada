package AbstractFactory;


import AbstractFactory.FabricaVehiculo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class VehiculoElectricidad implements FabricaVehiculo{

    @Override
    public Automovil crearAutomovil(String marca, String color) {
        return new AutomovilElectrico(marca, color);
    }

    @Override
    public Scooter crearScooter(String marca, String color) {
        return new ScooterElectrica(color, marca);
    }
    
}
