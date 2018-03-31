package com.mandala.patient.web.back;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.jeecgframework.p3.core.util.SystemTools;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.utils.common.PageQuery;

import com.mandala.dictinfo.entity.Dictinfo;
import com.mandala.dictinfo.service.DictinfoService;
import com.mandala.patientGroup.entity.PvGroupinfo;
import com.mandala.patientGroup.service.PvGroupinfoService;
import com.mandala.groupPatient.entity.PvGroupPatient;
import com.mandala.mbData.entity.PvTemplateView;
import com.mandala.mbData.service.PvTemplateViewService;
import com.mandala.patient.entity.ZyEmrBasy;
import com.mandala.patient.service.ZyEmrBasyService;
import com.mandala.system.vo.LoginUserNew;
import com.mandala.util.DateTimeUtils;

import org.jeecgframework.p3.core.web.BaseController;

 /**
 * 描述：</b>ZyEmrBasyController<br>
 * @author zhangliang
 * @since：2018年03月08日 17时48分09秒 星期四 
 * @version:1.0
 */
@Controller
@RequestMapping("/patient/back/zyEmrBasy")
public class ZyEmrBasyController extends BaseController{
  @Autowired
  private ZyEmrBasyService zyEmrBasyService;
  
  @Autowired
  private DictinfoService dictinfoService;
  
  @Autowired
  private PvTemplateViewService pvTemplateViewService;
  
  @Autowired
  private PvGroupinfoService pvGroupinfoService;
/**
  * 列表页面
  * @return
  */
@RequestMapping(value="list",method = {RequestMethod.GET,RequestMethod.POST})
public void list(@ModelAttribute ZyEmrBasy query,HttpServletResponse response,HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
	 	PageQuery<ZyEmrBasy> pageQuery = new PageQuery<ZyEmrBasy>();
	 	pageQuery.setPageNo(pageNo);
	 	pageQuery.setPageSize(pageSize);
	 	VelocityContext velocityContext = new VelocityContext();
	 	net.sf.json.JSONArray jsonArray = new net.sf.json.JSONArray();
	 	//获取科室
		Dictinfo dic = new Dictinfo();
		dic.setTypeid("402881be6222014e016222014e500000");
		List<Dictinfo> deptList = dictinfoService.queryList(dic);
		velocityContext.put("deptList",jsonArray.fromObject(deptList).toString());
		
		PvTemplateView mb = new PvTemplateView();
		//mb.setDeptCode("W15胸外科");
		List<PvTemplateView> mblist = pvTemplateViewService.queryList(mb);
		velocityContext.put("mbdata",jsonArray.fromObject(mblist).toString());
		
		
		LoginUserNew user = (LoginUserNew) request.getSession().getAttribute("LOGIN_USER");
		if(user != null){
			for (int i = 0; i < deptList.size(); i++) {
				if(deptList.get(i).getDictname()==user.getKsName()){
					query.setAdmdward(user.getKsName());
				}
			}
		}else{
			String viewName = "login/index.vm";
			ViewVelocity.view(request,response,viewName,velocityContext);
			return;
		}
		
	 	if(query.getAdmdward() == null || query.getAdmdward() =="" ){
	 		//query.setAdmdward(deptList.get(0).getDictname());
	 		query.setDiswardcode(deptList.get(0).getDictcode());
	 	}
	 	DateTimeUtils time = new DateTimeUtils();
	 	String today = time.getToday();
	 	String lastMonthToday = time.getLastMonthToday("yyyy-MM-dd");
	 	if(query.getAdmsdate() == null || query.getAdmsdate() =="" ){
	 		query.setAdmsdate(lastMonthToday);
	 		query.setAdmsdate2(today);
	 	}
	 	
	 	PvGroupinfo group = new PvGroupinfo();
		group.setGroupCreateUserid(user.getUserId());
		List<PvGroupinfo> groupList = pvGroupinfoService.queryList(group);
		velocityContext.put("groupName",jsonArray.fromObject(groupList).toString());
		
	 	net.sf.json.JSONObject queryForm =new net.sf.json.JSONObject();
		velocityContext.put("pvRecord",queryForm.fromObject(query).toString());
		pageQuery.setQuery(query);
		velocityContext.put("zyEmrBasy",query);
		velocityContext.put("pageInfos",SystemTools.convertPaginatedList(zyEmrBasyService.queryPageList(pageQuery)));
		String viewName = "patient/back/patientList.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
}
@RequestMapping(value="getList",method = {RequestMethod.GET,RequestMethod.POST})
@ResponseBody
public String getList(@ModelAttribute ZyEmrBasy query,HttpServletResponse response,HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
	 	PageQuery<ZyEmrBasy> pageQuery = new PageQuery<ZyEmrBasy>();
	 	pageQuery.setPageNo(pageNo);
	 	pageQuery.setPageSize(pageSize);
	 	VelocityContext velocityContext = new VelocityContext();
		pageQuery.setQuery(query);
		if(query.getAdmsdate() != null && query.getAdmsdate() !="" ){
	 		query.setAdmsdate(query.getAdmsdate().substring(0, 10));
	 	}
		if(query.getAdmsdate2() != null && query.getAdmsdate2() !="" ){
	 		query.setAdmsdate2(query.getAdmsdate2().substring(0, 10));
	 	}
		net.sf.json.JSONArray dataArr = new net.sf.json.JSONArray();
		net.sf.json.JSONObject dataobj = new net.sf.json.JSONObject();
		dataobj.put("result", true);
		dataobj.put("data", dataArr.fromObject(zyEmrBasyService.queryPageList(pageQuery).getValues()));
		dataobj.put("total", SystemTools.convertPaginatedList(zyEmrBasyService.queryPageList(pageQuery)).getTotalItem()); 
		dataobj.put("pageSize", pageSize);
		dataobj.put("pageNo", pageNo);
		return dataobj.toString();
}

@RequestMapping(value="patientInfo",method = {RequestMethod.GET,RequestMethod.POST})
public void patientInfo(@ModelAttribute ZyEmrBasy query,HttpServletResponse response,HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
	 	PageQuery<ZyEmrBasy> pageQuery = new PageQuery<ZyEmrBasy>();
	 	pageQuery.setPageNo(pageNo);
	 	pageQuery.setPageSize(pageSize);
	 	VelocityContext velocityContext = new VelocityContext();
	 	String patname = (String) request.getSession().getAttribute("username");
	 	String inpatient = (String) request.getSession().getAttribute("inpatient");
	 	if(patname == null || query.getPatname()=="null"){
	 		response.sendRedirect("/PatientVisit/system/login.html");
	 		return;
	 	}else{
	 		query.setPatname(patname);
	 		query.setInpatient(inpatient);
	 	}
		pageQuery.setQuery(query);
		velocityContext.put("zyEmrBasy",query);
		velocityContext.put("pageInfos",SystemTools.convertPaginatedList(zyEmrBasyService.queryPatient(pageQuery)));
		String viewName = "patient/back/zyEmrBasy-list.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
}

 /**
  * 详情
  * @return
  */
@RequestMapping(value="toDetail",method = RequestMethod.GET)
public void zyEmrBasyDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "patient/back/zyEmrBasy-detail.vm";
		ZyEmrBasy zyEmrBasy = zyEmrBasyService.queryById(id);
		velocityContext.put("zyEmrBasy",zyEmrBasy);
		ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 跳转到添加页面
 * @return
 */
@RequestMapping(value = "/toAdd",method ={RequestMethod.GET, RequestMethod.POST})
public void toAddDialog(HttpServletRequest request,HttpServletResponse response,ModelMap model)throws Exception{
	 VelocityContext velocityContext = new VelocityContext();
	 String viewName = "patient/back/zyEmrBasy-add.vm";
	 ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 保存信息
 * @return
 */
@RequestMapping(value = "/doAdd",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doAdd(@ModelAttribute ZyEmrBasy zyEmrBasy){
	AjaxJson j = new AjaxJson();
	try {
		zyEmrBasyService.doAdd(zyEmrBasy);
		j.setMsg("保存成功");
	} catch (Exception e) {
		j.setSuccess(false);
		j.setMsg("保存失败");
	}
	return j;
}


/**
 * 保存信息
 * @return
 */
@RequestMapping(value = "/doAddVisit",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doAddVisit(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
	//ZyEmrBasy zyEmrBasy = zyEmrBasyService.queryById(id);
	LoginUserNew user = (LoginUserNew) request.getSession().getAttribute("LOGIN_USER");
	String createUserName = "";
	String createUserId = "";
	DateTimeUtils time = new DateTimeUtils();
	String createTime = time.getCurrentTime("yyyy-MM-dd HH:mm:ss");
	if(user != null){
		createUserName = user.getUserName();
		createUserId  = user.getUserId();
				
	}
	String inpatient = request.getParameter("inpatient");
	String patname = request.getParameter("patname");
	String diswardcode = request.getParameter("diswardcode");
	String sex = request.getParameter("sex");
	String marrycode = request.getParameter("marrycode");
	String birthday = request.getParameter("birthday");
	String credentialno = request.getParameter("credentialno");
	String linkname = request.getParameter("linkname");
	String linktelephone = request.getParameter("linktelephone");
	String linkvillage = request.getParameter("linkvillage");
	String admsdate = request.getParameter("admsdate");
	String admddate = request.getParameter("admddate");
	String attendingdesc = request.getParameter("attendingdesc");
	String diagnosedesc1 = request.getParameter("diagnosedesc1");
	String diagnosecode1 = request.getParameter("diagnosecode1");
	String tempName = request.getParameter("tempName");
	String tid = request.getParameter("tid");
	String deptCode = request.getParameter("deptCode");
	String num = request.getParameter("num");
	String visitDate = request.getParameter("date").substring(0, 10);
	String state = "sf00";//待随访
	AjaxJson j = new AjaxJson();
	try {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("patname", patname);
		conditionMap.put("inpatient", inpatient);
		conditionMap.put("sex", sex);
		conditionMap.put("marrycode", marrycode);
		conditionMap.put("birthday", birthday);
		conditionMap.put("linkvillage",linkvillage);
		conditionMap.put("diswardcode", diswardcode);
		conditionMap.put("diagnosedesc1", diagnosedesc1);
		conditionMap.put("diagnosecode1", diagnosecode1);
		conditionMap.put("admsdate", admsdate);
		conditionMap.put("admddate", admddate);
		conditionMap.put("credentialno", credentialno);
		conditionMap.put("linkname", linkname);
		conditionMap.put("linktelephone", linktelephone);
		conditionMap.put("attendingdesc", attendingdesc);
		conditionMap.put("tempName", tempName);
		conditionMap.put("deptCode", deptCode);
		conditionMap.put("tid", tid);
		conditionMap.put("num", num);
		conditionMap.put("visitDate", visitDate);
		conditionMap.put("state", state);
		conditionMap.put("createUserName", createUserName);
		conditionMap.put("createUserId", createUserId);
		conditionMap.put("createTime", createTime);
		zyEmrBasyService.insertMap(conditionMap);
		//zyEmrBasyService.doAddVisit(zyEmrBasy);
		j.setMsg("保存成功");
	} catch (Exception e) {
		System.out.println(e);
		j.setSuccess(false);
		j.setMsg("保存失败");
	}
	return j;
}

//添加群组
@RequestMapping(value = "/doAddGroup",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doAddGroup(HttpServletResponse response,HttpServletRequest request)throws Exception{
	//ZyEmrBasy zyEmrBasy = zyEmrBasyService.queryById(id);
	LoginUserNew user = (LoginUserNew) request.getSession().getAttribute("LOGIN_USER");
	String groupCreateUserId = "";
	DateTimeUtils time = new DateTimeUtils();
	String createTime = time.getCurrentTime("yyyy-MM-dd HH:mm:ss");
	if(user != null){
		groupCreateUserId  = user.getUserId();
	}
	String inpatient = request.getParameter("inpatient");
	String gid = request.getParameter("gid");
	AjaxJson j = new AjaxJson();
	try {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("gid", gid);
		conditionMap.put("inpatient", inpatient);
		conditionMap.put("groupCreateUserId", groupCreateUserId);
		conditionMap.put("createTime", createTime);
		List<PvGroupPatient> list = zyEmrBasyService.queryGroupMap(conditionMap);
		if(list.size()>0){
			j.setSuccess(false);
			j.setMsg("添加失败，此病人已经在该群组中！");
		}else{
			zyEmrBasyService.insertGroupMap(conditionMap);
			j.setMsg("添加成功");
		}
		
	} catch (Exception e) {
		System.out.println(e);
		j.setSuccess(false);
		j.setMsg("添加失败");
	}
	return j;
}

/**
 * 跳转到编辑页面
 * @return
 */
@RequestMapping(value="toEdit",method = RequestMethod.GET)
public void toEdit(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 ZyEmrBasy zyEmrBasy = zyEmrBasyService.queryById(id);
		 velocityContext.put("zyEmrBasy",zyEmrBasy);
		 String viewName = "patient/back/zyEmrBasy-edit.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 编辑
 * @return
 */
@RequestMapping(value = "/doEdit",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doEdit(@ModelAttribute ZyEmrBasy zyEmrBasy){
	AjaxJson j = new AjaxJson();
	try {
		zyEmrBasyService.doEdit(zyEmrBasy);
		j.setMsg("编辑成功");
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
@RequestMapping(value="doDelete",method = RequestMethod.GET)
@ResponseBody
public AjaxJson doDelete(@RequestParam(required = true, value = "id" ) String id){
		AjaxJson j = new AjaxJson();
		try {
			zyEmrBasyService.doDelete(id);
			j.setMsg("删除成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("删除失败");
		}
		return j;
}


}

