package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Tent extends Entity{
	
	GamePanel gp;
	public static final String objName = "Tent";

	public OBJ_Tent(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_consumable;
		name = objName;
		down1 = setup("/objects/tent",gp.tileSize,gp.tileSize);
		description = "[" + name + "]\nUseful for sleeping\nalmost everywhere.\n(ONLY 1 USE)";
		price = 300;
		stackable = true;
	}
	public boolean use(Entity entity) {
		
		if(gp.eManager.lighting.dayState == gp.eManager.lighting.day) {
			gp.gameState = gp.dialogueState;
			gp.ui.currentDialogue = "Are you going to sleep now?!\nIt is a beautiful day out there!";
			return false;
		}
		else if(gp.eManager.lighting.dayState == gp.eManager.lighting.dawn) {
			gp.gameState = gp.dialogueState;
			gp.ui.currentDialogue = "Are you going to sleep now?!\nThe sun is already coming up!";
			return false;
		}
		else {
			gp.gameState = gp.sleepState;
			gp.playSE(14);
			gp.player.life = gp.player.maxLife;
			gp.player.mana = gp.player.maxMana;
			gp.player.getSleepingImage(down1);
			return true;
		}
	}

}
