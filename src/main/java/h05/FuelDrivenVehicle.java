package h05;

public class FuelDrivenVehicle extends MeansOfTransport implements FuelDriven{

    private FuelType fuelType;
    private int fillingLevel;

    public FuelDrivenVehicle(FuelType fuelType, TransportType transportType, int fillingLevel){
        this.fuelType = fuelType;
        this.transportType = transportType;
        this.fillingLevel = fillingLevel;
    }

    @Override
    public FuelType getFuelType() {
        return fuelType;
    }

    public int getFillingLevel() {
        return fillingLevel;
    }

    public void fillUp(int fillValue){
        if(fillValue > 0){
            fillingLevel += fillValue;
        }
    }

    @Override
    public double getAverageConsumption(double speed) {
        if(speed < 0){
            return 0;
        }else if (speed > 200){
            return 20;
        }else{
            return  0.1 * speed;
        }
    }

    @Override
    public int letMeMove(int distance) {
        int reduceBy;
        if(distance < 0){
            reduceBy = 0;
        }else if(distance < 10 * fillingLevel){
             reduceBy = distance/10;
        }else{
            reduceBy = fillingLevel;
        }
        fillingLevel -= reduceBy;
        return reduceBy/10;
    }
}
