/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TechMDQ
 */
public class BeerConsumer implements Runnable {

    private final BeerHouse contenedor;
    private final int idconsumidor;

    public BeerConsumer(BeerHouse contenedor, int idconsumidor) {
        this.contenedor = contenedor;
        this.idconsumidor = idconsumidor;
    }

    @Override
    /**
     * Implementación de la hebra
     */
    public void run() {
        //while (Boolean.TRUE) {
        while (contenedor.getStock()>0) {            
            contenedor.setStock(contenedor.getStock()-1);            
            System.out.println("El consumidor " + idconsumidor + " consume: 1 - Stock total= " + contenedor.getStock());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(BeerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
