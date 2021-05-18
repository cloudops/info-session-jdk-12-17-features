package features;

import java.util.logging.Logger;

import models.shape.Circle;
import models.shape.Rectangle;
import models.shape.Shape;
import models.shape.Square;
import models.shape.TransparentRectangle;

public class PatternMatching {
   private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

   public static void main(String[] args) {
      patternMatching1(new TransparentRectangle());
      patternMatching1(new Square());

      LOGGER.info("");
      patternMatching2(new TransparentRectangle());
      patternMatching2(new Square());
   }

   private static void patternMatching1(Shape shape) {
      if (shape instanceof Circle) {
         Circle circle = ((Circle) shape);
         action(circle);
      } else if (shape instanceof Rectangle) {
         Rectangle rectangle = ((Rectangle) shape);
         if (rectangle.getArea() > 0) {
            action(rectangle);
         }
      } else {
         LOGGER.info("no match... %s".formatted(shape));
      }
   }

   private static void patternMatching2(Shape shape) {
      if (shape instanceof Circle circle) {
         action(circle);
      } else if (shape instanceof Rectangle rectangle && rectangle.getArea() > 0) {
         action(rectangle);
      } else {
         LOGGER.info("no match... %s".formatted(shape));
      }
   }

   private static void action(Rectangle rectangle) {
      LOGGER.info("do rectangle stuff %s".formatted(rectangle));
   }

   private static void action(Circle circle) {
      LOGGER.info("do circle stuff %s".formatted(circle));
   }
}
