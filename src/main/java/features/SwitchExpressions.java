package features;

import java.util.logging.Logger;

import models.deck.Rank;

public class SwitchExpressions {

   private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

   public static void main(String[] args) {
      // switch statement
      LOGGER.info("Deuce: " + getPriorityOf1(Rank.DEUCE));
      LOGGER.info("Ace: " + getPriorityOf1(Rank.ACE));

      // switch expression
      LOGGER.info("Deuce: " + getPriorityOf2(Rank.DEUCE));
      LOGGER.info("Ace: " + getPriorityOf2(Rank.ACE));
   }

   // switch statement
   private static int getPriorityOf1(Rank rank) {
      switch (rank) {
         case DEUCE, TREY, FOUR, FIVE:
            /* falls through */
            LOGGER.info("Hello there");
         case SIX:
            return -1;
         case SEVEN, EIGHT, NINE:
            int temp = doSomething(rank); // block scope
            LOGGER.info(() -> "Some message: %d".formatted(temp));
            return temp;
         case TEN, JACK, QUEEN:
            // int temp = 3; // compilation error - variable already defined
         case KING, ACE:
            return 1;
         default: // required...?
            throw new IllegalStateException("Unexpected value: " + rank);
      }
   }

   private static int doSomething(Rank rank) {
      return 0;
   }

   // switch expression
   private static int getPriorityOf2(Rank rank) {
      return switch (rank) {
         case DEUCE, TREY, FOUR, FIVE -> {
            LOGGER.info("Hello there");
            yield -1;
         }
         case SIX -> -1;
         case SEVEN, EIGHT, NINE -> {
            int temp = doSomething(rank);
            LOGGER.info(() -> "Some message: %d".formatted(temp));
            yield temp;
         }
         case TEN, JACK, QUEEN -> {
            int temp = 3; // scoped as expected
            LOGGER.info(() -> "Some message: %d".formatted(temp));
            yield 1;
         }
         case KING, ACE -> 1;
      };
   }

}
