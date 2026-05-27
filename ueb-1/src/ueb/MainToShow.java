package ueb;
/**
 * To show during presentation.
 * 
 * @author klk
 */
public class MainToShow {
    /**
     * The number of base 10 digits of a certain number.
     * 
     * @param n The number in question.
     * @return The number of base 10 digits.
     */
    public static int getDigitCount(int n) {
        if (n < 0) {
            n *= -1;
        }

        // Skip single digits, every number has at least a single digit
        int count = 1;
        while (n >= 10) {
            n /= 10;
            count++;
        }

        return (count);
    }
    
    /**
     * The width of a string that could represent the given number.
     * 
     * @param n The number for which the width is required.
     * @return The string width of the number.
     */
    public static int getDisplayLength(int n) {
        int signLength = n < 0 ? 1 : 0;
        return (signLength + getDigitCount(n));
    }
    
    @SuppressWarnings("ManualMinMaxCalculation")
    public static void main(String[] args) {
        final int start = 1;
        final int end   = 10;
        
        final int outputLength = getDisplayLength(start) > getDisplayLength(end)
                ? getDisplayLength(start)
                : getDisplayLength(end) ;
        
        System.out.printf("Testing numbers from %d to %d\n", start, end);
        
        for (int i = start; i <= end; i++) {
            
                System.out.printf("%" + outputLength + "d \n", i);
              
        }
    }
}
