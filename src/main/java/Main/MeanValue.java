package Main;

public class MeanValue {
    private double buffer[] = new double[40];
    private int number = 0;
    private double k = (double) Math.sqrt(2)/40;
    private double sigS = 0.0, sigMean = 0.0;

    public double get(double instValue){
        sigS = sigS + Math.abs(instValue) - buffer[number];
        buffer[number] = instValue;
        number++; if(number==40) number=0;
        return sigS*k;
    }
}
