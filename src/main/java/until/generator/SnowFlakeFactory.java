package until.generator;

public class SnowFlakeFactory {
	
	private static volatile SnowFlakeID snowFlakeID;
	
	public static SnowFlakeID getSnowFlakeID(){
		
		if(snowFlakeID == null){
			synchronized(SnowFlakeID.class){
				if(snowFlakeID==null){
					snowFlakeID = new SnowFlakeID();
				}
			}
		}
		return snowFlakeID;
	}

}
