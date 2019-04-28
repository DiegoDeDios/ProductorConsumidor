package productorconsumidor;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor extends Thread {
    
    private String id;
    private long espera;
    private Buffer buffer;
    
    public Consumidor(String id, long espera, Buffer buffer) {
        this.id = id;
        this.espera = espera;
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        System.out.println("Running Consumer...");
        
        while(true) {
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            ArrayList product;
            
            product = this.buffer.consume();
            
            if(product.size() != 0) {
                System.out.println("Consumer " + this.id +  " consumed " + product.toString());
            
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
            }
            
            
            try {
                Thread.sleep(espera);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
