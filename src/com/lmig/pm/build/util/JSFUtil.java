
package com.lmig.pm.build.util;

import java.text.SimpleDateFormat;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JSFUtil {
	
    /**
     * ***********************************************************************
     * @Description: Gets the value of a request parameter stored in a page using
     * the f:param tag.
     * @param name the name of the param to retrieve. Matches the name attribute of
     * the f:param tag.
     * @return
     *************************************************************************
     */
    public static String getRequestParameter(String name) {
        return (String) FacesContext.getCurrentInstance().getExternalContext()
            .getRequestParameterMap().get(name);
    }
    
    /*************************************************************************
     * @Description: Adds a FacesMessage to the FacesContext
     *  in order to display error on the screen
     * @param errorMessage - The error message to display
     **************************************************************************/
    public static void generateFacesMsg(String errorMessage, String componentId, Severity severity) {
    	FacesContext context = FacesContext.getCurrentInstance();
    	FacesMessage message = new FacesMessage();
    	message.setSummary(errorMessage);
    	message.setSeverity(severity);
    	context.addMessage(componentId, message);
    }

   
    /*************************************************************************
     * @Description: Adds a FacesMessage to the FacesContext
     *  in order to display error on the screen
     * @param errorMessage - The error message to display
     **************************************************************************/
    public static void generateFacesMsg(String errorMessage) {
    	generateFacesMsg(errorMessage, null, FacesMessage.SEVERITY_ERROR);
    }
    
   
    /**
     * 
     * @return ServletContext
     */
    public static ServletContext getContext() {
    	return (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    }
    
    /**
     * 
     * @return HttpServletRequest 
     */
    public static HttpServletRequest getRequest(){
    	return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }
    
    /**
     * 
     * @return HttpServletResponse
     */
    public static HttpServletResponse getResponse(){
    	return (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
    }

}
