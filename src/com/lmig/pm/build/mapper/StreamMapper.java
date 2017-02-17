/**
 * 
 */
package com.lmig.pm.build.mapper;

import java.util.List;

import com.lmig.pm.build.bo.EmailListBO;
import com.lmig.pm.build.bo.StreamBO;

/**
 * @author n0184388
 *
 */
public interface StreamMapper {
	public List<StreamBO> getListOfStreams();
	public List<String> getPortFolioNames();
	public List<EmailListBO> getEmailList();
}
