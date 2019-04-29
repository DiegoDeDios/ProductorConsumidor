package productorconsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.LinkedList; 
import java.util.NoSuchElementException;
import java.util.Queue;

public class Buffer {
    
    public Queue<ArrayList> buffer;
    private int buffLimit;
    
    public Buffer(int limit){
        this.buffer = new LinkedList<>();
        this.buffLimit = limit;
    }
    
    synchronized boolean produce(ArrayList product){
        
        if(this.buffer.size() < this.buffLimit) {
            this.buffer.add(product);
            return true;
        }
        
        return false;
    }
    
    synchronized ArrayList consume(){
        ArrayList product = new ArrayList();
        
        if(this.buffer.peek() == null){
            try {
                wait(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            product = this.buffer.remove();
            notify();
        } catch(NoSuchElementException e) {
            
        } finally {
        
            return product;
        
        }
    }
    
    
    
    
}
