import java.util.Scanner;

public class GrowthAndDepreciation {
    private double PresentValue, Answer, Time, Rate;

    private static Scanner m=new Scanner(System.in);
    public void Start(){
        String choice,valueChoice = "";
        while (true) {
            System.out.println("Growth(g) or Deprecation(d)");
            choice = m.nextLine();
            if (choice.equalsIgnoreCase("g") || choice.equalsIgnoreCase("d")){
                break;
            }else{
                continue;
            }
        }
        if (choice.equalsIgnoreCase("g")){
            Growth();
        }else if (choice.equalsIgnoreCase("d")){
            Depreciation();
        }
    }
    public void Growth(){
        String valueChoice;
        while (true) {
            System.out.println("What do you want to calculate Value after n years(va)/Value n years ago(vb)");
            valueChoice = m.nextLine();
            if (valueChoice.equalsIgnoreCase("va") || valueChoice.equalsIgnoreCase("vb")){
                break;
            }else{
                continue;
            }
        }
        set();
        switch (valueChoice){
            case "va":
                this.Answer =this.PresentValue*Math.pow((1+(this.Rate/100)),this.Time);
                break;
            case "vb":
                this.Answer=this.PresentValue/Math.pow((1+(this.Rate/100)),this.Time);
                break;
            default:
                System.out.println("Looks like something went wrong, going back to the start");
                Start();
        }
        result(valueChoice);
    }
    public void Depreciation(){
        String valueChoice;
        while (true) {
            System.out.println("What do you want to calculate Value after n years(va)/Value n years ago(vb)");
            valueChoice = m.nextLine();
            if (valueChoice.equalsIgnoreCase("va") || valueChoice.equalsIgnoreCase("vb")){
                break;
            }else{
                continue;
            }
        }
        set();
        switch (valueChoice){
            case "va":
                this.Answer=this.PresentValue*Math.pow((1-(this.Rate/100)),this.Time);
                break;
            case "vb":
                this.Answer=this.PresentValue/Math.pow((1-(this.Rate/100)),this.Time);
                break;
            default:
                System.out.println("Looks like something went wrong, going back to the start");
                Start();
        }
        result(valueChoice);
    }
    public void result(String choice){
        switch (choice){
            case "va":
                System.out.println("The value after "+this.Time+" years is "+this.Answer);
                break;
            case "vb":
                System.out.println("The value before "+this.Time+" years is "+this.Answer);
                break;
        }
    }
    public void set(){
        System.out.println("Enter the Present Value");
        this.PresentValue=m.nextDouble();
        System.out.println("Enter the rate");
        this.Rate=m.nextDouble();
        System.out.println("Enter the Time");
        this.Time=m.nextDouble();
    }
}
