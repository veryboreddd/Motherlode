package motherlode.movement;

import motherlode.minigame.Motherlode;
import simple.hooks.simplebot.teleporter.Teleporter;
import simple.robot.api.ClientContext;

public class Teleport {
    private static final ClientContext CONTEXT = ClientContext.instance();
    public static final Teleporter TELEPORTER = new Teleporter(CONTEXT);

    public static boolean teleportToMine() {
        if(TELEPORTER.opened()) {
            if(TELEPORTER.teleportStringPath("Minigames", "Motherlode Mine")) {
                if(CONTEXT.sleepCondition(() -> Walk.isAtPoint(Motherlode.MINE_TELEPORT_POINT))) {
                    return true;
                }
            }
        } else {
            if(TELEPORTER.open()) {
                if(TELEPORTER.teleportStringPath("Minigames", "Motherlode Mine")) {
                    if(CONTEXT.sleepCondition(() -> Walk.isAtPoint(Motherlode.MINE_TELEPORT_POINT))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
