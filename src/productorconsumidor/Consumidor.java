package productorconsumidor;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor extends Thread {
    
    private long espera;
    private Buffer buffer;
    
    public Consumidor(long espera, Buffer buffer) {
        this.espera = espera;
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        System.out.println("Running Consumer...");
        ArrayList product;
        
        while(true) {
            product = this.buffer.consume();
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
