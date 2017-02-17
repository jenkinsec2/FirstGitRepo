/**
 * 
 */
package com.lmig.pm.build.service;

import java.util.List;

import com.lmig.pm.build.bo.EmailListBO;
import com.lmig.pm.build.bo.StreamBO;

/**
 * @author n0184388
 *
 */
public interface StreamService {
	
	public List<StreamBO> retriveStreamList();
	public List<EmailListBO> retriveEmailList();
	public List<String> getPortfolioNames();
	public void addStreamList(StreamBO streamObj);
	public void removeStreamList();

}
