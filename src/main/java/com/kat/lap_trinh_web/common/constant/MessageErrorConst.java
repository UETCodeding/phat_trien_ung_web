package com.kat.lap_trinh_web.common.constant;
import javax.faces.context.FacesContext;
public class MessageErrorConst {
    public void displayEmptyError(String componentId){
        FacesContext.getCurrentInstance().getPartialViewContext().getEvalScripts().add("displayError('main\\\\:" + componentId + "', 'Can not be empty!')");
    }

    public void displayError(String componentId, String message){
        FacesContext.getCurrentInstance().getPartialViewContext().getEvalScripts().add("displayError('main\\\\:" + componentId + "', '" + message + "')");
    }

    public void hiddenError(String componentId){
        FacesContext.getCurrentInstance().getPartialViewContext().getEvalScripts().add("hiddenError('main\\\\:"+componentId +"')");
    }
}
