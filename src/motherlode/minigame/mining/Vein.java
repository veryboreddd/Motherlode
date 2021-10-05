package motherlode.minigame.mining;

import motherlode.minigame.Motherlode;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;

public class Vein {
    private static final ClientContext CONTEXT = ClientContext.instance();

    public static SimpleObject nearestVeinLower() {
        return CONTEXT.objects.populate()
                .filter("Ore vein")
                .filter(object -> Perspective.getTileHeight(CONTEXT.getClient(), LocalPoint.fromWorld(CONTEXT.getClient(), object.getLocation()), 0) > -500)
                .nearest().next();
    }

    public static SimpleObject nearestVeinUpper() {
        return CONTEXT.objects.populate()
                .filter("Ore vein")
                .filter(object -> Perspective.getTileHeight(CONTEXT.getClient(), LocalPoint.fromWorld(CONTEXT.getClient(), object.getLocation()), 0) < -550)
                .nearest().next();
    }
}
