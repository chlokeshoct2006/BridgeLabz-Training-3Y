import java.util.Scanner;

public class EmployeeBonuses {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] salaries = new double[10];
        double[] years = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];

        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            double sal = input.nextDouble();
            System.out.print("Enter years of service for employee " + (i + 1) + ": ");
            double yrs = input.nextDouble();

            if (sal < 0 || yrs < 0) {
                System.out.println("Invalid input. Please enter again.");
                i--;
                continue;
            }

            salaries[i] = sal;
            years[i] = yrs;
        }

        for (int i = 0; i < 10; i++) {
            double bonusRate = (years[i] > 5) ? 0.05 : 0.02;
            double bonus = salaries[i] * bonusRate;
            double newSalary = salaries[i] + bonus;

            bonuses[i] = bonus;
            newSalaries[i] = newSalary;

            totalOldSalary += salaries[i];
            totalBonus += bonus;
            totalNewSalary += newSalary;
        }

        System.out.println("\nTotal old salary: " + totalOldSalary);
        System.out.println("Total bonus payout: " + totalBonus);
        System.out.println("Total new salary: " + totalNewSalary);
    }
}
