package KingdomServer.server.actions;

import java.util.HashMap;
import java.util.Map;

public class GameActionFactory {
	
	protected static Map<String, GameAction> actionMap;
	static { 
		actionMap = new HashMap<String, GameAction>();
		actionMap.put(GameActionKeys.permissionKey, new PermissionAction());
		
		//Other maps
	}
	
	public static GameAction getAction(String key, String user) {
		GameAction action = actionMap.get(key);
		if(action == null) {
			System.out.println("Invalid Key, No action mapping found for " + key);
			action = new DoNothing();
		} 
		
		return action;
	}

}