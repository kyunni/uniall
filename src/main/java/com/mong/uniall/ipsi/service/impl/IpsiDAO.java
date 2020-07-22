package com.mong.uniall.ipsi.service.impl;

import java.util.List;
import java.util.Map;

import egovframework.rte.fdl.cmmn.exception.BaseException;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("extraIpsiDAO")
public interface IpsiDAO {
	
	Map<String, Object> selectIpsiInfo(Map<String, Object> param) throws BaseException;
	
	void insertIpsiApplication(Map<String, Object> param) throws BaseException;
	
	List<Map<String, Object>> selectIpsiApplication(Map<String, Object> param) throws BaseException;
	
	void updateIpsiApplicationStatus(Map<String, Object> param) throws BaseException;
	
	void deleteIpsiApplication(Map<String, Object> param) throws BaseException;
	
}
