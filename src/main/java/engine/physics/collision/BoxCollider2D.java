package engine.physics.collision;

import engine.util.ShapeBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import engine.geometry.BoundingBox2D;

public class BoxCollider2D extends Collider2D
{
    private BoundingBox2D boundingBox;

    public BoxCollider2D(double x1, double y1, double x2, double y2)
    {
        super(new Rectangle());
        boundingBox = new BoundingBox2D(x1, y1, x2, y2);

        /*
        Rectangle rectangle = (Rectangle) getShape();
        rectangle.setStroke(Color.GREEN);
        rectangle.setFill(null);

        rectangle.setVisible(displayCollider);
         */
    }

    public BoundingBox2D getBoundingBox()
    {
        return new BoundingBox2D(
            getX() + boundingBox.getX1(),
            getY() + boundingBox.getY1(),
            getX() + boundingBox.getY1(),
            getY() + boundingBox.getY2()
        );
    }

    private Rectangle getVisual(double x1, double y1, double x2, double y2)
    {
        //        super(ShapeBuilder.createRectangle(x2 - x1, y2 - y1));
        return null;
    }
}
