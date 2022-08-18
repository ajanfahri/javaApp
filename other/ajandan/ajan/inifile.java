/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;


import java.awt.Font;
import java.io.File;
import java.io.Serializable;


public class inifile implements Serializable {
    private String AAA="fahri";
    private String updateURL="https://www.ajancnc.com/ajancncupdate/AjanCncUpdateConfig.xml";
    private String versionNumber="3.60";
    private String LastPublishedDate="01.03.2022"; 
    private File projectFile=new File("proj");
    private String lastFilePath="empty";
    private  String lastAyarFile="empty";
    private boolean api_enable=false;
    private int axisRotate=0;
    //Font currentFont=new Font("Verdana", Font.BOLD, 12);

    /**
     * @return the AAA
     */
    public String getAAA() {
        return AAA;
    }

    /**
     * @param AAA the AAA to set
     */
    public void setAAA(String AAA) {
        this.AAA = AAA;
    }

    /**
     * @return the updateURL
     */
    public String getUpdateURL() {
        return updateURL;
    }

    /**
     * @param updateURL the updateURL to set
     */
    public void setUpdateURL(String updateURL) {
        this.updateURL = updateURL;
    }

    /**
     * @return the versionNumber
     */
    public String getVersionNumber() {
        return versionNumber;
    }

    /**
     * @param versionNumber the versionNumber to set
     */
    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    /**
     * @return the LastPublishedDate
     */
    public String getLastPublishedDate() {
        return LastPublishedDate;
    }

    /**
     * @param LastPublishedDate the LastPublishedDate to set
     */
    public void setLastPublishedDate(String LastPublishedDate) {
        this.LastPublishedDate = LastPublishedDate;
    }

    /**
     * @return the projectFile
     */
    public File getProjectFile() {
        return projectFile;
    }

    /**
     * @param projectFile the projectFile to set
     */
    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }

    /**
     * @return the lastFilePath
     */
    public String getLastFilePath() {
        return lastFilePath;
    }

    /**
     * @param lastFilePath the lastFilePath to set
     */
    public void setLastFilePath(String lastFilePath) {
        this.lastFilePath = lastFilePath;
    }

    /**
     * @return the lastAyarFile
     */
    public String getLastAyarFile() {
        return lastAyarFile;
    }

    /**
     * @param lastAyarFile the lastAyarFile to set
     */
    public void setLastAyarFile(String lastAyarFile) {
        this.lastAyarFile = lastAyarFile;
    }

    /**
     * @return the api_enable
     */
    public boolean isApi_enable() {
        return api_enable;
    }

    /**
     * @param api_enable the api_enable to set
     */
    public void setApi_enable(boolean api_enable) {
        this.api_enable = api_enable;
    }

    int getAxisRotate() {
        return axisRotate;
    }
    
    
    
}
