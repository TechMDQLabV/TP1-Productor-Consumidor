/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.Random;

/**
 * probando edit
 * @author TechMDQ
 */
public class BeerProducer implements Runnable {

    private final Random aleatorio;
    private final BeerHouse contenedor;
    private final int idproductor;
    private final int TIEMPOESPERA = 500;
    private boolean terminar = TRUE;

    public BeerProducer(BeerHouse contenedor, int idproductor) {
        this.contenedor = contenedor;
        this.idproductor = idproductor;
        aleatorio = new Random();
    }

    @Override
    public void run() {
        while (terminar) {
            int poner = aleatorio.nextInt(20);
            contenedor.put(poner);
            System.out.println("El productor " + idproductor + " pone: " + poner);
            try {
                Thread.sleep(TIEMPOESPERA);
            } catch (InterruptedException e) {
                System.err.println("Productor " + idproductor + ": Error en run -> " + e.getMessage());
            }
            if (contenedor.getContenido() == 0) {
                terminar = FALSE;
                System.out.println("<<< Bar cerrado >>>");
                System.exit(0);  // esto no me gusta. Como hago para terminar el programa?
            }
        }
    }

}
