package features;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import models.deck.Rank;
import models.deck.Suit;
import models.point.PointRecord;

public class RecordTypes {

   private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

   public static void main(String[] args) {
      pointRecord();
      cardRecord();
   }

   private static void pointRecord() {
      PointRecord r = new PointRecord(1, 1);
      LOGGER.info(r::toString);
      LOGGER.info(() -> "(x:%d, y:%d)".formatted(
              r.x(), r.y()));
   }

   private static void cardRecord() {
      record Card(Rank rank, Suit suit) {
      }
      List<Card> cards = new ArrayList<>();

      for (Rank rank : Rank.values()) {
         for (Suit suit : Suit.values()) {
            cards.add(new Card(rank, suit));
         }
      }
      LOGGER.info(() -> "Cards: " + cards);
   }
}
