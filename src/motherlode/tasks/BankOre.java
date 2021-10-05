package motherlode.tasks;

import motherlode.minigame.Motherlode;
import motherlode.minigame.objects.Bank;
import motherlode.movement.Walk;
import simple.hooks.scripts.task.Task;
import simple.robot.api.ClientContext;

public class BankOre extends Task {
    public BankOre(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
        if(Motherlode.need_bank) {
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        if(Bank.bank(ctx)) {
            Motherlode.need_bank = false;
        } else {
            if(Walk.walkNearPoint(Motherlode.MINE_BANK_CHEST_POINT)) {
                run();
            }
        }
    }

    @Override
    public String status() {
        return "Banking...";
    }
}
