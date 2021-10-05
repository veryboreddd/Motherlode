package motherlode.tasks;

import motherlode.game.Interactable;
import motherlode.minigame.Motherlode;
import motherlode.movement.Teleport;
import motherlode.movement.Walk;
import simple.hooks.scripts.task.Task;
import simple.robot.api.ClientContext;

public class Deposit extends Task {
    public Deposit(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
        if(ctx.inventory.inventoryFull()) {
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        if(Walk.isInArea(Motherlode.MINE_MAIN_AREA)) {
            if(Walk.walkNearPoint(Motherlode.MINE_HOPPER_POINT)) {
                if(Interactable.interact(
                        ctx,
                        ctx.objects.populate().filter("Hopper").nearest().next(),
                        "Deposit",
                        () -> ctx.inventory.populate().filter(12011).isEmpty())) {
                    return;
                }
            }
        } else {
            if(Teleport.teleportToMine()) {
                run();
            }
        }
    }

    @Override
    public String status() {
        return "Depositing pay dirt into hopper...";
    }
}
