package IntersectionRedone;

/**
 * the purpose of this class is to model a run-of-the-mill intersection with roads in a + pattern
 * @author aparna
 * @version 1.0
 */

public class Calculations {

    /**
     * the following variables represent user input
     */
    private double theSpeedLimit; //the speed limit
    private double userReactionTime; //reaction time
    private double accelToSpeed; //speeding acceleration - this is user input because it's different for each car
    private double accelToBrake; //braking acceleration - this is user input because it's different for each car
    private double avgLengthCar; //average car length
    private double gapBetweenCars; //length of gap between each car
    private int numberCarsWhileStopped; //number of cars at red
    private double lengthIntersec; //length of traffic intersection

    public Calculations(){
        theSpeedLimit = 0.0;
        userReactionTime = 0.0;
        accelToSpeed = 0.0;
        accelToBrake = 0.0;
        avgLengthCar = 0.0;
        gapBetweenCars = 0.0;
        numberCarsWhileStopped = 0;
        lengthIntersec = 0.0;
    }

    public void setTheSpeedLimit(double theVLimit){
        theSpeedLimit = theVLimit;
    }

    public void setUserReactionTime(double theTReaction){
        userReactionTime = theTReaction;
    }

    public void setAccelToSpeed(double Aspeed){
        accelToSpeed = Aspeed;
    }

    public void setAccelToBrake(double ABreak){
        accelToBrake = ABreak;
    }

    public void setAvgLengthCar(double L){
        this.avgLengthCar = L;
    }

    public void setGapBetweenCars(double G){
        this.gapBetweenCars = G;
    }

    public void setNumberCarsWhileStopped(int R){
        this.numberCarsWhileStopped = R;
    }

    public void setLengthIntersec(double T){
        this.lengthIntersec = T;
    }


    /**
     * the following method returns the amount of time for which the traffic light will remain green
     * @return time for which the traffic light will remain green
     */
    public double calculateGreen() {
        double timeToAccelerate = theSpeedLimit / accelToSpeed; //time to accelerate form 0
        double displacementDuringAccel = ((theSpeedLimit * theSpeedLimit) / (2 * accelToSpeed)); //disp traveled during acceleration
        double displacementOfAllCarsInFront= (+gapBetweenCars + +avgLengthCar) * (+numberCarsWhileStopped - 1); //calculate disp gap of all the cars in front
        double reactionTimeDelayForLastCar = +numberCarsWhileStopped * userReactionTime;

        if (displacementDuringAccel > displacementOfAllCarsInFront) {//if car is still accelerating by the intersection
            return Math.sqrt((2 * displacementOfAllCarsInFront)/ accelToSpeed) + reactionTimeDelayForLastCar;
        } else { //car has reached speed limit and is coasting
            return timeToAccelerate + ((displacementOfAllCarsInFront - displacementDuringAccel) / theSpeedLimit) + reactionTimeDelayForLastCar;
        }
    }


    /**
     * the following method returns the amount of time for while the traffic light will remain yellow
     * @return time for which the traffic light will remain yellow
     */
    public double calculateYellow() {
        double yellowVal = ((-(theSpeedLimit * theSpeedLimit)) / (2 * accelToBrake)) + (userReactionTime * theSpeedLimit); //calculates the braking distance
        return (yellowVal / theSpeedLimit);
    }

    /**
     * the following method calculates the amount of time for which the traffic light will remain red on both sides
     * @return time for which the traffic light will remain red on both sides
     */
    public double calculateBuffer(){
        double bufferTime = +lengthIntersec / theSpeedLimit; //buffer time for the last car to make it through
        return bufferTime;
    }

    /**
     * the following method calculates the total time the traffic light will remain red on one side
     * @return time for which the traffic light will remain red on one side
     */

    public double calculateRed() {
        double red = 0.0;
        return calculateGreen() + calculateYellow() + calculateBuffer();
    }



}
