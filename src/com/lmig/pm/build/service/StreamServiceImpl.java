/**
 * 
 */
package com.lmig.pm.build.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lmig.pm.build.bo.EmailListBO;
import com.lmig.pm.build.bo.StreamBO;
import com.lmig.pm.build.mapper.StreamMapper;
import com.lmig.pm.build.util.MyBatisUtil;

/**
 * @author n0184388
 *
 */
public class StreamServiceImpl implements StreamService {

	/* (non-Javadoc)
	 * @see com.lmig.pm.build.service.StreamService#retriveStreamList()
	 */
	@Override
	public List<StreamBO> retriveStreamList() {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		StreamMapper streamMapper = sqlSession.getMapper(StreamMapper.class);
		return streamMapper.getListOfStreams();
	}

	/* (non-Javadoc)
	 * @see com.lmig.pm.build.service.StreamService#addStreamList()
	 */
	@Override
	public void addStreamList(StreamBO streamObj) {
	}

	/* (non-Javadoc)
	 * @see com.lmig.pm.build.service.StreamService#removeStreamList()
	 */
	@Override
	public void removeStreamList() {
	}

	@Override
	public List<String> getPortfolioNames() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		StreamMapper streamMapper = sqlSession.getMapper(StreamMapper.class);
		return streamMapper.getPortFolioNames();
	}

	@Override
	public List<EmailListBO> retriveEmailList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		StreamMapper streamMapper = sqlSession.getMapper(StreamMapper.class);
		return streamMapper.getEmailList();
	}

}
