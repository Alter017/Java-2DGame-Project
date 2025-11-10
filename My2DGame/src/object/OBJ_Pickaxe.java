package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Pickaxe extends Entity{

	public static final String objName = "Pickaxe";
	
	public OBJ_Pickaxe(GamePanel gp) {
		super(gp);

		type = type_pickaxe;
		name = objName;
		down1 = setup("/objects/pickaxe",gp.tileSize,gp.tileSize);
		knockBackPower = 2;
		attackValue = 1;
		attackArea.width = 30;
		attackArea.height = 30;
		description = "[" + name + "]\nCan break weak walls.\nKnockBack: " + knockBackPower;
		price = 75;
		motion1_duration = 10;
		motion2_duration = 30;
	}

}
