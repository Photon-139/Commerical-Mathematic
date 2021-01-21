//This all was written by a beginner, so don't expect quality but it does get's the job done

import java.util.Scanner;

public class Interest {
    private double principle, rate, time, interest;
    private static Scanner m = new Scanner(System.in);

    public static void start() {
        String type, choice;
        Interest methods = new Interest();
        do {
            System.out.println("CI or SI");
            type = m.nextLine();
        } while (!type.equalsIgnoreCase("CI") && !type.equalsIgnoreCase("SI"));
        do {
            System.out.println("What do you want to calculate, Interest(i)/Principle(p)/Rate(r)/Time(t)");
            choice = m.nextLine();
        } while (!choice.equalsIgnoreCase("i") && !choice.equalsIgnoreCase("p") && !choice.equalsIgnoreCase("r") && !choice.equalsIgnoreCase("t"));
        //To the poor soul that is seeing the above written code, I don't have enough brain cells
        methods.values(choice);
        methods.Calculations(type, choice);
        methods.answers(choice);
    }

    public void setPrinciple() {
        System.out.println("Enter the Principle");
        this.principle = m.nextDouble();
    }

    public void setRate() {
        System.out.println("Enter the Rate");
        this.rate = m.nextDouble();
    }

    public void setTime() {
        System.out.println("Enter the Time");
        this.time = m.nextDouble();
    }

    public void setInterest() {
        System.out.println("Enter the Interest");
        this.interest = m.nextDouble();
    }

    public void values(String choice) {
        switch (choice) {
            case "i":
                setPrinciple();
                setRate();
                setTime();
                break;
            case "p":
                setInterest();
                setRate();
                setTime();
                break;
            case "r":
                setInterest();
                setPrinciple();
                setTime();
                break;
            case "t":
                setInterest();
                setPrinciple();
                setRate();
                break;
            default:
                System.out.println("Something went wrong");
        }
    }

    public void Calculations(String type, String choice) {
        if (type.equalsIgnoreCase("SI")) {
            switch (choice) {
                case "i":
                    this.interest = (principle * rate * time / 100);
                    break;
                case "p":
                    this.principle = (interest * 100) / (rate * time);
                    break;
                case "r":
                    this.rate = (interest * 100) / (principle * time);
                    break;
                case "t":
                    this.time = (interest * 100) / (principle * rate);
                    break;
            }
        } else if (type.equalsIgnoreCase("CI")) {
            switch (choice) {
                case "i":
                    this.interest = principle * Math.pow((1 + (rate / 100)), time) - principle;
                    break;
                case "p":
                    this.principle = interest / Math.pow((1 + (rate / 100)), 2);
                    break;
                case "r":
                    double x = this.interest, y = this.principle;
                    while (x % 2 == 0 && y % 2 == 0) {
                        x /= 2;
                        y /= 2;
                    }
                    this.rate = (Math.pow(x / y, 1 / time) * 100) - 100;
                    break;
                case "t":
                    this.time = (Math.log(interest / principle)) / Math.log(1 + (rate * 0.01));
                    break;
            }
        } else {
            System.out.println("Something went wrong");
        }
    }

    public void answers(String choice) {
        switch (choice) {
            case "i":
                System.out.println("The Interest is " + Math.floor(interest));
                break;
            case "p":
                System.out.println("The Principle is " + Math.floor(principle));
                break;
            case "r":
                System.out.println("The Rate is " + Math.floor(rate) + "%");
                break;
            case "t":
                System.out.println("The Time is " + Math.floor(time));
                break;
        }
    }
}