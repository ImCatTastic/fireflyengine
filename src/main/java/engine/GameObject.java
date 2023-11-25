package engine;


import javafx.application.Platform;
import javafx.scene.Group;
import engine.collider.Collider2D;
import engine.mathUtil.Vec2;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.css.Rect;


import java.util.ArrayList;


public class GameObject
{
    public final int zIndex;
    private final Vec2 position;
    public double rotation;
    private Collider2D collider;
    private GameObject parent;
    private final Group rootNode = new Group();
    private final ArrayList<GameObject> children = new ArrayList<>();

    protected void setParent(GameObject parent)
    {
        if (this.parent != null)
            removeFromParent();

        this.parent = parent;
    }
    protected void removeFromParent()
    {
        this.parent.removeChild(this);
    }

    protected void removeChild(GameObject object)
    {
        children.remove(object);
    }

    public GameObject addChild(@NotNull GameObject gameObject)
    {
        gameObject.setParent(this);
        return gameObject;
    }

    public void addCollider(Collider2D collider2D)
    {
        if(collider != null)
            return;

        this.collider = collider2D;
        collider.updatePosition(position);
        Platform.runLater(() -> rootNode.getChildren().add(collider2D.getNode()));
    }

    public GameObject(double x, double y, double rotation)
    {
        position = new Vec2(x, y);
        zIndex = 0;
        this.rotation = rotation;

        Renderer.getInstance().registerGameObject(this, rootNode);
    }

    private void addShape(Shape shape)
    {
        Platform.runLater(() -> rootNode.getChildren().add(shape));
    }

    protected Rectangle addRectangle(double x, double y, double width, double height)
    {
        Rectangle rectangle = Renderer.getInstance().createRectangle(x, y, width, height);
        addShape(rectangle);
        return rectangle;
    }

    protected Rectangle addRectangle(double x, double y)
    {
        return addRectangle(x, y, 1, 1);
    }

    public Vec2 getWorldCoords()
    {
        double x = position.x;
        double y = position.y;

        if(parent != null)
        {
            Vec2 pos = parent.getWorldCoords();
            x += pos.x;
            y += pos.y;
        }

        return new Vec2(x,y);
    }

    public double getRotation() {
        return rotation;
    }

    public double getWorldX()
    {
        return getWorldCoords().x;
    }

    public double getWorldY()
    {
        return getWorldCoords().y;
    }


    private void updatePosition()
    {
        if(hasCollider())
        {
            collider.updatePosition(position);
        }
    }


    public void incRotation(double value)
    {
        rotation += value;
    }

    public void setRotation(double rotation)
    {
        this.rotation = rotation;
    }

    public void setX(double x)
    {
        position.x = x;
        updatePosition();
    }

    public void incX(double value)
    {
        position.x += value;
        updatePosition();
    }

    public void incY(double value)
    {
        position.y += value;
        updatePosition();
    }

    public void setPosition(Vec2 position)
    {
        setPosition(position.x, position.y);
    }

    public void setPosition(double x, double y)
    {
        this.position.x = x;
        this.position.y = y;
        updatePosition();
    }

    public Collider2D getCollider() {
        return collider;
    }

    public boolean hasCollider()
    {
        return collider != null;
    }

    public int getZIndex()
    {
        return zIndex;
    }
}
