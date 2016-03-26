/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffyqueues;

import stripeik.diavid.diffyQ.FirstDerivative;

/**
 *
 * @author David
 */
public class CircuitI implements FirstDerivative {
    
    double c;
    double r;

    public CircuitI(double c, double r) {
        this.c = c;
        this.r = r;
    }
    
    

    @Override
    public double GetValue(double t, double q) {
        
        double u = q / c;
        double i = -u / r;
        
        return i;
    }
    
}
