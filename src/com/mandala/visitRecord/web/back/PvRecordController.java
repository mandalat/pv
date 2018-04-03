package com.mandala.visitRecord.web.back;

import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.jeecgframework.p3.core.util.SystemTools;
import org.jeecgframework.p3.core.util.UUIDGenerator;

import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;

import com.mandala.dictinfo.entity.Dictinfo;
import com.mandala.dictinfo.service.DictinfoService;
import com.mandala.system.vo.LoginUserNew;
import com.mandala.visitRecord.entity.PvRecord;
import com.mandala.visitRecord.service.PvRecordService;

import org.jeecgframework.p3.core.web.BaseController;

 /**
 * 描述：</b>PvRecordController<br>
 * @author zhangliang
 * @since：2018年03月13日 17时18分14秒 星期二 
 * @version:1.0
 */
@Controller
@RequestMapping("/visitRecord/back/pvRecord")
public class PvRecordController extends BaseController{
  @Autowired
  private PvRecordService pvRecordService;
  
  @Autowired
  private DictinfoService dictinfoService;
  
/**
  * 列表页面
  * @return
  */
@RequestMapping(value="list",method = {RequestMethod.GET,RequestMethod.POST})
public void list(@ModelAttribute PvRecord query,HttpServletResponse response,HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
	 	PageQuery<PvRecord> pageQuery = new PageQuery<PvRecord>();
	 	pageQuery.setPageNo(pageNo);
	 	pageQuery.setPageSize(pageSize);
	 	VelocityContext velocityContext = new VelocityContext();
		pageQuery.setQuery(query);
		//获取科室
		Dictinfo dic = new Dictinfo();
		dic.setTypeid("402881be6222014e016222014e500000");
		List<Dictinfo> deptList = dictinfoService.queryList(dic);
		net.sf.json.JSONArray deptArr = new net.sf.json.JSONArray();
		velocityContext.put("deptList",deptArr.fromObject(deptList).toString());
		//获取随访状态
		dic.setTypeid("402881be6222014e01622204ef710001");
		List<Dictinfo> statusList = dictinfoService.queryList(dic);
		net.sf.json.JSONArray statusArr = new net.sf.json.JSONArray();
		velocityContext.put("statusList",statusArr.fromObject(statusList).toString());
		//获取终止原因
		dic.setTypeid("402881be62221e4a0162221e4a200000");
		List<Dictinfo> cancelList = dictinfoService.queryList(dic);
		net.sf.json.JSONArray cancelArr = new net.sf.json.JSONArray();
		velocityContext.put("cancelList",cancelArr.fromObject(cancelList).toString());
		net.sf.json.JSONObject queryForm =new net.sf.json.JSONObject();
		velocityContext.put("pvRecord",queryForm.fromObject(query).toString());
		velocityContext.put("pageInfos",SystemTools.convertPaginatedList(pvRecordService.queryPageList(pageQuery)));
		String viewName = "visitRecord/back/pvRecord-list.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
}

@RequestMapping(value="myList",method = {RequestMethod.GET,RequestMethod.POST})
public void myList(@ModelAttribute PvRecord query,HttpServletResponse response,HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
		LoginUserNew user = (LoginUserNew)request.getSession().getAttribute("LOGIN_USER");
		if(null != user){
			if(user.getLoginType().equals("0")){
			 	//如果当前用户是医生
			 	query.setCreateUserId(user.getUserId());
			}
			if(user.getLoginType().equals("1")){
			 	//如果当前用户是病人
			 	query.setPatientId(user.getUserId());
			}
		}
	 	PageQuery<PvRecord> pageQuery = new PageQuery<PvRecord>();
	 	pageQuery.setPageNo(pageNo);
	 	pageQuery.setPageSize(pageSize);
	 	VelocityContext velocityContext = new VelocityContext();

		pageQuery.setQuery(query);
		//获取科室
		Dictinfo dic = new Dictinfo();
		dic.setTypeid("402881be6222014e016222014e500000");
		List<Dictinfo> deptList = dictinfoService.queryList(dic);
		net.sf.json.JSONArray deptArr = new net.sf.json.JSONArray();
		velocityContext.put("deptList",deptArr.fromObject(deptList).toString());
		//获取随访状态
		dic.setTypeid("402881be6222014e01622204ef710001");
		List<Dictinfo> statusList = dictinfoService.queryList(dic);
		net.sf.json.JSONArray statusArr = new net.sf.json.JSONArray();
		velocityContext.put("statusList",statusArr.fromObject(statusList).toString());
		//获取终止原因
		dic.setTypeid("402881be62221e4a0162221e4a200000");
		List<Dictinfo> cancelList = dictinfoService.queryList(dic);
		net.sf.json.JSONArray cancelArr = new net.sf.json.JSONArray();
		velocityContext.put("cancelList",cancelArr.fromObject(cancelList).toString());
		net.sf.json.JSONObject queryForm =new net.sf.json.JSONObject();
		velocityContext.put("pvRecord",queryForm.fromObject(query).toString());
		velocityContext.put("pageInfos",SystemTools.convertPaginatedList(pvRecordService.queryPageList(pageQuery)));
		String viewName = "visitRecord/back/pvRecord-myList.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
}


@RequestMapping(value="getMyList",method = {RequestMethod.GET,RequestMethod.POST})
@ResponseBody
public String  getMyList(@ModelAttribute PvRecord query,HttpServletResponse response,HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
	 	PageQuery<PvRecord> pageQuery = new PageQuery<PvRecord>();
		LoginUserNew user = (LoginUserNew)request.getSession().getAttribute("LOGIN_USER");
		if(null != user){
			if(user.getLoginType().equals("0")){
			 	//如果当前用户是医生
			 	query.setCreateUserId(user.getUserId());
			}
			if(user.getLoginType().equals("1")){
			 	//如果当前用户是病人
			 	query.setPatientId(user.getUserId());
			}
		}
	 	pageQuery.setPageNo(pageNo);
	 	pageQuery.setPageSize(pageSize);
	 	VelocityContext velocityContext = new VelocityContext();
		pageQuery.setQuery(query);
		net.sf.json.JSONArray dataArr = new net.sf.json.JSONArray();
		net.sf.json.JSONObject dataobj = new net.sf.json.JSONObject();
		dataobj.put("result", true);
		dataobj.put("data", dataArr.fromObject(pvRecordService.queryPageList(pageQuery).getValues()));
		dataobj.put("total", SystemTools.convertPaginatedList(pvRecordService.queryPageList(pageQuery)).getTotalItem()); 
		dataobj.put("pageSize", pageSize);
		dataobj.put("pageNo", pageNo);
		return dataobj.toString();
}

@RequestMapping(value="getMyToDoList",method = {RequestMethod.GET,RequestMethod.POST})
@ResponseBody
public String  getMyToDoList(@ModelAttribute PvRecord query,HttpServletResponse response,HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
	 	PageQuery<PvRecord> pageQuery = new PageQuery<PvRecord>();
	 	String type = request.getParameter("type");
		LoginUserNew user = (LoginUserNew)request.getSession().getAttribute("LOGIN_USER");
		if(null != user){
			if(user.getLoginType().equals("0")){
			 	//如果当前用户是医生
			 	query.setCreateUserId(user.getUserId());
			}
			if(user.getLoginType().equals("1")){
			 	//如果当前用户是病人
			 	query.setPatientId(user.getUserId());
			}
		}
	 	pageQuery.setPageNo(pageNo);
	 	pageQuery.setPageSize(pageSize);
	 	VelocityContext velocityContext = new VelocityContext();
	 	if(null !=type && type.equals("0")){
		 	query.setEndVisitDate(new Date());
	 	}
	 	if(null !=type && type.equals("1")){
			query.setEndVisitDate(null);
			query.setBeginVisitDate(new Date());
	 	}

		pageQuery.setQuery(query);
		net.sf.json.JSONArray dataArr = new net.sf.json.JSONArray();
		net.sf.json.JSONObject dataobj = new net.sf.json.JSONObject();
		dataobj.put("result", true);
		dataobj.put("data", dataArr.fromObject(pvRecordService.queryPageListToDo(pageQuery).getValues()));
		dataobj.put("total", SystemTools.convertPaginatedList(pvRecordService.queryPageListToDo(pageQuery)).getTotalItem()); 
		return dataobj.toString();
}


@RequestMapping(value="getList",method = {RequestMethod.GET,RequestMethod.POST})
@ResponseBody
public String  getList(@ModelAttribute PvRecord query,HttpServletResponse response,HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
	 	PageQuery<PvRecord> pageQuery = new PageQuery<PvRecord>();
	 	pageQuery.setPageNo(pageNo);
	 	pageQuery.setPageSize(pageSize);
	 	VelocityContext velocityContext = new VelocityContext();
		pageQuery.setQuery(query);
		net.sf.json.JSONArray dataArr = new net.sf.json.JSONArray();
		net.sf.json.JSONObject dataobj = new net.sf.json.JSONObject();
		 PageList<PvRecord> pl = pvRecordService.queryPageList(pageQuery);
		dataobj.put("result", true);
		dataobj.put("data", dataArr.fromObject(pl.getValues()));
		dataobj.put("total", SystemTools.convertPaginatedList(pl).getTotalItem()); 
		dataobj.put("pageSize", pageSize);
		dataobj.put("pageNo", pageNo);
		return dataobj.toString();
}
 /**
  * 详情
  * @return
  */
@RequestMapping(value="visitView",method = RequestMethod.GET)
public void pvRecordDetail(@RequestParam(required = true, value = "rid" ) String rid,HttpServletResponse response,HttpServletRequest request)throws Exception{
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "visitRecord/back/pvRecord-detail.vm";
		PvRecord pvRecord = pvRecordService.queryById(rid);
		velocityContext.put("pvRecord",pvRecord);
		ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 跳转到添加页面
 * @return
 */
@RequestMapping(value = "/toAdd",method ={RequestMethod.GET, RequestMethod.POST})
public void toAddDialog(HttpServletRequest request,HttpServletResponse response,ModelMap model)throws Exception{
	 VelocityContext velocityContext = new VelocityContext();
	 String viewName = "visitRecord/back/pvRecord-add.vm";
	 ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 保存信息
 * @return
 */
@RequestMapping(value = "/doAdd",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doAdd(@ModelAttribute PvRecord pvRecord){
	AjaxJson j = new AjaxJson();
	try {
		pvRecord.setRid(UUIDGenerator.generate());
		pvRecordService.doAdd(pvRecord);
		j.setMsg("保存成功");
	} catch (Exception e) {
		j.setSuccess(false);
		j.setMsg("保存失败");
	}
	return j;
}

/**
 * 跳转到编辑页面
 * @return
 */
@RequestMapping(value="toEdit",method = RequestMethod.GET)
public void toEdit(@RequestParam(required = true, value = "rid" ) String rid,HttpServletResponse response,HttpServletRequest request) throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 PvRecord pvRecord = pvRecordService.queryById(rid);
		 velocityContext.put("pvRecord",pvRecord);
		 String viewName = "visitRecord/back/pvRecord-edit.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 编辑
 * @return
 */
@RequestMapping(value = "/doEdit",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doEdit(@ModelAttribute PvRecord pvRecord,HttpServletRequest request){
	AjaxJson j = new AjaxJson();
	LoginUserNew user = (LoginUserNew)request.getSession().getAttribute("LOGIN_USER");
	try {
		PvRecord pr = pvRecordService.queryById(pvRecord.getRid());
		if(null != user &&( pr.getCreateUserId().equals(user.getUserId())||pr.getPatientId().equals(user.getUserId()))){
			if(null != pvRecord.getVisitStatus() && pvRecord.getVisitStatus().equals("sf11")){
				pvRecord.setActualVisitDate(new Date());
			}
			pvRecord.setUpdateTime(new Date());
			pvRecord.setUpdateUserId(user.getUserId());
			pvRecord.setUpdateUserName(user.getUserName());
			pvRecordService.doEdit(pvRecord);
			j.setMsg("编辑成功");
		}else{
			j.setSuccess(false);
			j.setMsg("编辑失败");
		}
	} catch (Exception e) {
		j.setSuccess(false);
		j.setMsg("编辑失败");
	}
	return j;
}


/**
 * 删除
 * @return
 */
@RequestMapping(value="doDelete",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doDelete(@RequestParam(required = true, value = "rid" ) String rid,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		LoginUserNew user = (LoginUserNew)request.getSession().getAttribute("LOGIN_USER");
		 
		try {
			PvRecord pr = pvRecordService.queryById(rid);
			//查询当前人是有否有权限删除记录
			if(null != user && pr.getCreateUserId().equals(user.getUserId())){
				pvRecordService.doDelete(rid);
				j.setMsg("删除成功");
			}else{
				j.setSuccess(false);
				j.setMsg("删除失败");
			}

		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("删除失败");
		}
		return j;
}


}

