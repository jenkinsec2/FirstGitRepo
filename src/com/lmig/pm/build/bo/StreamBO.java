package com.lmig.pm.build.bo;

public class StreamBO {

	private int pfo_str_id;
	private String portfolioName;
	private String streamName;
	private String monthlyRelease;
	private String application;
	
	/**
	 * @return
	 */
	public int getPfo_str_id() {
		return pfo_str_id;
	}
	/**
	 * @param pfo_str_id
	 */
	public void setPfo_str_id(int pfo_str_id) {
		this.pfo_str_id = pfo_str_id;
	}
	/**
	 * @return
	 */
	public String getPortfolioName() {
		return portfolioName;
	}
	/**
	 * @param portfolioName
	 */
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	/**
	 * @return
	 */
	public String getStreamName() {
		return streamName;
	}
	/**
	 * @param stream_name
	 */
	public void setStreamName(String stream_name) {
		this.streamName = stream_name;
	}
	/**
	 * @return
	 */
	public String getMonthlyRelease() {
		return monthlyRelease;
	}
	/**
	 * @param monthlyRelease
	 */
	public void setMonthlyRelease(String monthlyRelease) {
		this.monthlyRelease = monthlyRelease;
	}
	/**
	 * @return the application
	 */
	public String getApplication() {
		return application;
	}
	/**
	 * @param application the application to set
	 */
	public void setApplication(String application) {
		this.application = application;
	}
}
