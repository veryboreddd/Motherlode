package motherlode.movement;

import net.runelite.api.coords.WorldPoint;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Walk {
    private static final ClientContext CONTEXT = ClientContext.instance();
    private static final int MIN_POINT_DISTANCE = 2;

    public static boolean isNearPoint(WorldPoint point) {
        return point.distanceTo2D(CONTEXT.players.getLocal().getLocation()) < MIN_POINT_DISTANCE;
    }

    public static boolean isAtPoint(WorldPoint point) {
        return point.equals(CONTEXT.players.getLocal().getLocation());
    }

    public static boolean isInArea(WorldArea area) {
        return CONTEXT.players.getLocal().within(area);
    }

    public static List<WorldPoint> getPath(WorldPoint point) {
        return Arrays.stream(CONTEXT.pathing.createLocalPath(point)).collect(Collectors.toList());
    }

    public static boolean walkNearPoint(WorldPoint point) {
        if(CONTEXT.pathing.step(point)) {
            if(CONTEXT.sleepCondition(() -> isNearPoint(point))) {
                return true;
            }
        }
        return false;
    }
}
