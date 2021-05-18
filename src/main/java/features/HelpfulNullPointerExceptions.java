package features;

import java.util.Locale;

public class HelpfulNullPointerExceptions {

   public static void main(String[] args) {
      String input = null;
      showUpperCase(input); // NullPointerException
   }

   public static String showUpperCase(String str) {
      return str.toUpperCase(Locale.US);
   }
}
