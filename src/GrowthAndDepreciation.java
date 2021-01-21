import java.util.Scanner;

public class GrowthAndDepreciation {
    private double PresentValue, Answer, Time, Rate;

    private static Scanner m = new Scanner(System.in);

    public void Start() {
        String choice;

        do {
            System.out.println("Growth(g) or Deprecation(d)");
            choice = m.nextLine();
        } while (!choice.equalsIgnoreCase("g") && !choice.equalsIgnoreCase("d"));

        if (choice.equalsIgnoreCase("g")) {
            Growth();
        } else if (choice.equalsIgnoreCase("d")) {
            Depreciation();
        }
    }

    public void Growth() {
        String valueChoice;

        do {
            System.out.println("What do you want to calculate Value after n years(va)/Value n years ago(vb)");
            valueChoice = m.nextLine();
        } while (!valueChoice.equalsIgnoreCase("va") && !valueChoice.equalsIgnoreCase("vb"));
        setValues();

        switch (valueChoice) {
            case "va":
                this.Answer = this.PresentValue * Math.pow((1 + (this.Rate / 100)), this.Time);
                break;
            case "vb":
                this.Answer = this.PresentValue / Math.pow((1 + (this.Rate / 100)), this.Time);
                break;
            default:
                System.out.println("Looks like something went wrong, going back to the start");
                Start();
        }
        result(valueChoice);
    }

    public void Depreciation() {
        String valueChoice;
        do {
            System.out.println("What do you want to calculate Value after n years(va)/Value n years ago(vb)");
            valueChoice = m.nextLine();
        } while (!valueChoice.equalsIgnoreCase("va") && !valueChoice.equalsIgnoreCase("vb"));
        setValues();

        switch (valueChoice) {
            case "va":
                this.Answer = this.PresentValue * Math.pow((1 - (this.Rate / 100)), this.Time);
                break;
            case "vb":
                this.Answer = this.PresentValue / Math.pow((1 - (this.Rate / 100)), this.Time);
                break;
            default:
                System.out.println("Looks like something went wrong, going back to the start");
                Start();
        }
        result(valueChoice);
    }

    public void result(String choice) {
        switch (choice) {
            case "va":
                System.out.println("The value after " + this.Time + " years is " + this.Answer);
                break;
            case "vb":
                System.out.println("The value before " + this.Time + " years is " + this.Answer);
                break;
        }
    }

    public void setValues() {
        System.out.println("Enter the Present Value");
        this.PresentValue = m.nextDouble();
        System.out.println("Enter the rate");
        this.Rate = m.nextDouble();
        System.out.println("Enter the Time");
        this.Time = m.nextDouble();
    }
}
