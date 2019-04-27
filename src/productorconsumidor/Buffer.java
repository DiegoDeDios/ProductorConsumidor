/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.LinkedList; 
import java.util.Queue;
public class Buffer {
    
    Queue<ArrayList> buffer;
    
    public Buffer(int bufferSize){
        this.buffer = new LinkedList<>();
    }
    
    synchronized void produce(ArrayList product){
         if(this.buffer.peek()!= null) {
            try {
                wait(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.buffer.add(product);
        
        notify();
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
        product = this.buffer.peek();
        this.buffer.remove();
        notify();
        
        return product;
    }
    
    
    
    
}
