package motherlode.tasks;

import motherlode.game.Interactable;
import motherlode.minigame.Motherlode;
import motherlode.minigame.mining.Mine;
import motherlode.minigame.objects.Search;
import motherlode.minigame.widgets.Sack;
import motherlode.movement.Teleport;
import motherlode.movement.Walk;
import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;

public class Retrieve extends Task {

    public Retrieve(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
        if(Sack.isFull()) {
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        if(Walk.isNearPoint(Motherlode.MINE_SACK_POINT)) {
            if(Interactable.interact(
                    ctx,
                    ctx.objects.populate().filter(Motherlode.MINE_SACK_OBJECT_POINT).nearest().next(),
                    1,
                    () -> Search.searching())) {
                Motherlode.need_bank = true;
            }
        } else {
            if(!Walk.isInArea(Motherlode.MINE_MAIN_AREA)) {
                if(Teleport.teleportToMine()) {
                    if(Walk.walkNearPoint(Motherlode.MINE_SACK_POINT)) {
                        run();
                    }
                }
            } else {
                if(Walk.walkNearPoint(Motherlode.MINE_SACK_POINT)) {
                    run();
                }
            }
        }
    }

    @Override
    public String status() {
        return "Retrieving ore...";
    }
}
