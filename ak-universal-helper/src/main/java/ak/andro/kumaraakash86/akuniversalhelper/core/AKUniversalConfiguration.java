package ak.andro.kumaraakash86.akuniversalhelper.core;

import android.content.Context;

/**
 * Created by AAKASH on 08-12-2016.
 */
public final class AKUniversalConfiguration {


    final boolean enableLogging;
    final boolean enableSaveLogging;
    final String fontDirectory;
    final Context globalContext;

    //  SETTING GLOBAL CONFIGURATION FOR LIBRARY
    public AKUniversalConfiguration(final Builder builder)
    {
        enableLogging = builder.enableLogging;
        enableSaveLogging = builder.enableSaveLogging;
        fontDirectory = builder.fontDirectory;
        globalContext = builder.context;
    }

    public static AKUniversalConfiguration createDefault(Context context) {
        return new Builder(context).build();
    }

    public static class Builder{
        private boolean enableLogging = true;
        private boolean enableSaveLogging = false;
        private String fontDirectory = "";

        private Context context;
        public Builder(Context ctx)
        {
            this.context = ctx.getApplicationContext();
        }

        //  ENABLE/DISABLE LOG MESSAGING
        public Builder EnableLogMessages(boolean logging)
        {
            this.enableLogging = logging;
            return this;
        }

        //  ENABLE/DISABLE SAVING LOG IN FILE
        public Builder SaveLogMessages(boolean logging)
        {
            this.enableSaveLogging = logging;
            return this;
        }

        public Builder SetFontPath(String path){
            if(path.endsWith("\\"))
                throw new RuntimeException("Assets path can only accept forward slashes ( / ).");

            path = (path.endsWith("/") ? path : path+"/" );
            this.fontDirectory = path;
            return this;
        }

        /** Builds configured {@link AKUniversalConfiguration} object */
        public AKUniversalConfiguration build() {
            initEmptyFieldsWithDefaultValues();
            return new AKUniversalConfiguration(this);
        }

        private void initEmptyFieldsWithDefaultValues() {

        }
    }
}
