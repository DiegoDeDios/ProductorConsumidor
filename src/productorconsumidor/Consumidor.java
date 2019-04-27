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
        
        while(true) {
            ArrayList product;
            
            product = this.buffer.consume();
            
            System.out.println("Consumer consumed " + product.toString());
            
            switch((char)product.get(0)) {
                case '+':
                    //TODO Access GUI to display result
                    break;
                case '-':
                    //TODO Access GUI to display result
                    break;
                case '*':
                    //TODO Access GUI to display result
                    break;
                case '/':
                    //TODO Access GUI to display result
                    break;
                default:
                    break;
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
