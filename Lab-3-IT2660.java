public class Main {
  public static void main(String[] args) {
    String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    // Best-case scenario (pattern exists at the start of text)
    String bestCase = "A";

    // * Initialize startTime here for best-case
    long startTime = System.nanoTime();
    int index = match(text, bestCase);
    // * Initialize endTime here for best-case
    long endTime = System.nanoTime();
    // * Calculate elapsedTime here for best-case
    long elapsedTime = endTime - startTime;
    
    if (index >= 0)
      System.out.println("best-case input matched at index " + index);
    else
      System.out.println("best-case input unmatched");
    System.out.println("Elapsed time for best-case: " + elapsedTime + " ns");
    
    // Worst-case scenario (pattern does not exist in text)
    String worstCase = "XYZABC";

    // * Initialize startTime here for worst-case
    startTime = System.nanoTime();
    index = match(text, worstCase);
    // * Initialize endTime here for worst-case
    endTime = System.nanoTime();
    // * Calculate elapsedTime here for worst-case
    elapsedTime = endTime - startTime;
    
    if (index >= 0)
      System.out.println("worst-case input matched at index " + index);
    else
      System.out.println("worst-case input unmatched");
    System.out.println("Elapsed time for worst-case: " + elapsedTime + " ns");
  }

  // Return the index of the first match. -1 otherwise.
  public static int match(String text, String pattern) {
    for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
      if (isMatched(i, text, pattern))
        return i;
    }

    return -1;
  }

  // Test if pattern matches text starting at index i
  private static boolean isMatched(int i, String text, 
      String pattern) {
    for (int k = 0; k < pattern.length(); k++) {
      if (pattern.charAt(k) != text.charAt(i + k)) {
        return false;
      }
    }
    
    return true;
  }
}