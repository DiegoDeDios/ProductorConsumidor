package productorconsumidor;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor extends Thread{
    
    private long espera = 500;
    private Buffer buffer;
    
    public Productor(long espera, Buffer buffer) {
        this.espera = espera;
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        System.out.println("Running Producer...");
        
        String operands = "+-*/";
        
        Random r = new Random(System.currentTimeMillis());
        
        ArrayList product = new ArrayList<>();
        
        for(int i=0 ; i<15 ; i++) {
            
            product.add(operands.charAt(r.nextInt(4)));
            product.add(r.nextInt(10));
            product.add(r.nextInt(10));
            
            this.buffer.produce(product);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
