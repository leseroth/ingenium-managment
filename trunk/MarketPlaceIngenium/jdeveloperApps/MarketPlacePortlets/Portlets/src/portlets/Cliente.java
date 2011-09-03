package portlets;

import java.io.IOException;

import java.util.StringTokenizer;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import oracle.portlet.bridge.adf.application.ADFBridgePortlet;

import portlets.resource.ClienteBundle;

public class Cliente extends ADFBridgePortlet {
    protected String getTitle(RenderRequest request) {
        // Get the customized title. This defaults to the declared title.
        PortletPreferences prefs = request.getPreferences();
        return prefs.getValue(PORTLETTITLE_KEY, super.getTitle(request));
    }
    public static final String APPLY_ACTION = "apply_action";
    public static final String OK_ACTION = "ok_action";
    public static final String PORTLETTITLE_KEY = "portletTitle";

    private String[] buildValueArray(String values) {
        if (values.indexOf(',') < 0) {
            return new String[] {values};
        }
        StringTokenizer st = new StringTokenizer(values, ",");
        String[] valueArray = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            valueArray[i] = st.nextToken().trim();
            i++;
        }
        return valueArray;
    }

    public void processAction(ActionRequest request,
                              ActionResponse response) throws PortletException,
                                                              IOException {
        // Determine which action.
        String okAction = request.getParameter(OK_ACTION);
        String applyAction = request.getParameter(APPLY_ACTION);

        if (okAction != null || applyAction != null) {
            // Save the preferences.
            PortletPreferences prefs = request.getPreferences();
            String param = request.getParameter(PORTLETTITLE_KEY);
            prefs.setValues(PORTLETTITLE_KEY, buildValueArray(param));
            prefs.store();
            if (okAction != null) {
                response.setPortletMode(PortletMode.VIEW);
                response.setWindowState(WindowState.NORMAL);
            }
        } else {
            request.setAttribute("javax.portlet.config", getPortletConfig());
            super.processAction(request, response);
        }
    }

    public void render(RenderRequest request,
                       RenderResponse response) throws PortletException,
                                                       IOException {
        request.setAttribute("javax.portlet.config", getPortletConfig());
        super.render(request, response);
    }
}
