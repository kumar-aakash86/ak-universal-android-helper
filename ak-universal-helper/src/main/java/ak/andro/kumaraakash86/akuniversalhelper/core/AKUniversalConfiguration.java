package ak.andro.kumaraakash86.akuniversalhelper.core;

import android.content.Context;

/**
 * Created by AAKASH on 08-12-2016.
 */
public final class AKUniversalConfiguration {


    final boolean enableLogging;

    public AKUniversalConfiguration(final Builder builder)
    {
        enableLogging = builder.enableLogging;
    }
    public static AKUniversalConfiguration createDefault(Context context) {
        return new Builder(context).build();
    }

    public static class Builder{
        private boolean enableLogging = true;

        private Context context;
        public Builder(Context ctx)
        {
            this.context = ctx.getApplicationContext();
        }

        public Builder EnagleLogMessages(boolean logging)
        {
            this.enableLogging = logging;
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
