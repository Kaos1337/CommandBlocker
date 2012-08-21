package net.kaoslabs.commandblocker;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import net.kaoslabs.commandblocker.util.ConfigHelper;
import net.kaoslabs.commandblocker.util.Metrics;


public class CommandBlocker extends JavaPlugin {

	public static final Logger log = Logger.getLogger("Minecraft");

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		// start Metrics
		startMetrics();
	}
	
	public void startMetrics() { 	
		try {	
			Metrics metrics = new Metrics(this);	
			metrics.start();
			CommandBlocker.log.info("[CommandBlocker] Metrics connection started.");
		} catch (IOException e) {
			CommandBlocker.log.warning("[CommandBlocker] Failed to submit the stats :-("); // Failed to submit the stats :-(
		}
	}
	
	/**
	 * Runs a configuration routine for initialization of the plugin
	 */
	public void configurePlugin() {
		// define that default config should be copied
		this.getConfig().options().copyDefaults(true);

		// check for the existance of plugin folder
		if (!getDataFolder().exists()) {
			getDataFolder().mkdir(); // create it!
		}
		
		// create config helper
		ConfigHelper configHelper = new ConfigHelper();
		// update defaults of existing arenas
		configHelper.updateDefaults();
		// update sample config, if needed
		configHelper.updateSampleConfig();
		// update language files
		//configHelper.updateLanguageFiles();
		
	}


}
