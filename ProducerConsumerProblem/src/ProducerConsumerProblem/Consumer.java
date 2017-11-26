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
public class Consumer extends Thread{

    @Override
    public void run() {
        while(true){
            if (ProdConsFail.count == 0) {
                try {
                    synchronized(this){
                        System.out.println("Sleeping 2");
                        this.wait();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ProdConsFail.test--;
            System.out.println("Wakeup 2");
            ProdConsFail.count--;
            if (ProdConsFail.count == ProdConsFail.N-1) {
                try {
                    ProdConsFail.wakeUp("prod");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
