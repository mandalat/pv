package com.mandala.groupPatient.web.back;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import org.jeecgframework.p3.core.utils.common.PageQuery;

import com.mandala.groupPatient.entity.PvGroupPatient;
import com.mandala.groupPatient.entity.PvGroupPatientInfo;
import com.mandala.groupPatient.service.PvGroupPatientService;
import com.mandala.system.vo.LoginUserNew;
import com.mandala.visitRecord.entity.PvRecord;
import com.mandala.visitRecord.service.PvRecordService;

import org.jeecgframework.p3.core.web.BaseController;

 /**
 * 描述：</b>PvGroupPatientController<br>
 * @author huachao
 * @since：2018年03月21日 14时39分55秒 星期三 
 * @version:1.0
 */
@Controller
@RequestMapping("/groupPatient/back/pvGroupPatient")
public class PvGroupPatientController extends BaseController{
  @Autowired
  private PvGroupPatientService pvGroupPatientService;
  
  @Autowired
  private PvRecordService pvRecordService;
  
/**
  * 列表页面
  * @return
  */
@RequestMapping(value="list",method = {RequestMethod.GET,RequestMethod.POST})
public void list(@ModelAttribute PvGroupPatient query,HttpServletResponse response,HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
	 	PageQuery<PvGroupPatient> pageQuery = new PageQuery<PvGroupPatient>();
	 	pageQuery.setPageNo(pageNo);
	 	pageQuery.setPageSize(pageSize);
	 	VelocityContext velocityContext = new VelocityContext();
		pageQuery.setQuery(query);
		velocityContext.put("pvGroupPatient",query);
		velocityContext.put("pageInfos",SystemTools.convertPaginatedList(pvGroupPatientService.queryPageList(pageQuery)));
		String viewName = "groupPatient/back/pvGroupPatient-list.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
}

@RequestMapping(value="/getPatientByGroup",method={RequestMethod.GET,RequestMethod.POST}) 
@ResponseBody
public String getPatientByGroup(@ModelAttribute PvGroupPatientInfo query,HttpServletResponse response,HttpServletRequest request)throws Exception{

	LoginUserNew user = (LoginUserNew)request.getSession().getAttribute("LOGIN_USER");
	if(null !=user && user.getLoginType().equals("0") ){
		query.setGpCreateUserid(user.getUserId());
	}else{
		query.setGpCreateUserid("");
	}
	net.sf.json.JSONArray templateArr = new net.sf.json.JSONArray();
	net.sf.json.JSONObject dataobj = new net.sf.json.JSONObject();
	dataobj.put("result", true);
	dataobj.put("data", templateArr.fromObject(pvGroupPatientService.queryPatientByGroup(query))); 
	return dataobj.toString();
}

 /**
  * 详情
  * @return
  */
@RequestMapping(value="toDetail",method = RequestMethod.GET)
public void pvGroupPatientDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "groupPatient/back/pvGroupPatient-detail.vm";
		PvGroupPatient pvGroupPatient = pvGroupPatientService.queryById(id);
		velocityContext.put("pvGroupPatient",pvGroupPatient);
		ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 跳转到添加页面
 * @return
 */
@RequestMapping(value = "/toAdd",method ={RequestMethod.GET, RequestMethod.POST})
public void toAddDialog(HttpServletRequest request,HttpServletResponse response,ModelMap model)throws Exception{
	 VelocityContext velocityContext = new VelocityContext();
	 String viewName = "groupPatient/back/pvGroupPatient-add.vm";
	 ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 保存信息
 * @return
 */
@RequestMapping(value = "/doAdd",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doAdd(@ModelAttribute PvGroupPatient pvGroupPatient,HttpServletRequest request){
	LoginUserNew user = (LoginUserNew)request.getSession().getAttribute("LOGIN_USER");
	AjaxJson j = new AjaxJson();
	if(null ==user || !user.getLoginType().equals("0")){
		j.setSuccess(false);
		j.setMsg("保存失败");
		return j;
	}
	try {
		pvGroupPatient.setGpCreateUserid(user.getUserId());
		pvGroupPatientService.doAdd(pvGroupPatient);
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
public void toEdit(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 PvGroupPatient pvGroupPatient = pvGroupPatientService.queryById(id);
		 velocityContext.put("pvGroupPatient",pvGroupPatient);
		 String viewName = "groupPatient/back/pvGroupPatient-edit.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 编辑
 * @return
 */
@RequestMapping(value = "/doEdit",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doEdit(@ModelAttribute PvGroupPatient pvGroupPatient){
	AjaxJson j = new AjaxJson();
	try {
		pvGroupPatientService.doEdit(pvGroupPatient);
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
@RequestMapping(value="doDelete",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doDelete(@RequestParam(required = true, value = "gpid" ) String gpid,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		LoginUserNew user = (LoginUserNew)request.getSession().getAttribute("LOGIN_USER");
		if(null ==user || !user.getLoginType().equals("0")){
			j.setSuccess(false);
			j.setMsg("删除失败");
			return j;
		}
		PvGroupPatient ppi = new PvGroupPatient();
		ppi.setGpCreateUserid(user.getUserId());
		ppi.setGpid(gpid);
		try { 
			pvGroupPatientService.deleteByIdAndUser(ppi);
			j.setMsg("删除成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("删除失败");
		}
		return j;
}

@RequestMapping(value = "/doAddVisitBatch",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doAddVisitBatch(HttpServletResponse response,HttpServletRequest request)throws Exception{
	LoginUserNew user = (LoginUserNew)request.getSession().getAttribute("LOGIN_USER");
	AjaxJson j = new AjaxJson();
	if(null ==user){
		j.setSuccess(false);
		j.setMsg("保存失败");
		return j;
	}
	String pids = request.getParameter("patientIds");
	String admnos = request.getParameter("admnos");
	String num = request.getParameter("num");
	String visitDate = request.getParameter("date");
	String templateViewId =  request.getParameter("templateViewId");
	String tempName =  request.getParameter("templateName");
	String state = "sf00";//待随访
	String[] pidArr = pids.split(",");
	String[] admno = admnos.split(",");
	

	if(pidArr.length<=0){
		j.setSuccess(false);
		j.setMsg("保存失败");
	}else{
		for(int i=0;i<pidArr.length;i++){
			System.out.print(String.valueOf(pidArr[i]));
			try {
			PvGroupPatientInfo ppi = pvGroupPatientService.queryPatientAndMedic(String.valueOf(admno[i]),String.valueOf(pidArr[i]));
			PvRecord pr = new PvRecord();
			pr.setCreateTime(new Date());
			pr.setCreateUserId(user.getUserId());
			pr.setCreateUserName(user.getUserName());
			//根据医生 ID查询医生信息
			pr.setMedicId(ppi.getMedicId());
			pr.setMedicName(ppi.getMedicName());
			pr.setMedicPhone(ppi.getMedicPhone());
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			pr.setMustVisitDate(df.parse(visitDate.toString()) );
			pr.setPatientAddress(ppi.getLinkvillage());
			pr.setPatientBirthday(df.parse(ppi.getBirthday()) );
			pr.setPatientCardid(ppi.getCredentialno());
			pr.setPatientId(ppi.getPatientId());
			pr.setPatientIndate(df.parse(ppi.getAdmsdate()));
			pr.setPatientLinkman(ppi.getLinkname());
			pr.setPatientLinktel(ppi.getLinktelephone());
			pr.setPatientMainDoctor(ppi.getAttendingdesc());
			pr.setPatientMarriage(ppi.getMarrycode());
			pr.setPatientName(ppi.getPatname());
			pr.setPatientInDiagnose(ppi.getDiagnosedesc1());
			pr.setPatientOffice(ppi.getDiswardcode());
			pr.setPatientOutdate(df.parse(ppi.getAdmddate()));
			pr.setPatientOutDiagnose(ppi.getDiagnosedesc1());
			pr.setPatientSex(ppi.getSex());
			pr.setSubTemplateName(tempName);
			pr.setTemplateViewId(templateViewId);
			pr.setVisitOrder(Integer.parseInt(num));
			pr.setVisitStatus(state);
			pr.setPatientId(pidArr[i]);

				pr.setRid(UUIDGenerator.generate());
				pvRecordService.doAdd(pr);
				j.setMsg("保存成功");
			} catch (Exception e) {
				j.setSuccess(false);
				j.setMsg("保存失败");
			}
		}
	}
	return j;
}



}

