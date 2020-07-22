package com.mong.uniall.ipsi.service;

import java.util.List;
import java.util.Map;

import com.mong.uniall.ipsi.service.impl.IpsiDAO;

import egovframework.rte.fdl.cmmn.exception.BaseException;

public interface IpsiService  {

	Map<String, Object> selectIpsiInfo(Map<String, Object> param) throws BaseException;
	
	void insertIpsiApplication(Map<String, Object> param) throws BaseException;

	public List<Map<String, Object>> selectIpsiApplication(Map<String, Object> param) throws BaseException;
	
	public void updateIpsiApplicationStatus(Map<String, Object> param) throws BaseException;
	
	public void deleteIpsiApplication(Map<String, Object> param) throws BaseException;
}
