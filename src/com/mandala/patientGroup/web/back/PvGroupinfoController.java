package com.mandala.patientGroup.web.back;
 
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
import org.jeecgframework.p3.core.utils.common.PageQuery;

import com.mandala.mbData.entity.PvTemplateView;
import com.mandala.mbData.service.PvTemplateViewService;
import com.mandala.patientGroup.entity.PvGroupinfo;
import com.mandala.patientGroup.service.PvGroupinfoService;
import com.mandala.system.vo.LoginUserNew;

import org.jeecgframework.p3.core.web.BaseController;

 /**
 * 描述：</b>PvGroupinfoController<br>
 * @author huachao
 * @since：2018年03月21日 14时37分24秒 星期三 
 * @version:1.0
 */
@Controller
@RequestMapping("/patientGroup/back/pvGroupinfo")
public class PvGroupinfoController extends BaseController{
  @Autowired
  private PvGroupinfoService pvGroupinfoService;
  
  @Autowired
  private PvTemplateViewService pvTemplateViewService;
  
/**
  * 列表页面
  * @return
  */
@RequestMapping(value="list",method = {RequestMethod.GET,RequestMethod.POST})
public void list(@ModelAttribute PvGroupinfo query,HttpServletResponse response,HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
	
	PageQuery<PvGroupinfo> pageQuery = new PageQuery<PvGroupinfo>();
 	pageQuery.setPageNo(pageNo);
 	pageQuery.setPageSize(pageSize);
 	VelocityContext velocityContext = new VelocityContext();
 	query.setGroupStatus("1");
	pageQuery.setQuery(query);
	velocityContext.put("pvGroupinfo",query);
	velocityContext.put("pageInfos",SystemTools.convertPaginatedList(pvGroupinfoService.queryPageList(pageQuery)));
	PvTemplateView template = new PvTemplateView();
	List<PvTemplateView> templateList =  pvTemplateViewService.queryList(template);
	net.sf.json.JSONArray templateArr = new net.sf.json.JSONArray();
	velocityContext.put("templateList",templateArr.fromObject(templateList).toString());
	String viewName = "patientGroup/back/pvGroupinfo-list.vm";
	ViewVelocity.view(request,response,viewName,velocityContext);
	 	
}



@RequestMapping(value="groupIndex",method = {RequestMethod.GET,RequestMethod.POST})
public void groupIndex(@ModelAttribute PvGroupinfo query,HttpServletResponse response,HttpServletRequest request ) throws Exception{
	LoginUserNew user = (LoginUserNew)request.getSession().getAttribute("LOGIN_USER");
	if(null != user){
		if(user.getLoginType().equals("0")){
		 	//如果当前用户是医生
		 	query.setGroupCreateUserid(user.getUserId());;
		}
		if(user.getLoginType().equals("1")){
		 	//如果当前用户是病人
		 	query.setGroupCreateUserid("null");
		}
	}
 	VelocityContext velocityContext = new VelocityContext();
 	query.setGroupStatus("1");
 	List<PvGroupinfo> groupList = pvGroupinfoService.queryList(query);
	velocityContext.put("pvGroupinfo",query);
	PvTemplateView template = new PvTemplateView();
	List<PvTemplateView> templateList =  pvTemplateViewService.queryList(template);
	net.sf.json.JSONArray templateArr = new net.sf.json.JSONArray();
	velocityContext.put("templateList",templateArr.fromObject(templateList).toString());
	velocityContext.put("pageInfos",templateArr.fromObject(groupList).toString());
	String viewName = "patientGroup/back/pvGroupinfo-list.vm";
	ViewVelocity.view(request,response,viewName,velocityContext);
	 	
}
 
 /**
  * 详情
  * @return
  */
@RequestMapping(value="toDetail",method = RequestMethod.GET)
public void pvGroupinfoDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "patientGroup/back/pvGroupinfo-detail.vm";
		PvGroupinfo pvGroupinfo = pvGroupinfoService.queryById(id);
		velocityContext.put("pvGroupinfo",pvGroupinfo);
		ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 跳转到添加页面
 * @return
 */
@RequestMapping(value = "/toAdd",method ={RequestMethod.GET, RequestMethod.POST})
public void toAddDialog(HttpServletRequest request,HttpServletResponse response,ModelMap model)throws Exception{
	 VelocityContext velocityContext = new VelocityContext();
	 String viewName = "patientGroup/back/pvGroupinfo-add.vm";
	 ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 保存信息
 * @return
 */
@RequestMapping(value = "/doAdd",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doAdd(HttpServletRequest request,@ModelAttribute PvGroupinfo pvGroupinfo){
	AjaxJson j = new AjaxJson();
	LoginUserNew user = (LoginUserNew)request.getSession().getAttribute("LOGIN_USER");

	try {
		pvGroupinfo.setGid(UUIDGenerator.generate());
		pvGroupinfo.setGroupStatus("1");
		pvGroupinfo.setGroupCreatetime(new Date());
		
		if(null != user){
			if(user.getLoginType().equals("0")){
			 	//如果当前用户是医生
				pvGroupinfo.setGroupCreateUserid(user.getUserId());
				pvGroupinfoService.doAdd(pvGroupinfo);
				j.setMsg("保存成功");
				j.setObj(pvGroupinfo);
			}else{
				j.setSuccess(false);
				j.setMsg("保存失败");
			}
		}else{
			j.setSuccess(false);
			j.setMsg("保存失败");
		}

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
		 PvGroupinfo pvGroupinfo = pvGroupinfoService.queryById(id);
		 velocityContext.put("pvGroupinfo",pvGroupinfo);
		 String viewName = "patientGroup/back/pvGroupinfo-edit.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 编辑
 * @return
 */
@RequestMapping(value = "/doEdit",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doEdit(@ModelAttribute PvGroupinfo pvGroupinfo,HttpServletRequest request){
	AjaxJson j = new AjaxJson();
	LoginUserNew user = (LoginUserNew)request.getSession().getAttribute("LOGIN_USER");
	try {
		if(null != user){
			pvGroupinfo.setGroupUpdatetime(new Date());
			pvGroupinfo.setGroupUpdateUserid(user.getUserId());
			pvGroupinfoService.doEdit(pvGroupinfo);
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
@RequestMapping(value="doDelete",method = RequestMethod.GET)
@ResponseBody
public AjaxJson doDelete(@RequestParam(required = true, value = "id" ) String id){
		AjaxJson j = new AjaxJson();
		try {
			pvGroupinfoService.doDelete(id);
			j.setMsg("删除成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("删除失败");
		}
		return j;
}


}

