public class MainProgram {
    public static void main(String[] args) {
        // Football team demo
        FootballTeam.main(null);

        // NumberChecker demo
        int num = 153;
        System.out.println("\nNumber: " + num);
        System.out.println("Digits count: " + NumberChecker.countDigits(num));
        int[] digits = NumberChecker.getDigits(num);

        System.out.println("Duck Number: " + NumberChecker.isDuck(num));
        System.out.println("Armstrong Number: " + NumberChecker.isArmstrong(num));

        NumberChecker.largestTwo(digits);
        NumberChecker.smallestTwo(digits);
    }
}
