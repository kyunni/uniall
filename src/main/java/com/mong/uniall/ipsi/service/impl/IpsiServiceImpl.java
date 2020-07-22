package com.mong.uniall.ipsi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ubstory.ext.ipsi.service.ExtraIpsiService;

import egovframework.rte.fdl.cmmn.exception.BaseException;

@Service("extraIpsiService")
public class IpsiServiceImpl extends CmsBaseServiceImpl implements IpsiService {
	
	@Override
	@Autowired
	@Qualifier("extraIpsiDAO")
	public void setCmsBaseDAO(CmsBaseDAO cmsBaseDAO) {
		super.setCmsBaseDAO(cmsBaseDAO);
	}

	public Map<String, Object> selectIpsiInfo(Map<String, Object> param) throws BaseException {
		return ((IpsiDAO)getCmsBaseDAO()).selectIpsiInfo(param);
	}

	public void insertIpsiApplication(Map<String, Object> param) throws BaseException {
		((IpsiDAO)getCmsBaseDAO()).insertIpsiApplication(param);
	}
	
	public List<Map<String, Object>> selectIpsiApplication(Map<String, Object> param) throws BaseException {
		return ((IpsiDAO)getCmsBaseDAO()).selectIpsiApplication(param);
	}
	
	public void updateIpsiApplicationStatus(Map<String, Object> param) throws BaseException {
		((IpsiDAO)getCmsBaseDAO()).updateIpsiApplicationStatus(param);
	}
	
	public void deleteIpsiApplication(Map<String, Object> param) throws BaseException {
		((IpsiDAO)getCmsBaseDAO()).deleteIpsiApplication(param);
	}
	
}
