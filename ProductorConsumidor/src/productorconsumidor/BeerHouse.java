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
public class BeerHouse {

    private int stock;
    private boolean contenedorlleno = Boolean.FALSE;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
        return stock;
    }

    public synchronized void put(int value) {
        while (stock==100) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }
        stock = stock + value;
        contenedorlleno = Boolean.TRUE;
        notify();
    }
}
