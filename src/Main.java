import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner m = new Scanner(System.in);
        System.out.println("Investment(i) or Growth and Depreciation(gd)");
        String choice = m.nextLine();
        if (choice.equalsIgnoreCase("i")) {
            Interest.start();
        } else if (choice.equalsIgnoreCase("gd")) {
            GrowthAndDepreciation gd = new GrowthAndDepreciation();
            gd.Start();
        } else {
            System.out.println("Nothing was chosen");
        }
    }
}
