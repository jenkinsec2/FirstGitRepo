package com.lmig.pm.build.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;

import com.lmig.pm.build.bo.EmailListBO;
import com.lmig.pm.build.bo.StreamBO;
import com.lmig.pm.build.service.StreamService;
import com.lmig.pm.build.service.StreamServiceImpl;
import com.lmig.pm.build.util.JSFUtil;

@ManagedBean(name="streamListBean")
@ViewScoped
public class StreamListManagedBean {

	private List<StreamBO> portfolioStreamlists;
	private String portfolioName;
	private String pfoRelName;
	private String strName;
	private String pfoAppName;
	private boolean isReleaseMonthListDisabled;
	private StreamBO streamObj;
	private StreamService streamService;
	private boolean sendemail;
	private List<EmailListBO> listofEmail;
	private List<String> sendersList = new ArrayList<String>();
	private Map<String, List<String>> pfoRelList = new HashMap<String, List<String>>();
	private List<String> pfoList = new ArrayList<String>();
	private int page = 1;
	
	@PostConstruct
	public void init(){

		if(streamObj == null){
			streamObj = new StreamBO();
		}
			
		streamService = new StreamServiceImpl(); 
		portfolioStreamlists = new ArrayList<StreamBO>();
		portfolioStreamlists = streamService.retriveStreamList();
		
		//pfoList.add(" ");
		pfoList.add("Claims");
		pfoList.add("Distribution");
		pfoList.add("DocumentSolutions");
		pfoList.add("eCommerce");
		pfoList.add("Finance");
		pfoList.add("Products");
		//pfoList = streamService.getPortfolioNames();
		
		listofEmail = new ArrayList<EmailListBO>();
		listofEmail = streamService.retriveEmailList();
	}

	public String add(AjaxBehaviorEvent ae) throws Exception{
		
		if(sendemail){
			System.out.println(sendemail);
			JSFUtil.generateFacesMsg("Email Sent", null, FacesMessage.SEVERITY_INFO);
		}
		System.out.println(sendemail);
		//streamService.addStreamList(streamObj);
		JSFUtil.generateFacesMsg("New Stream Details are added", null, FacesMessage.SEVERITY_INFO);
		return null;
	}
	
	public String clear(){
		return "streamsList";
	}
	
	public String cancel(){
		return "main";
	}
	
	public void valiadte(AjaxBehaviorEvent ae){
		System.out.println("Value of send email boolean : "+ sendemail);
	}
	/**
	 * @return the streamList
	 */
	public Map<String, List<String>> getStreamList() {
		return pfoRelList;
	}

	/**
	 * @param streamList the streamList to set
	 */
	public void setStreamList(Map<String, List<String>> pfoRelList) {
		this.pfoRelList = pfoRelList;
	}

	/**
	 * @return the portfolioStreamlists
	 */
	public List<StreamBO> getPortfolioStreamlists() {
		return portfolioStreamlists;
	}

	/**
	 * @param portfolioStreamlists the portfolioStreamlists to set
	 */
	public void setPortfolioStreamlists(List<StreamBO> portfolioStreamlists) {
		this.portfolioStreamlists = portfolioStreamlists;
	}

	/**
	 * @return the portfolioName
	 */
	public String getPortfolioName() {
		return portfolioName;
	}

	/**
	 * @param portfolioName the portfolioName to set
	 */
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	/**
	 * @return the pfoRelName
	 */
	public String getPfoRelName() {
		return pfoRelName;
	}

	/**
	 * @param pfoRelName the pfoRelName to set
	 */
	public void setPfoRelName(String pfoRelName) {
		this.pfoRelName = pfoRelName;
	}

	/**
	 * @return the isReleaseMonthListDisabled
	 */
	public boolean isReleaseMonthListDisabled() {
		return isReleaseMonthListDisabled;
	}

	/**
	 * @param isReleaseMonthListDisabled the isReleaseMonthListDisabled to set
	 */
	public void setReleaseMonthListDisabled(boolean isReleaseMonthListDisabled) {
		this.isReleaseMonthListDisabled = isReleaseMonthListDisabled;
	}

	public Map<String, List<String>> getPfoRelList() {
		return pfoRelList;
	}

	public void setPfoRelList(Map<String, List<String>> pfoRelList) {
		this.pfoRelList = pfoRelList;
	}

	/**
	 * @return the pfoList
	 */
	public List<String> getPfoList() {
		return pfoList;
	}

	/**
	 * @param pfoList the pfoList to set
	 */
	public void setPfoList(List<String> pfoList) {
		this.pfoList = pfoList;
	}

	/**
	 * @return the strName
	 */
	public String getStrName() {
		return strName;
	}

	/**
	 * @param strName the strName to set
	 */
	public void setStrName(String strName) {
		this.strName = strName;
	}

	/**
	 * @return the streamObj
	 */
	public StreamBO getStreamObj() {
		return streamObj;
	}

	/**
	 * @param streamObj the streamObj to set
	 */
	public void setStreamObj(StreamBO streamObj) {
		this.streamObj = streamObj;
	}

	/**
	 * @return the listofEmail
	 */
	public List<EmailListBO> getListofEmail() {
		return listofEmail;
	}

	/**
	 * @param listofEmail the listofEmail to set
	 */
	public void setListofEmail(List<EmailListBO> listofEmail) {
		this.listofEmail = listofEmail;
	}

	/**
	 * @return the sendersList
	 */
	public List<String> getSendersList() {
		return sendersList;
	}

	/**
	 * @param sendersList the sendersList to set
	 */
	public void setSendersList(List<String> sendersList) {
		this.sendersList = sendersList;
	}

	/**
	 * @return the sendemail
	 */
	public boolean isSendemail() {
		return sendemail;
	}

	/**
	 * @param sendemail the sendemail to set
	 */
	public void setSendemail(boolean sendemail) {
		this.sendemail = sendemail;
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the pfoAppName
	 */
	public String getPfoAppName() {
		return pfoAppName;
	}

	/**
	 * @param pfoAppName the pfoAppName to set
	 */
	public void setPfoAppName(String pfoAppName) {
		this.pfoAppName = pfoAppName;
	}

}
