package IntersectionRedone;

import java.util.*;

public class UserInputSimple {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        Calculations calc = new Calculations();

        System.out.println("Please enter the speed limit in m/s: ");
        calc.setTheSpeedLimit(keyboard.nextDouble());

        System.out.println("Please enter the reaction time in s: ");
        calc.setUserReactionTime(keyboard.nextDouble());

        System.out.println("Please enter the speeding acceleration for your car: ");
        calc.setAccelToSpeed(keyboard.nextDouble());

        System.out.println("Please enter the braking acceleration for your car: ");
        calc.setAccelToBrake(keyboard.nextDouble());

        System.out.println("Please enter the car length: ");
        calc.setAvgLengthCar(keyboard.nextDouble());

        System.out.println("Please set the gap between each car: ");
        calc.setGapBetweenCars(keyboard.nextDouble());

        System.out.println("Please set the number of cars: ");
        calc.setNumberCarsWhileStopped(keyboard.nextInt());

        System.out.println("Please set the length of the intersection: ");
        calc.setLengthIntersec(keyboard.nextDouble());

        System.out.println(calc.calculateGreen());
        System.out.println(calc.calculateYellow());
        System.out.println(calc.calculateRed());

    }
}
