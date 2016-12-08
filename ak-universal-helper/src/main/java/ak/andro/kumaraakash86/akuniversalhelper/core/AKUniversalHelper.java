package ak.andro.kumaraakash86.akuniversalhelper.core;

/**
 * Created by AAKASH on 12-11-2016.
 */
public class AKUniversalHelper {
    private volatile static AKUniversalHelper instance;
    private AKUniversalConfiguration configuration;

    private static final String ERROR_INIT_CONFIG_WITH_NULL = "AKUniversalHelper configuration can not be initialized with null";
    private static final String ERROR_NOT_INIT = "AKUniversalHelper must be init with configuration before using";

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

    public boolean isLoggingEnabled(){
        checkConfiguration();
        return configuration.enableLogging;
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
