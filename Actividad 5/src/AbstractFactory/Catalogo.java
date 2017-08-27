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
public class Catalogo {
    
    public Catalogo(){
        
    }
    
    public void nuevoVehiculo (String marca, String color, String tipo){
        if(tipo.equals("e")){
            FabricaVehiculo fabrica = new VehiculoElectricidad();
            Automovil auto = fabrica.crearAutomovil(marca, color);
            auto.fabricarAutomovil();
        }
        if(tipo.equals("g")){
            FabricaVehiculo fabrica = new VehiculoGasolina();
            Automovil auto = fabrica.crearAutomovil(marca, color);
            auto.fabricarAutomovil();
        }  
    }
    
    public void nuevaScooter (String marca, String color, String tipo){
        if(tipo.equals("e")){
            FabricaVehiculo fabrica = new VehiculoElectricidad();
            Scooter scooter = fabrica.crearScooter(marca, color);
            scooter.fabricarScooter();
        }
        if(tipo.equals("g")){
            FabricaVehiculo fabrica = new VehiculoGasolina();
            Scooter scooter = fabrica.crearScooter(marca, color);
            scooter.fabricarScooter();
        }    
    }
}
