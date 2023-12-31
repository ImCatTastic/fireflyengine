package engine.collider;

import engine.GameObject;
import javafx.scene.Node;
import javafx.scene.shape.Shape;
import engine.mathUtil.Vec2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Collider2D
{
    private final ArrayList<Class<?>> classFilter = new ArrayList<>();
    private final ArrayList<GameObject> objectFilter = new ArrayList<>();

    public boolean filterContains(GameObject object)
    {
        for (Class<?> aClass : classFilter)
            if(aClass.equals(object.getClass()))
                return true;

        for (Object obj : objectFilter)
            if(obj.equals(object))
                return true;

        return false;
    }


    private final Vec2 position = new Vec2(0,0);
    private final Shape shape;

    public Collider2D(Shape shape)
    {
        this.shape = shape;
    }
    protected void filterClass(Class<?> clazz)
    {
        classFilter.add(clazz);
    }

    protected void filterObject(GameObject object)
    {
        objectFilter.add(object);
    }

    protected double getX()
    {
        return position.x;
    }

    protected double getY()
    {
        return position.y;
    }

    public void updatePosition(Vec2 position)
    {
        this.position.x = position.x;
        this.position.y = position.y;
    }
    protected Shape getShape()
    {
        return shape;
    }
    public Node getNode()
    {
        return shape;
    }
}
