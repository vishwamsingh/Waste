package org.mywaste;



public class WasteTypeFactory {
	
	public static WasteType getWasteTypeList(String type, String photoRequired){
		return new WasteType(type,photoRequired);
	}

}
