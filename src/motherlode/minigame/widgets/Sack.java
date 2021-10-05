package motherlode.minigame.widgets;

import motherlode.game.Interactable;
import net.runelite.api.widgets.Widget;
import simple.robot.api.ClientContext;

public class Sack {
    private static final ClientContext CONTEXT = ClientContext.instance();

    public static boolean isFull() {
        Widget motherlode_mine_widget = CONTEXT.getClient().getWidget(25034756);

        if(motherlode_mine_widget != null) {
            if(Integer.parseInt(motherlode_mine_widget.getDynamicChildren()[2].getText()) >= 200) {
                return true;
            }
        }
        return false;
    }
}
