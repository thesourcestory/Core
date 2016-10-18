package realtech.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.classloading.FMLForgePlugin;

/**
 * @author SkySom
 */
public class ModLogger implements ILogger {
    private Logger modLog;
    private boolean isDev;
    private String modid;

    public ModLogger(){
        this(References.Mod.MODID);
    }

    public ModLogger(String modid) {
        this.modLog = LogManager.getLogger(modid);
        this.isDev = !FMLForgePlugin.RUNTIME_DEOBF;
        this.modid = modid;
    }

    @Override
    public void warning(String message) {
        this.modLog.warn(message);
    }

    @Override
    public void info(String message) {
        this.modLog.info(message);
    }

    @Override
    public void fatal(String message) {
        this.modLog.fatal(message);
    }

    @Override
    public void error(String message) {
        this.modLog.fatal(message);
    }

    @Override
    public void devWarning(String message) {
        if(this.isDev)
            this.warning(message);
    }

    @Override
    public void devInfo(String message) {
        if(this.isDev)
            this.info(message);
    }

    @Override
    public void devFatal(String message) {
        if(this.isDev)
            this.info(message);
    }

    @Override
    public void devError(String message) {
        if(this.isDev)
            this.error(message);
    }

    public String getModid(){
        return modid;
    }
}