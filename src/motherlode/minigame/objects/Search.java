package motherlode.minigame.objects;

import simple.robot.api.ClientContext;

public class Search {
    public static boolean searching() {
        if(ClientContext.instance().players.getLocal().getAnimation() == 832) {
            return true;
        }
        return false;
    }
}
