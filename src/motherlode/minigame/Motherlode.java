package motherlode.minigame;

import net.runelite.api.coords.WorldPoint;
import simple.robot.utils.WorldArea;

public class Motherlode {
    public static final WorldPoint MINE_TELEPORT_POINT = new WorldPoint(3754, 5662, 0);
    public static final WorldPoint MINE_LOWER_LADDER_POINT = new WorldPoint(3755, 5672, 0);
    public static final WorldPoint MINE_UPPER_LADDER_POINT = new WorldPoint(3755, 5675, 0);
    public static final WorldPoint MINE_DARK_TUNNEL_WEST_POINT = new WorldPoint(3759, 5670, 0);
    public static final WorldPoint MINE_DARK_TUNNEL_EAST_POINT = new WorldPoint(3765, 5671, 0);
    public static final WorldPoint MINE_BANK_CHEST_POINT = new WorldPoint(3760, 5666, 0);
    public static final WorldPoint MINE_HOPPER_POINT = new WorldPoint(3749, 5672, 0);
    public static final WorldPoint MINE_SACK_POINT = new WorldPoint(3749, 5659, 0);
    public static final WorldPoint MINE_SACK_OBJECT_POINT = new WorldPoint(3748, 5659, 0);

    public static final WorldArea MINE_EAST_TUNNEL_AREA = new WorldArea(
            new WorldPoint(3773, 5687, 0),
            new WorldPoint(3773, 5666, 0),
            new WorldPoint(3766, 5666, 0),
            new WorldPoint(3765, 5667, 0),
            new WorldPoint(3765, 5668, 0),
            new WorldPoint(3765, 5669, 0),
            new WorldPoint(3765, 5670, 0),
            new WorldPoint(3764, 5671, 0),
            new WorldPoint(3764, 5672, 0),
            new WorldPoint(3765, 5673, 0),
            new WorldPoint(3766, 5674, 0),
            new WorldPoint(3767, 5675, 0),
            new WorldPoint(3767, 5676, 0),
            new WorldPoint(3767, 5677, 0),
            new WorldPoint(3767, 5678, 0),
            new WorldPoint(3766, 5679, 0),
            new WorldPoint(3765, 5680, 0),
            new WorldPoint(3765, 5681, 0),
            new WorldPoint(3765, 5682, 0),
            new WorldPoint(3765, 5683, 0),
            new WorldPoint(3764, 5684, 0),
            new WorldPoint(3763, 5685, 0),
            new WorldPoint(3764, 5685, 0),
            new WorldPoint(3764, 5687, 0)
    );

    public static final WorldArea MINE_MAIN_AREA = new WorldArea(
            new WorldPoint(3743, 5656, 0),
            new WorldPoint(3759, 5656, 0),
            new WorldPoint(3759, 5657, 0),
            new WorldPoint(3760, 5658, 0),
            new WorldPoint(3760, 5659, 0),
            new WorldPoint(3760, 5660, 0),
            new WorldPoint(3760, 5661, 0),
            new WorldPoint(3760, 5662, 0),
            new WorldPoint(3760, 5663, 0),
            new WorldPoint(3760, 5664, 0),
            new WorldPoint(3761, 5665, 0),
            new WorldPoint(3761, 5666, 0),
            new WorldPoint(3761, 5667, 0),
            new WorldPoint(3760, 5668, 0),
            new WorldPoint(3760, 5669, 0),
            new WorldPoint(3760, 5670, 0),
            new WorldPoint(3759, 5671, 0),
            new WorldPoint(3757, 5672, 0),
            new WorldPoint(3758, 5672, 0),
            new WorldPoint(3755, 5673, 0),
            new WorldPoint(3756, 5673, 0),
            new WorldPoint(3754, 5674, 0),
            new WorldPoint(3752, 5675, 0),
            new WorldPoint(3753, 5675, 0),
            new WorldPoint(3743, 5675, 0)

    );

    public static final WorldPoint[] ORE_VEIN_EAST_TUNNEL_POINT = {
            new WorldPoint(3765, 5667, 0),
            new WorldPoint(3765, 5668, 0),
            new WorldPoint(3771, 5667, 0),
            new WorldPoint(3764, 5672, 0),
            new WorldPoint(3769, 5671, 0),
            new WorldPoint(3769, 5672, 0),
            new WorldPoint(3767, 5676, 0),
            new WorldPoint(3767, 5677, 0),
            new WorldPoint(3773, 5676, 0),
            new WorldPoint(3773, 5677, 0),
            new WorldPoint(3765, 5680, 0),
            new WorldPoint(3765, 5681, 0),
            new WorldPoint(3765, 5682, 0),
            new WorldPoint(3770, 5682, 0),
            new WorldPoint(3770, 5685, 0),
            new WorldPoint(3770, 5686, 0),

            new WorldPoint(3773, 5664, 0),
            new WorldPoint(3771, 5661, 0),
            new WorldPoint(3771, 5660, 0),
            new WorldPoint(3764, 5660, 0),
            new WorldPoint(3767, 5657, 0),
            new WorldPoint(3773, 5656, 0),

    };

    public static final WorldPoint[] ORE_VEIN_UPPER_POINT = {
            new WorldPoint(3756, 5678, 0),
            new WorldPoint(3756, 5679, 0),
            new WorldPoint(3758, 5680, 0),
            new WorldPoint(3758, 5681, 0),
            new WorldPoint(3755, 5681, 0),
            new WorldPoint(3755, 5682, 0),
            new WorldPoint(3755, 5683, 0),
            new WorldPoint(3756, 5684, 0),
            new WorldPoint(3757, 5684, 0),
            new WorldPoint(3760, 5680, 0),
            new WorldPoint(3761, 5680, 0),
            new WorldPoint(3762, 5680, 0),
            new WorldPoint(3761, 5675, 0),
            new WorldPoint(3762, 5675, 0),
    };

    public static boolean upper_area_unlocked = true;
    public static boolean use_dark_tunnel_shortcut = false;
    public static boolean need_bank = false;

}
