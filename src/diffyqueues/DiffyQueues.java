/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffyqueues;

import stripeik.diavid.diffyQ.FirstDerivative;
import stripeik.diavid.diffyQ.IntegratorRK4I;
import stripeik.diavid.diffyQ.Point;

/**
 *
 * @author David
 */
public class DiffyQueues {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Hey Dave: This is a test of the 1st derivative");
        
        CircuitI circI = new CircuitI(0.1, (double)500);
        FirstDerivative fD = (FirstDerivative) circI;
        Point p0 = new Point();
        
        p0.t0 = (double)0;
        Double tmax = (double)90;
        p0.y0 = (double)25;
        double h = (double)5;
        p0.d0 = fD.GetValue(p0.t0, p0.y0);
        
        IntegratorRK4I rk4I = new IntegratorRK4I(fD, p0, h);
        
        System.out.println("Test of Diffy Queue");
        System.out.println("t,s      Q,C       I,A");
        System.out.println("----------------------");
        System.out.format("%3.0f, %8.1f, %8.2f%n", p0.t0, p0.y0, -p0.d0);
        

        Point p = new Point();
        
            
            do {                
                rk4I.Step(p0);
                System.out.format("%3.0f, %8.1f, %8.2f%n", p0.t0, p0.y0, -p0.d0);
            } while (p0.t0 < tmax);
        }
            
}
