package net.kaoslabs.commandblocker;

import net.kaoslabs.commandblocker.util.ConfigHelper;

import org.bukkit.plugin.java.JavaPlugin;

public class CommandBlocker extends JavaPlugin {


	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
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
