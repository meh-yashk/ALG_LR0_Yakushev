package Main;

public class Fourier {

    private double sin[] = new double[128];
    private double cos[] = new double[128];
    private double sin2[] = new double[128];
    private double cos2[] = new double[128];
    private double buffer[] = new double[128];
    private double sigXs = 0.0, sigX = 0.0;
    private double sigYs = 0.0, sigY = 0.0;
    private int number = 0;
//    private
//    private double kf = (double) 2/80;
    private double kf = (double) Math.sqrt(2)/128;      //    вместо амплитуды будет действующее значение

    public Fourier(){
        for(int i=0;i<128;i++){
            sin[i] = Math.sin(2*Math.PI*i/128);
            cos[i] = Math.cos(2*Math.PI*i/128);
        }
        for(int i=0;i<128;i++){
            sin2[i] = Math.sin(2*2*Math.PI*i/128);
            cos2[i] = Math.cos(2*2*Math.PI*i/128);
        }
    }
    public double getRMS(double instValue){
        sigXs = sigXs + instValue*cos[number] - buffer[number]*cos[number];
        sigYs = sigYs + instValue*sin[number] - buffer[number]*sin[number];
        sigX = sigXs*kf;
        sigY = sigYs*kf;
        buffer[number] = instValue;

        number++;
        if(number==128)
            number = 0;
        return Math.sqrt(sigX*sigX + sigY*sigY);

    }
//    public double getHaara(int w){
//        int w = 128;
//        I1[num] = I1[num] + j - I[buff];
//        i[buff];
//        num++;
//    }
}
