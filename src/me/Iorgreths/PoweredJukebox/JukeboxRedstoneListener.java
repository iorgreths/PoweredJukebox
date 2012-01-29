package me.Iorgreths.PoweredJukebox;

import org.bukkit.Material;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockRedstoneEvent;

public class JukeboxRedstoneListener extends BlockListener{
	
	private PoweredJukebox pj;
	private HandleSign hs;
	private HandleJB hjb;
	
	public JukeboxRedstoneListener(PoweredJukebox pj){
		this.pj = pj;
	}
	
	public void onBlockRedstoneChange(BlockRedstoneEvent event) {
		if( ( (event.getBlock().getType()==Material.SIGN_POST) && ( (event.getBlock().isBlockPowered()) || (event.getBlock().isBlockIndirectlyPowered()) ) ) || ( (event.getBlock().getType()==Material.WALL_SIGN) && ( (event.getBlock().isBlockPowered()) || (event.getBlock().isBlockIndirectlyPowered()) ) ) ){
			hs = new HandleSign(pj);
			hjb = new HandleJB(pj);
			hs.getSign(event.getBlock().getLocation());
			if(hs.checkFirstLine()){
				if(hs.getRecordFromSign()){
					if(hjb.getJukebox(event.getBlock().getLocation())){
						hjb.play(hs.getRecord());
						return;
					}
				}
			}
		}
	}

}
