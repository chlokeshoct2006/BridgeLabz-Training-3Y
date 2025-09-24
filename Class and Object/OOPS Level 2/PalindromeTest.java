class PalindromeChecker {
    String text;

    
    PalindromeChecker(String text) {
        this.text = text;
    }

   
    boolean isPalindrome() {
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); 
        String reversed = new StringBuilder(clean).reverse().toString();
        return clean.equals(reversed);
    }

    
    void displayResult() {
        if (isPalindrome()) {
            System.out.println("\"" + text + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + text + "\" is NOT a Palindrome.");
        }
    }
}

public class PalindromeTest {
    public static void main(String[] args) {
      
        PalindromeChecker p1 = new PalindromeChecker("madam");
        PalindromeChecker p2 = new PalindromeChecker("hello");
        PalindromeChecker p3 = new PalindromeChecker("A man a plan a canal Panama");

        p1.displayResult();
        p2.displayResult();
        p3.displayResult();
    }
}
