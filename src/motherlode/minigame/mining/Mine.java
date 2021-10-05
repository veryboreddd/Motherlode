package motherlode.minigame.mining;

import simple.robot.api.ClientContext;

public class Mine {
    private static ClientContext CONTEXT = ClientContext.instance();

    public static boolean isMining() {
        return CONTEXT.players.getLocal().getAnimation() == 6752;
    }
}
