package falseposition_methods;

import bisection_methods.BisectionCalculate;

public class FalsePositionCalculate extends BisectionCalculate{
    
//    public static void main(String[] args) {
//       
//        FalsePositionCalculate FPC = new FalsePositionCalculate();
//        FPC.runBracketingMethods(10.0, 3.0, -5.0, 10, 0.0, 10.0, 0.05);
//        System.out.println(FPC.getNum_iter());
//        System.out.println((FPC.getTableList()).length);
//        System.out.println((FPC.getTableList()).length);
//} 
    
    
    @Override
    public double xR(double A, double B, double C, double D, double x, double xL, double xU){      
        double fxL = super.function(A, B, C, D, xL);
        double fxU = function(A, B, C, D, xU);
        
        return (xL*fxU - xU*fxL)/(fxU - fxL);
    }
    
}
