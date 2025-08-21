public class NumberChecker {

    // Count digits
    public static int countDigits(int num) {
        return String.valueOf(num).length();
    }

    // Store digits in array
    public static int[] getDigits(int num) {
        String s = String.valueOf(num);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        return digits;
    }

    // Duck number (contains zero but not starting with zero)
    public static boolean isDuck(int num) {
        String s = String.valueOf(num);
        return s.indexOf('0') > 0;
    }

    // Armstrong number
    public static boolean isArmstrong(int num) {
        int[] digits = getDigits(num);
        int power = digits.length;
        int sum = 0;
        for (int d : digits) sum += Math.pow(d, power);
        return sum == num;
    }

    // Largest & second largest
    public static void largestTwo(int[] digits) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > first) {
                second = first;
                first = d;
            } else if (d > second && d != first) {
                second = d;
            }
        }
        System.out.println("Largest: " + first + ", Second Largest: " + second);
    }

    // Smallest & second smallest
    public static void smallestTwo(int[] digits) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < first) {
                second = first;
                first = d;
            } else if (d < second && d != first) {
                second = d;
            }
        }
        System.out.println("Smallest: " + first + ", Second Smallest: " + second);
    }
}
