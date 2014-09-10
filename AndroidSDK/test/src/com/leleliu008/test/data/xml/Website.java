package com.leleliu008.test.data.xml;

public final class Website {
	private boolean status;
	private String rawtext;
	private String focus;
	private String name;
	private String code;
	private String type;
	
	public boolean status() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getRawtext() {
		return rawtext;
	}
	
	public void setRawtext(String rawtext) {
		this.rawtext = rawtext;
	}
	
	public String getFocus() {
		return focus;
	}
	
	public void setFocus(String focus) {
		this.focus = focus;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Website [status=" + status + ", rawtext=" + rawtext
				+ ", focus=" + focus + ", name=" + name + ", code=" + code
				+ ", type=" + type + "]";
	}
}
