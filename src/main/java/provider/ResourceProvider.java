package provider;

import helper.BundleUTF8Control;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceProvider {
    /**
     * Gets user Locale from the request and returns the ResourceBundle instance
     *
     * @return ResourceBundle object with User's Locale setting.
     */
    public static ResourceBundle getResourceBundle(Locale currentLocale) {
        ResourceBundle rb = null;
        // we need some current locale from fxml
        // user interface must send a locale
        if (currentLocale != null) {
            try {
                rb = ResourceBundle.getBundle("language", currentLocale, new BundleUTF8Control());
            } catch (MissingResourceException mre) {
                mre.printStackTrace();
                try {
                    rb = ResourceBundle.getBundle("language", new Locale("tr"), new BundleUTF8Control());
                } catch (MissingResourceException re) {
                    re.printStackTrace();
                }
            }
        } else {
            rb = ResourceBundle.getBundle("language", Locale.getDefault(), new BundleUTF8Control());
        }

        return rb;
    }
}
