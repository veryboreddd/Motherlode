package motherlode.tasks;

import motherlode.game.Interactable;
import motherlode.minigame.Motherlode;
import motherlode.movement.Walk;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;

public class TraverseTunnel extends Task {

    public TraverseTunnel(ClientContext a) {
        super(a);
    }

    @Override
    public boolean condition() {
        if(!Motherlode.upper_area_unlocked && Motherlode.use_dark_tunnel_shortcut && Walk.isInArea(Motherlode.MINE_MAIN_AREA)) {
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        if(Walk.isNearPoint(Motherlode.MINE_DARK_TUNNEL_WEST_POINT)) {
            if(Interactable.interact(
                    ctx,
                    ctx.objects.populate().filter("Dark tunnel").nearest().next(),
                    "Enter",
                    () -> Walk.isAtPoint(Motherlode.MINE_DARK_TUNNEL_EAST_POINT))) {
                return;
            }
        } else {
            if(Walk.walkNearPoint(Motherlode.MINE_DARK_TUNNEL_WEST_POINT)) {
                return;
            }
        }
    }

    @Override
    public String status() {
        return "Going to tunnel...";
    }
}
