package org.mywaste;

public class WasteType {
	private String type;
	private String photoRequired;
	
	public WasteType(String type2, String photoRequired2) {
		this.type=type2;
		this.photoRequired=photoRequired2;
	}
	public void setType(String type){
		this.type=type;
	}
	public void setPhotoRequired(String photoRequired){
		this.photoRequired=photoRequired;
	}
	
	public String getType(){
		return type;
	}
	
	public String getPhotoRequired(){
		return photoRequired;
	}
}
