package motherlode.tasks;

import motherlode.game.Interactable;
import motherlode.minigame.Motherlode;
import motherlode.movement.Walk;
import simple.hooks.scripts.task.Task;
import simple.robot.api.ClientContext;

public class TraverseLadder extends Task {

    public TraverseLadder(ClientContext a) {
        super(a);
    }

    @Override
    public boolean condition() {
        if(Motherlode.upper_area_unlocked && Walk.isInArea(Motherlode.MINE_MAIN_AREA)) {
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        if(Walk.isNearPoint(Motherlode.MINE_LOWER_LADDER_POINT)) {
            if(Interactable.interact(
                    ctx,
                    ctx.objects.populate().filter("Ladder").nearest().next(),
                    "Climb",
                    () -> Walk.isAtPoint(Motherlode.MINE_UPPER_LADDER_POINT))) {
                return;
            } else {
                Motherlode.upper_area_unlocked = false;
            }
        } else {
            if(Walk.walkNearPoint(Motherlode.MINE_LOWER_LADDER_POINT)) {
                return;
            }
        }
    }

    @Override
    public String status() {
        return "Going to ladder...";
    }
}
