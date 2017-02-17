package com.lmig.pm.build.navigation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

@ManagedBean(name="navigationBean")
public class NavigationBean implements Serializable {

    private String currentPanelMenuId;

    public void selectMenu(ActionEvent event) {
        setCurrentPanelMenuId(event.getComponent().getId());
    }

    public String getCurrentPanelMenuId() {
        return currentPanelMenuId;
    }

    public void setCurrentPanelMenuId(String currentPanelMenuId) {
        this.currentPanelMenuId = currentPanelMenuId;
    }

}
