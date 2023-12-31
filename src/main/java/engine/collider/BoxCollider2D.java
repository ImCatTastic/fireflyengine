package engine.collider;

import engine.util.ShapeBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import engine.BoundingBox2D;

import static engine.Engine.displayCollider;

public class BoxCollider2D extends Collider2D
{
    private BoundingBox2D boundingBox;

    public BoxCollider2D(double x1, double y1, double x2, double y2)
    {
        super(ShapeBuilder.createRectangle(x2 - x1, y2 - y1));
        boundingBox = new BoundingBox2D(x1, y1, x2, y2);

        Rectangle rectangle = (Rectangle) getShape();
        rectangle.setStroke(Color.GREEN);
        rectangle.setFill(null);

        rectangle.setVisible(displayCollider);
    }

    public BoundingBox2D getBoundingBox()
    {
        return new BoundingBox2D(
            getX() + boundingBox.x1,
            getY() + boundingBox.y1,
            getX() + boundingBox.x2,
            getY() + boundingBox.y2
        );
    }
}
