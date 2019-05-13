package helper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class BundleUTF8Control extends ResourceBundle.Control {

    public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
            throws IllegalAccessException, InstantiationException, IOException {

        String bundleName = toBundleName(baseName, locale);
        // default language file
        String         resourceName = "i18n/" + toResourceName(bundleName, "properties");
        ResourceBundle bundle       = null;
        InputStream    stream       = null;
        if (reload) {
            URL url = loader.getResource(resourceName);
            if (url != null) {
                URLConnection connection = url.openConnection();
                if (connection != null) {
                    connection.setUseCaches(false);
                    stream = connection.getInputStream();
                }
            }
        } else {
            stream = loader.getResourceAsStream(resourceName);
        }
        if (stream != null) {
            try {
                if (new Locale("tr").equals(locale)) {
                    // this line is changed to make it to read properties files as iso-8859-9.
                    bundle = new PropertyResourceBundle(new InputStreamReader(stream, "ISO-8859-9"));
                } else {
                    bundle = new PropertyResourceBundle(new InputStreamReader(stream, "UTF-8"));
                }
            } finally {
                stream.close();
            }
        }
        return bundle;

    }//end of newBundle() method

}//end of class
