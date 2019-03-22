package Main;

public class Main {
    public static void main(String[] args) {

        String path = "/home/dacha/eclipse-workspace/jfreechart//";
        String file = "KZ";

        Chart ch = new Chart();
        Rele r = new Rele();
        Fourier f =new Fourier();
        DataComtrade cd = new DataComtrade(path, file);
        cd.setChart(ch);
        cd.setRele(r);
        cd.run();
    }
}
