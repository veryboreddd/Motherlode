package motherlode.minigame.objects;

import motherlode.game.Interactable;
import motherlode.minigame.Motherlode;
import motherlode.movement.Walk;
import simple.robot.api.ClientContext;

import java.util.function.BooleanSupplier;

public class Bank {
    public static boolean bank(ClientContext ctx) {
        if(Walk.isNearPoint(Motherlode.MINE_BANK_CHEST_POINT)) {
            if(Interactable.interact(
                    ctx,
                    ctx.objects.populate().filter("Bank chest").nearest().next(),
                    "Use",
                    () -> ctx.bank.bankOpen()
            )) {
                if(deposit(ctx, () -> ctx.inventory.isEmpty() || !ctx.inventory.populate().filter(12011).isEmpty())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean deposit(ClientContext ctx, BooleanSupplier condition) {
        if(ctx.bank.depositInventory()) {
            if(ctx.sleepCondition(condition)) {
                return true;
            }
        }
        return false;
    }
}
