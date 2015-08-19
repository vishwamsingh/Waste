package org.mywaste;

import java.util.ArrayList;
import java.util.List;

public class WasteTypeListFactory {
	private static List<WasteType> wasteTypeList=new ArrayList<WasteType>();
	
	public static List<WasteType> getWasteTypeList(){
		
		return wasteTypeList;
	}
	
	public static void printList(){
		System.out.println("-----------Inside factory----------: "+wasteTypeList.size());
	}

}
