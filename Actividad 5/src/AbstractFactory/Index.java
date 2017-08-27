package AbstractFactory;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Asus
 */
public class Index {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Catalogo catalogo = new Catalogo();
        
        /*catalogo.nuevoVehiculo("Mercedez", "Negro", "e");
        catalogo.nuevoVehiculo("Ferrari", "Rojo", "g");
        
        catalogo.nuevaScooter("Yamaha", "azul", "e");
        catalogo.nuevaScooter("Honda", "naranja", "g");
        */
     
        int opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Selccione una opcion del catalogo: \n"
                                                                   + "(1) Automovil.\n"
                                                                   + "(2) Scooter.\n"));
        
        if(opc == 1){
            String tipo = JOptionPane.showInputDialog(null, "Seleccione un tipo: \n"
                                                          + "(e) --> Electrico\n"
                                                          + "(g) --> Gasolina");
            String color = JOptionPane.showInputDialog(null, "Digite un color:");
            String marca = JOptionPane.showInputDialog(null, "Digite una marca:");
            
            catalogo.nuevoVehiculo(marca, color, tipo);
            
        }
        
        if(opc == 2){
            String tipo = JOptionPane.showInputDialog(null, "Seleccione un tipo: \n"
                                                          + "(e) Electrico\n"
                                                          + "(g) Gasolina");
            String color = JOptionPane.showInputDialog(null, "Digite un color:");
            String marca = JOptionPane.showInputDialog(null, "Digite una marca:");
            
            catalogo.nuevaScooter(marca, color, tipo);
        }
    }
    
}
