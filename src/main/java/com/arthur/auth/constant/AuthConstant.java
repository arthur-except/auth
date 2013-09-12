package com.arthur.auth.constant;

public class AuthConstant {
	
	public enum ResourceType{
		URL("URL", "url resource"), METHOD("METHOD", "method resource");
		
		private final String type;
		
		private final String desc;
		
		private ResourceType(String type, String desc){
			this.type = type;
			this.desc = desc;
		}

		public String getDesc() {
			return desc;
		}

		public String getType() {
			return type;
		}
		
	}

}
