package models.shape;

// shapes
public abstract sealed class Shape permits Circle, Rectangle, Square {
   public double getArea() {
      return 0.0;
   }
}
