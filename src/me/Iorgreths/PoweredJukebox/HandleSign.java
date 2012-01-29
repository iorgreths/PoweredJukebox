package me.Iorgreths.PoweredJukebox;

import java.util.logging.Level;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;

public class HandleSign {

	private PoweredJukebox pj;
	private Sign s;
	private Material record;
	
	public HandleSign(PoweredJukebox pj){
		this.pj = pj;
	}
	
	public void getSign(Location loc){
		 s = (Sign) loc.getBlock().getState();
		 return;
	}
	
	public boolean checkFirstLine(){
		if(s.getLine(0).toUpperCase().equals("[POWEREDJB]")){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean getRecordFromSign(){
		String rec = s.getLine(1);
		if(rec.toUpperCase().contains("RECORD_")){
			String[] recor = rec.split("_");
			if(recor.length > 1){
				int record;
				try{
					record = Integer.parseInt(recor[1]);
				}catch(Exception ex){
					pj.logger.log(Level.WARNING, "No valid number input at [PoweredJb] sign. Number set to default: 3");
					record = 3;
				}
				switch(record){
				case 3:
					this.record = Material.RECORD_3;
					return true;
				case 4:
					this.record = Material.RECORD_4;
					return true;
				case 5:
					this.record = Material.RECORD_5;
					return true;
				case 6:
					this.record = Material.RECORD_6;
					return true;
				case 7:
					this.record = Material.RECORD_7;
					return true;
				case 8:
					this.record = Material.RECORD_8;
					return true;
				case 9:
					this.record = Material.RECORD_9;
					return true;
				case 10:
					this.record = Material.RECORD_10;
					return true;
				case 11:
					this.record = Material.RECORD_11;
					return true;
				default:
					pj.logger.log(Level.INFO, "Such an record doesn't exist. Set to default: RECORD_3");
					this.record = Material.RECORD_3;
					return true;
				}
			}else{
				pj.logger.log(Level.INFO, "Can't identify input at [PoweredJb] sign.");
				return false;
			}
		}else{
			return false;
		}
	}
	
	public Material getRecord(){
		return this.record;
	}
}
