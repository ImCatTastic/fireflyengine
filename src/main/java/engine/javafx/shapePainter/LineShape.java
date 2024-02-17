package engine.javafx.shapePainter;

import engine.javafx.Camera;
import engine.javafx.CanvasRenderer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class LineShape extends PaintableShape
{
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    private final Color color;
    private final double thickness;
    public LineShape(double x1, double y1, double x2, double y2, Color color, double thickness)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.thickness = thickness;
    }
    @Override
    public void draw(GraphicsContext gc, CanvasRenderer renderer)
    {
        var unit = Camera.getUnit();
        var scaledX1 = x1 * unit;
        var scaledY1 = y1 * unit;
        var scaledX2 = x2 * unit;
        var scaledY2 = y2 * unit;

        gc.setStroke(color);
        gc.setLineWidth(thickness * unit);
        gc.strokeLine(scaledX1, scaledY1, scaledX2, scaledY2);
    }
}
