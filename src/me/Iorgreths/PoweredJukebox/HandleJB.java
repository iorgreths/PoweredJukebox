package me.Iorgreths.PoweredJukebox;

import java.util.logging.Level;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Jukebox;

public class HandleJB {

	private Jukebox jb;
	private PoweredJukebox pj;
	
	public HandleJB(PoweredJukebox pj){
		this.pj = pj;
	}
	
	public boolean getJukebox(Location loc){
		for(BlockFace bf : BlockFace.values()){
			if( (bf != BlockFace.DOWN) && (bf != BlockFace.UP) && (bf != BlockFace.SELF)){
				if(loc.getBlock().getRelative(bf).getType() == Material.JUKEBOX){
					jb = (Jukebox) loc.getBlock().getRelative(bf).getState();
					return true;
				}
			}
		}
		Location loc2 = loc.getBlock().getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN).getLocation();
		for(BlockFace b : BlockFace.values()){
			if(b != BlockFace.DOWN){
				if(loc2.getBlock().getRelative(b).getType() == Material.JUKEBOX){
					jb = (Jukebox) loc2.getBlock().getRelative(b).getState();
					return true;
				}
			}
		}
		pj.logger.log(Level.INFO, "No jukebox near [PoweredJB] sign.");
		return false;
	}
	
	public void play(Material record){
		jb.setPlaying(record);
	}
}
