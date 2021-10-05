package motherlode.tasks;

import motherlode.game.Interactable;
import motherlode.minigame.Motherlode;
import motherlode.minigame.mining.Mine;
import motherlode.minigame.mining.Vein;
import motherlode.movement.Walk;
import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;

public class Gather extends Task {

    public Gather(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
        if(!Motherlode.upper_area_unlocked && !Mine.isMining()) {
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        SimpleObject ore_vein = Vein.nearestVeinLower();

        if(ore_vein != null) {
            WorldPoint ore_vein_point = ore_vein.getLocation();
            if(Walk.isNearPoint(ore_vein_point)) {
                if(Interactable.interact(ctx, ore_vein, "Mine", () -> Mine.isMining())) {
                    return;
                }
            } else {
                if(Walk.walkNearPoint(ore_vein_point)) {
                    return;
                }
            }
        }
    }

    @Override
    public String status() {
        return "Gathering pay dirt...";
    }
}
