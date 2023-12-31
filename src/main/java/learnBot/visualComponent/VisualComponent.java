package learnBot.visualComponent;

import engine.GameObject;
import engine.Updatable;
import engine.util.Interpolator;
import learnBot.Config;
import learnBot.FOPAnimation;
import learnBot.World;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.Function;

public abstract class VisualComponent extends GameObject implements Updatable
{
    private double xOffset;
    private double yOffset;
    public VisualComponent(int x, int y, double xOffset, double yOffset)
    {
        super(0,0);
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        setX(getOffsetX(x));
        setY(getOffsetY(y));
    }
    public VisualComponent(int x, int y, double offset)
    {
        super(0,0);
        this.xOffset = offset;
        this.yOffset = offset;
        setX(getOffsetX(x));
        setY(getOffsetY(y));
    }
    protected double getOffsetX(double x)
    {
        return x + Config.BORDER_SIZE_FACTOR * x + xOffset;
    }
    protected double getOffsetY(double y)
    {
        return World.getHeight() - 1 - y + Config.BORDER_SIZE_FACTOR * (World.getHeight() - 1 - y) + yOffset;
    }
    protected int animationsInQueue()
    {
        return animations.size();
    }
    ConcurrentLinkedDeque<FOPAnimation> animations = new ConcurrentLinkedDeque<>();
    protected void playAnimation(FOPAnimation animation)
    {
        animations.add(animation);
    }
    public void update()
    {
        animations.removeIf(FOPAnimation::update);
    }
    protected Interpolator getCustomInterpolator(final double speed)
    {
        double res = Math.max(0, Math.min(World.speedLimit, speed));
        double blendFactor = Math.exp(-0.2 * res);

        return (t) ->
        {
            double easeInOut = 3 * t * t - 2 * t * t * t;

            return t + blendFactor * (easeInOut - t);
        };
    }
}
