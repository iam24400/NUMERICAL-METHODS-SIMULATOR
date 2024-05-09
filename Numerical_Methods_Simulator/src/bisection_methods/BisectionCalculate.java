package bisection_methods;

import java.util.Arrays;


public class BisectionCalculate {
    
//    public static void main(String[] args) {
//         
//        BisectionCalculate BC = new BisectionCalculate();
//        BC.runBracketingMethods(0.0, 0.0, 1.0, 10, -20.0, -5.0, 0.000000000000000000000000001);
//        System.out.println(BC.getNum_iter());
//        System.out.println((BC.getTableList()).length);
//        System.out.println((BC.getTableList()).length);
//} 
   
    
    private int num_iter;
    private Double[][] TableList;
    
    
    public void setNum_iter(int num_of_iter) {
        this.num_iter = num_of_iter;
    }

    public int getNum_iter() {
        return num_iter;
    }
    
    public Double[][] getTableList(){
        return TableList.clone();
    }
    
    
    public void runBracketingMethods(double A, double B, double C, double D, double xL, double xU, double Es) {
        
        checkIterationNum(A, B, C, D, xL, xU, Es);
        
        TableList = new Double[getNum_iter()][8];
        
        double x = 0;
        double xM0 = 0;
        double iter = 1.0;
        int row = 0;

        while (true) {
            double xM = xR(A, B, C, D, x, xL, xU);
            double Ea = Math.abs((xM - xM0)/xM) * 100;         
            double fxL = function(A, B, C, D, xL);
            double fxM = function(A, B, C, D, xM);
            double fxU = function(A, B, C, D, xU);

            TableList[row][0] = iter;
            TableList[row][1] = xL;
            TableList[row][2] = xM;
            TableList[row][3] = xU;
            TableList[row][4] = fxL;
            TableList[row][5] = fxM;
            TableList[row][6] = fxU;
            TableList[row][7] = Ea;

            if (Ea < Es){break;}

            if (fxL * fxM < 0) {xU = xM;} 
            else {xL = xM;}

            xM0 = xM;
            iter ++;
            row++;

            }

//        for (Double[] element: TableList) {
//            System.out.println(Arrays.toString(element));
//        }

    }
    
    public void checkIterationNum(double A, double B, double C, double D, double xL, double xU, double Es) {
        
        double x = 0;
        double xM0 = 0;
        double iter = 1.0;
        int row = 0;

        while (true) {
            double xM = xR(A, B, C, D, x, xL, xU);
            double Ea = Math.abs((xM - xM0)/xM) * 100;         
            double fxL = function(A, B, C, D, xL);
            double fxM = function(A, B, C, D, xM);

            if (Ea < Es){break;}

            if (fxL * fxM < 0) {xU = xM;} 
            else {xL = xM;}

            xM0 = xM;
            iter ++;
            row++;

            }
        
        int iter_num = (int) iter;
        setNum_iter(iter_num);   
        
    }

    public double function(double A, double B, double C, double D, double x){
        return A*Math.pow(x,3) + B*Math.pow(x,2) + C*x + D;   
    } 
    
    public double xR(double A, double B, double C, double D, double x, double xL, double xU){
        return (xL + xU)/2;
    }
        
    
}


