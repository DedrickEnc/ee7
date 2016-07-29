/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.servlet.AsyncContext;

/**
 *
 * @author IMA7
 */
public class MyAsyncService implements Runnable{
    
    AsyncContext ac;

    public MyAsyncService(AsyncContext ac) {
        this.ac = ac;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
        }
        
        ac.complete();
    }    
}
