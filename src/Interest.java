//This all was written by a beginner, so don't expect quality but it does get's the job done
import java.util.Scanner;
public class Interest{
    private double p,r,t,i;
    private static Scanner m=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("When you're asked for input, the choices have a specified value which are acceptable for Input, so please don't forget to input those values");
        String startingPoint,type,choice;
        GrowthAndDepreciation growthAndDepreciation = new GrowthAndDepreciation();
        Interest methods = new Interest();
        while (true) {
            System.out.println("What do you want to work on Interest(i)/Growth and Depreciation(gd)");
            startingPoint = m.nextLine();
            if (startingPoint.equalsIgnoreCase("i") || startingPoint.equalsIgnoreCase("gd")){
                break;
            }else{
                continue;
            }
        }
        if (startingPoint.equalsIgnoreCase("gd")){
            growthAndDepreciation.Start();
        }else if(startingPoint.equalsIgnoreCase("i")) {
            while (true) {
                System.out.println("CI or SI");
                type = m.nextLine();
                if (type.equalsIgnoreCase("CI") || type.equalsIgnoreCase("SI")) {
                    break;
                } else {
                    continue;
                }
            }
            while (true) {
                System.out.println("What do you want to calculate, Interest(i)/Principle(p)/Rate(r)/Time(t)");
                choice = m.nextLine();
                if (choice.equalsIgnoreCase("i") || choice.equalsIgnoreCase("p") || choice.equalsIgnoreCase("r") || choice.equalsIgnoreCase("t")) {
                    break;
                } else {
                    continue;
                }
            }
            methods.Calculations(type, choice);
            methods.answers(choice);
        }
    }
    public void setP() {
        System.out.println("Enter the Principle");
        this.p = m.nextDouble();
    }
    public void setR() {
        System.out.println("Enter the Rate");
        this.r = m.nextDouble();
    }
    public void setT() {
        System.out.println("Enter the Time");
        this.t = m.nextDouble();
    }
    public void setI() {
        System.out.println("Enter the Interest");
        this.i = m.nextDouble();
    }
    public void Calculations(String type, String choice){
        switch (choice){
            case "i":
                setP();
                setR();
                setT();
                break;
            case "p":
                setI();
                setR();
                setT();
                break;
            case "r":
                setI();
                setP();
                setT();
                break;
            case "t":
                setI();
                setP();
                setR();
                break;
            default:
                System.out.println("Something went wrong");
        }
        if (type.equalsIgnoreCase("SI")){
            switch (choice){
                case "i":
                    this.i=(p*r*t/100);
                    break;
                case "p":
                    this.p=(i*100)/(r*t);
                    break;
                case "r":
                    this.r=(i*100)/(p*t);
                    break;
                case "t":
                    this.t =(i*100)/(p*r);
                    break;
            }
        }else if(type.equalsIgnoreCase("CI")){
            switch (choice){
                case "i":
                    this.i=p*Math.pow((1+(r/100)),t)-p;
                    break;
                case "p":
                    this.p=i/Math.pow((1+(r/100)),2);
                    break;
                case "r":
                    double x = this.i,y=this.p;
                    while (x%2==0 && y%2==0){
                        x/=2;
                        y/=2;
                    }
                    this.r=(Math.pow(x/y,1/t)*100)-100;
                    break;
                case "t":
                    this.t=(Math.log(i/p))/Math.log(1+(r*0.01));
                    break;
            }
        }else {
            System.out.println("Something went wrong");
        }
    }
    public void answers(String choice){
        switch (choice){
            case "i":
                System.out.println("The Interest is "+Math.floor(i));
                break;
            case "p":
                System.out.println("The Principle is "+Math.floor(p));
                break;
            case "r":
                System.out.println("The Rate is "+Math.floor(r)+"%");
                break;
            case "t":
                System.out.println("The Time is "+Math.floor(t));
                break;
        }
    }
}