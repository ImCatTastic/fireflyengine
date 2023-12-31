package learnBot;

import java.util.Properties;

public class Config
{
    public static final double UNIT = 75;
    public static final double MARGIN = 1;
    public static final double BORDER_SIZE_FACTOR = 0.075;
    public static final double INNER_FIELD_FACTOR = 0.75;

    private static boolean isInit = false;
    public static void init(Properties properties)
    {
        if(isInit)
            return;

        isInit = true;
        headlessMode = Boolean.parseBoolean(properties.getProperty("headless-mode"));
    }
    private static boolean headlessMode = false;
    public static boolean headlessModeEnabled()
    {
        return headlessMode;
    }
}
