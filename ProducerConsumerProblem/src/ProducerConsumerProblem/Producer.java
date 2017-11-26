/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducerConsumerProblem;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HiAS
 */
public class Producer extends Thread{

    @Override
    public void run() {
        while(true){
            ProdConsFail.test++;
            if (ProdConsFail.N == ProdConsFail.count) {
                try {
                    synchronized(this){
                        System.out.println("Going to sleep");
                        this.wait();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ProdConsFail.count++;
            System.out.println("Waking up");
            if (ProdConsFail.count == 1) {
                try {
                    ProdConsFail.wakeUp("cons");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
