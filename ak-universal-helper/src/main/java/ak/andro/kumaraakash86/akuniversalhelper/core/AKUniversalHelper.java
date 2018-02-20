package ak.andro.kumaraakash86.akuniversalhelper.core;

import android.content.Context;

/**
 * Created by AAKASH on 12-11-2016.
 */
public class AKUniversalHelper {
    private volatile static AKUniversalHelper instance;
    private AKUniversalConfiguration configuration;

    private static final String ERROR_INIT_CONFIG_WITH_NULL = "AKUniversalHelper configuration can not be initialized with null";
    private static final String ERROR_NOT_INIT = "AKUniversalHelper must be init with configuration before using";

    //  GET HELPER CONFIGURATION INSTANCE
    public static AKUniversalHelper getInstance()
    {
        if(instance == null)
        {
            synchronized (AKUniversalHelper.class){
                if(instance == null)
                {
                    instance = new AKUniversalHelper();
                }
            }
        }
        return instance;
    }

    public synchronized void init(AKUniversalConfiguration config)
    {
        if(config == null)
            throw new IllegalArgumentException(ERROR_INIT_CONFIG_WITH_NULL);
        else
            configuration = config;
//        else
//        {
//            AKUniversalConfiguration.Builder cnfg = new AKUniversalConfiguration.Builder(get)
//        }
    }

    //  CHECK IF LOGGING IS ENABLE
    public boolean isLoggingEnabled(){
        checkConfiguration();
        return configuration.enableLogging;
    }

    //  CHECK IF SAVE LOG IS ENABLE
    public boolean isSavingEnabled(){
        checkConfiguration();
        return configuration.enableSaveLogging;
    }

    //  CHECK IF FONT DIRECTORY PATH DEFINED
    public String getFontDirectory(){
        checkConfiguration();
        return configuration.fontDirectory;
    }

    //  CHECK IF SAVE LOG IS ENABLE
    public Context getContext(){
        checkConfiguration();
        return configuration.globalContext;
    }

    /**
     * Checks if AKUniversalHelper's configuration was initialized
     *
     * @throws IllegalStateException if configuration wasn't initialized
     */
    private void checkConfiguration() {
        if (configuration == null) {
            throw new IllegalStateException(ERROR_NOT_INIT);
        }
    }
}
