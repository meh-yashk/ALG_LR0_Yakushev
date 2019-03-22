package Main;

public class Rele {
    private double ust = 0.5;
    private boolean trip = false;
    private Chart chart = new Chart();

    public void checkTrip(double signal){
        if(signal>ust) trip = true; else trip = false;
        if(trip) chart.setData1(1); else chart.setData1(0);
    }
}
