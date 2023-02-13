/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

/**
 * probando edit
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
        while (Boolean.TRUE) {
            System.out.println("El consumidor " + idconsumidor + " consume: " + contenedor.get());
        }
    }

}
