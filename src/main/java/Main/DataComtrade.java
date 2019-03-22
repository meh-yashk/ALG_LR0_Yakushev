package Main;

import java.io.*;
import java.util.Arrays;

public class DataComtrade {
    private File comtrCfg;
    private File comtrData;
    private BufferedReader br;
    private String line;
    private String[] lineData;
    private double k1[] = new double[2];
    private double k2[] = new double[2];
    private Chart ch;
    private Rele r;

    public DataComtrade(String path, String file) {
        comtrCfg = new File(path + file + ".cfg");
        comtrData = new File(path + file + ".dat");

    }

    public void run() {
        try {
            br = new BufferedReader(new FileReader(comtrCfg));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                if (lineNumber == 2) {
                    lineData = line.split(",");
                    k1[0] = Double.parseDouble(lineData[5]);
                    k2[0] = Double.parseDouble(lineData[6]);

                }
                if (lineNumber == 3) {
                    lineData = line.split(",");
                    k1[1] = Double.parseDouble(lineData[5]);
                    k2[1] = Double.parseDouble(lineData[6]);
                }
                lineNumber++;
            }
//            System.out.println(Arrays.toString(k1));
//            System.out.println(Arrays.toString(k2));
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            br = new BufferedReader(new FileReader(comtrData));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Fourier f1 =new Fourier();
        MeanValue mv = new MeanValue();
        double rms = 0;
        try {
            while ((line = br.readLine()) != null) {
                lineData = line.split(",");
//                System.out.println(Double.parseDouble(lineData[3])*k1[1]+k2[1]);
                rms = f1.getRMS(Double.parseDouble(lineData[3])*k1[1]+k2[1]);
                ch.setData1(Double.parseDouble(lineData[3])*k1[1]+k2[1]);
                ch.setData2(rms);
//                ch.setData2(f1.getRMS(Double.parseDouble(lineData[3])*k1[1]+k2[1]));
//                ch.setData3(mv.get(Double.parseDouble(lineData[3])*k1[1]+k2[1]));
                r.checkTrip(rms);
//                haara50 = f1.getHaara(128);
            }
        } catch (IOException e) {
            e.printStackTrace();

//        System.out.println(k1);
        }

    }
    public void setRele(Rele r){ this.r = r;}
    public void setChart(Chart ch){
        this.ch = ch;
    }
}
