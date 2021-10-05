package motherlode;

import motherlode.minigame.Motherlode;
import motherlode.tasks.*;
import net.runelite.api.Skill;
import net.runelite.api.widgets.WidgetInfo;
import simple.hooks.filters.SimpleSkills;
import simple.hooks.scripts.Category;
import simple.hooks.scripts.ScriptManifest;
import simple.hooks.scripts.task.Task;
import simple.hooks.scripts.task.TaskScript;
import simple.hooks.simplebot.ChatMessage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

@ScriptManifest(category = Category.MINIGAMES, name = "Motherlode Mine", description = "Mines and stuff.", discord = "veryboreddd#3812", author = "Fluffyman", servers = {"Zaros"}, version = "1.00")
public class MotherlodeMine extends TaskScript {
    private final Font ARIAL = new Font("Arial", 1, 10);
    private final Color BACKGROUND_COLOR = new Color(99, 67, 8, 90);
    private final Color BORDER_COLOR = new Color(99, 67, 8);
    private final Color TEXT_COLOR = new Color(255, 255, 255);
    private final double scale = 0.18;

    private int start_exp;
    private int CHAT_X, CHAT_Y, CHAT_WIDTH, CHAT_HEIGHT, IMAGE_WIDTH, IMAGE_HEIGHT;

    private BufferedImage image;

    private List motherlode_tasks = new ArrayList();

    @Override
    public List<Task> tasks() {
        return motherlode_tasks;
    }

    @Override
    public boolean prioritizeTasks() {
        return true;
    }

    @Override
    public void onExecute() {
        start_exp = ctx.skills.experience(SimpleSkills.Skills.MINING);

        CHAT_X = ctx.widgets.getWidget(WidgetInfo.CHATBOX).getCanvasLocation().getX();
        CHAT_Y = ctx.widgets.getWidget(WidgetInfo.CHATBOX).getCanvasLocation().getY();
        CHAT_WIDTH = (int)ctx.widgets.getWidget(WidgetInfo.CHATBOX).getClickBounds().getWidth();
        CHAT_HEIGHT = (int)ctx.widgets.getWidget(WidgetInfo.CHATBOX).getClickBounds().getHeight();

        image = ctx.paint.getImage("https://static.wikia.nocookie.net/2007scape/images/7/7b/Prospector_Percy.png");

        if(image != null) {
            IMAGE_WIDTH = (int) (image.getWidth() * scale);
            IMAGE_HEIGHT = (int) (image.getHeight() * scale);
        }

        if(ctx.getClient().getRealSkillLevel(Skill.AGILITY) >= 54) {
            Motherlode.use_dark_tunnel_shortcut = true;
        }

        motherlode_tasks.addAll(Arrays.asList(
                new Deposit(ctx),
                new Retrieve(ctx),
                new BankOre(ctx),
                new TraverseLadder(ctx),
                new GatherUpper(ctx),
                new TraverseTunnel(ctx),
                new Gather(ctx)
        ));
    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onChatMessage(ChatMessage chatMessage) {

    }

    @Override
    public void paint(Graphics graphics) {
        final long exp_gained = ctx.skills.experience(SimpleSkills.Skills.MINING) - start_exp;

        Graphics2D graphics_2d = (Graphics2D) graphics;
        graphics_2d.setFont(ARIAL);
        graphics_2d.setColor(BACKGROUND_COLOR);
        graphics_2d.fillRect(CHAT_X, CHAT_Y, CHAT_WIDTH, CHAT_HEIGHT);
        graphics_2d.setColor(BORDER_COLOR);
        graphics_2d.setStroke(new BasicStroke(2));
        graphics_2d.drawRect(CHAT_X, CHAT_Y, CHAT_WIDTH, CHAT_HEIGHT);
        graphics_2d.setColor(TEXT_COLOR);
        graphics_2d.drawString("Status: " + getScriptStatus(), IMAGE_WIDTH + CHAT_X + 20, CHAT_Y + 20);
        graphics_2d.drawString("Experience Gained: " + exp_gained, IMAGE_WIDTH + CHAT_X + 20, CHAT_Y + 30);
        if(image != null) {
            graphics_2d.drawImage(image, CHAT_X, CHAT_Y, IMAGE_WIDTH, IMAGE_HEIGHT, null);
        }
    }
}
