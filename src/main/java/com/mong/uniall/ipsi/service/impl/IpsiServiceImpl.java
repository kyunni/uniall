package com.mong.uniall.ipsi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mong.uniall.ipsi.service.IpsiService;

import egovframework.rte.fdl.cmmn.exception.BaseException;

@Service("extraIpsiService")
public class IpsiServiceImpl implements IpsiService {
	
	@Autowired
	private IpsiService ipsiService;

	public Map<String, Object> selectIpsiInfo(Map<String, Object> param) throws BaseException {
		return ipsiService.selectIpsiInfo(param);
	}

	public void insertIpsiApplication(Map<String, Object> param) throws BaseException {
		ipsiService.insertIpsiApplication(param);
	}
	
	public List<Map<String, Object>> selectIpsiApplication(Map<String, Object> param) throws BaseException {
		return ipsiService.selectIpsiApplication(param);
	}
	
	public void updateIpsiApplicationStatus(Map<String, Object> param) throws BaseException {
		ipsiService.updateIpsiApplicationStatus(param);
	}
	
	public void deleteIpsiApplication(Map<String, Object> param) throws BaseException {
		ipsiService.deleteIpsiApplication(param);
	}
	
}
