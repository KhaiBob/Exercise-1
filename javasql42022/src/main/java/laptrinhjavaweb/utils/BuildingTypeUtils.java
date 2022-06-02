package laptrinhjavaweb.utils;

import java.util.HashMap;
import java.util.Map;

import laptrinhjavaweb.constant.SystemConstant;

public class BuildingTypeUtils {
	public static Map <String,String> getBuildingType() {
	 Map <String,String> getBuildingType = new HashMap<String, String>(); 
		getBuildingType.put(SystemConstant.TANG_TRET_CODE, SystemConstant.TANG_TRET);
		getBuildingType.put(SystemConstant.NGUYEN_CAN_CODE, SystemConstant.NGUYEN_CAN);
		getBuildingType.put(SystemConstant.NOI_THAT_CODE, SystemConstant.NOI_THAT);
		return getBuildingType;
	}

	public static String get(String code) {
		
		return code;
	}
          
}