/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stripeik.diavid.diffyQ;

/**
 *
 * @author David
 */
public class IntegratorRK4I {
    FirstDerivative fisrtDerivative;
    Point p0 = new Point();
    double h;

    public IntegratorRK4I(FirstDerivative fisrtDerivative, Point p, double h) {
        this.fisrtDerivative = fisrtDerivative;
        p0 = p;
        p0.d0 = this.fisrtDerivative.GetValue(p0.t0, p0.y0);
        this.h = h;
    }
    
    public void Step(Point p1)
    {
        double k1 = p0.d0;
        double k2 = this.fisrtDerivative.GetValue(p0.t0 + h/2, p0.y0 + h /2 * k1);
        double k3 = this.fisrtDerivative.GetValue(p0.t0 + h/2, p0.y0 + h /2 * k2);
        double k4 = this.fisrtDerivative.GetValue(p0.t0 + h, p0.y0 + h * k3);
        
        p1.y0 = p0.y0 + h/6 * (k1 + 2 * k2 + 2 * k3 + k4);
        p1.t0 = p0.t0 + h;
        p1.d0 = this.fisrtDerivative.GetValue(p1.t0, p1.y0);
        
        p0 = p1;;
        
    }
    
}
