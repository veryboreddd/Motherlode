package motherlode.game;

import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;

import java.util.function.BooleanSupplier;

public class Interactable {

    public static boolean interact(
            ClientContext ctx,
            SimpleObject object,
            String action,
            BooleanSupplier condition) {
        if(object.click(action)) {
            if(ctx.sleepCondition(condition)) {
                return true;
            }
        }
        return false;
    }

    public static boolean interact(
            ClientContext ctx,
            SimpleObject object,
            int action,
            BooleanSupplier condition) {
        if(object.click(action)) {
            if(ctx.sleepCondition(condition)) {
                return true;
            }
        }
        return false;
    }
}
