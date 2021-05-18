package features;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.jupiter.api.Test;

class CompactNumberFormattingTest {

   private static final String SPACE = " ";

   @Test
   void givenNumber_thenCompactValuesEnglish() {
      NumberFormat likesShort = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
      likesShort.setMaximumFractionDigits(2);
      assertEquals("2.59K", likesShort.format(2592));

      NumberFormat likesLong = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
      likesLong.setMaximumFractionDigits(2);
      assertEquals("2.59 thousand", likesLong.format(2592));
   }

   @Test
   void givenNumber_thenCompactValuesFrench() {
      NumberFormat likesShort = NumberFormat.getCompactNumberInstance(Locale.CANADA_FRENCH, NumberFormat.Style.SHORT);
      likesShort.setMaximumFractionDigits(2);

      assertEquals("2,59" + SPACE + "k", likesShort.format(2592));

      NumberFormat likesLong = NumberFormat.getCompactNumberInstance(Locale.CANADA_FRENCH, NumberFormat.Style.LONG);
      likesLong.setMaximumFractionDigits(2);
      assertEquals("2,59 mille", likesLong.format(2592));
   }

}
