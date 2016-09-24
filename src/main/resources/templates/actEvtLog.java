package com.crawler.tbl;

import java.util.Date;


public class actEvtLogTBL {
		private Integer logNr;
		private String type;
	
		public Integer getLogNr(){
			return logNr;
		}
		public void setLogNr(Integer logNr){
			this.logNr = logNr;
		}
		public String getType(){
			return type;
		}
		public void setType(String type){
			this.type = type;
		}
	
	@Override
	public String toString() {
		return "actEvtLogTbl [
				logNr=" + logNr + ",
							type=" + type +  "]";
	}
	
	

}
