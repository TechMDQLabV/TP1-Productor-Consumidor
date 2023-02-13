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
public class BeerHouse {

    private int contenido;
    private boolean contenedorlleno = Boolean.FALSE;

    public int getContenido() {
        return contenido;
    }

    public synchronized int get() {
        while (!contenedorlleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());
            }
        }
        contenedorlleno = Boolean.FALSE;
        notify();
        return contenido;
    }

    public synchronized void put(int value) {
        while (contenedorlleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }
        contenido = value;
        contenedorlleno = Boolean.TRUE;
        notify();
    }
}
