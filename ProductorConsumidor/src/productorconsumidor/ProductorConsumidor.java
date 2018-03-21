/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

/**
 *
 * @author TechMDQ
 */
public class ProductorConsumidor {

    private static BeerHouse contenedor;
    private static Thread productor;
    private static Thread[] consumidores;
    private static final int CANTIDADCONSUMIDORES = 25;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        contenedor = new BeerHouse();
        productor = new Thread(new BeerProducer(contenedor, 1));
        consumidores = new Thread[CANTIDADCONSUMIDORES];

        for (int i = 0; i < CANTIDADCONSUMIDORES; i++) {
            consumidores[i] = new Thread(new BeerConsumer(contenedor, i));
            consumidores[i].start();
        }

        productor.start();
    }

}
