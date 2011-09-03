package portlets.resource;

import java.util.ListResourceBundle;

public class Portlet1Bundle extends ListResourceBundle {
    public static final String OK_LABEL = "oklabel";
    public static final String APPLY_LABEL = "applylabel";
    public static final String PORTLET_INFO_TITLE = "javax.portlet.title";
    public static final String PORTLET_INFO_SHORT_TITLE = "javax.portlet.short-title";
    public static final String PORTLETTITLE = "javax.portlet.preference.name.portletTitle";
    private static final Object[][] sContents =
    {
    {OK_LABEL, "OK"},
    {APPLY_LABEL, "Apply"},
    {PORTLET_INFO_TITLE, "Ejemplo"},
    {PORTLET_INFO_SHORT_TITLE, "Ejemplo"},
    {PORTLETTITLE, "Portlet Title"},
  };

    public Object[][] getContents() {
        return sContents;
    }
}
