package com.mong.uniall.ipsi.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mong.uniall.ipsi.service.IpsiService;

import egovframework.rte.fdl.cmmn.exception.BaseException;

@Controller
@RequestMapping("/mnt/*")
public class IpsiController {

	private IpsiService ipsiService;
	
	@GetMapping("/ipsi/ipsiAppList.do")
	public String getList(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws BaseException {
		
		return "mnt/ipsi/app_list";
	}
	
/*	@GetMapping("/ipsi/excelDownload.do")
	public ModelAndView excelDownload(HttpServletRequest request, ModelMap model) throws Exception {
		model.addAttribute("title", "입시자료 신청 리스트");
		
		setExcelView("ExtraIpsiExcelView");
		
		return super.excelDownload(request, model);
	}*/
	
	@GetMapping("/ipsi/ipsiAppWrite.do")
	public String write(HttpServletRequest reqeust, HttpServletResponse response, ModelMap model) throws BaseException {
		
		return "mnt/ext/ipsi_app_write";
	}
/*	
	@RequestMapping(value={"/ubhome/ajax/ipsiAppUpdateStatus.do", "/{loginStr}/ubhome/ajax/ipsiAppUpdateStatus.do"}, method=RequestMethod.POST)
	@ResponseBody
	public void updateIpsiAppStatusProc(
			HttpServletRequest request, 
			HttpServletResponse response, 
			ModelMap model) throws IOException, JSONException, BaseException {
		
		String resultCode = Common.ERROR;
		String resultMsg = "";
		
		String iaStatus = PageRequest.getParameter(request, "iaStatus");
		String iaIdxs = PageRequest.getParameter(request, "iaIdxs");
		
		LoginSessionInfo loginInfo = PageSession.getLoginSessionInfo();
		
		JSONObject json = new JSONObject();
		
		if (iaIdxs == null || StringUtil.isEmpty(iaIdxs)) {
			resultMsg = "수정할 항목을 선택 후 다시 시도해 주십시오.";
		} else if (loginInfo != null) {
			String[] arr = iaIdxs.split(",");
			
			int arrayLength = arr.length;
			List<Integer> iaIdxArray = new ArrayList<Integer>();

			for (int idx = 0; idx < arrayLength; idx++) {
				iaIdxArray.add(Integer.parseInt(arr[idx]));
			}

			Map<String, Object> param = new HashMap<String, Object>();

			param.put("IA_STATUS", iaStatus);
			param.put("MEM_IDX", loginInfo.getMemIdx());
			param.put("iaIdxs", iaIdxArray);
			
			try {

				((ExtraIpsiService)getCmsBaseService()).updateIpsiApplicationStatus(param);

				resultCode = Common.SUCCESS;
			} catch(Exception e) {
				resultMsg = "잠시 후 다시 시도해 주십시오.";
			}
		} else {
			resultMsg = "로그인 후 다시 시도해 주십시오.";
		}
		
		Common.outWrite(json, response, resultCode, resultMsg, "UPDATE STATUS");
	}
	
	@RequestMapping(value={"/ubhome/ajax/deleteIpsiApp.do", "{loginStr}/ubhome/ajax/deleteIpsiApp.do"}, method=RequestMethod.POST)
	@ResponseBody
	public void deleteIpsiAppProc(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model
			) throws IOException, JSONException {
		String resultCode = Common.ERROR;
		String resultMsg = "";
		
		String iaIdxs = PageRequest.getParameter(request, "iaIdxs");
		
		LoginSessionInfo loginInfo = PageSession.getLoginSessionInfo();
		
		JSONObject json = new JSONObject();
		
		if (iaIdxs == null || StringUtil.isEmpty(iaIdxs)) {
			resultMsg = "삭제할 항목을 선택 후 다시 시도해 주십시오.";
		} else if (loginInfo != null) {
			String[] arr = iaIdxs.split(",");
			
			int arrayLength = arr.length;
			List<Integer> iaIdxArray = new ArrayList<Integer>();
			
			for (int idx = 0; idx < arrayLength; idx++) {
				iaIdxArray.add(Integer.parseInt(arr[idx]));
			}
			Map<String, Object> param = new HashMap<String, Object>();
			
			param.put("MEM_IDX", loginInfo.getMemIdx());
			param.put("iaIdxs", iaIdxArray);
			
			try {
				((ExtraIpsiService)getCmsBaseService()).deleteIpsiApplication(param);
				
				resultCode = Common.SUCCESS;
			} catch(Exception e) {
				resultMsg = "잠시 후 다시 시도해 주십시오.";
			}
		} else {
			resultMsg = "로그인 후 다시 시도해 주십시오.";
		}
		
		Common.outWrite(json, response, resultCode, resultMsg, "DELETE STATUS");
	}*/
	
}
