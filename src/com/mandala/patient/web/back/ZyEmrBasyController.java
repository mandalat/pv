package com.mandala.patient.web.back;

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
import com.mandala.patient.entity.ZyEmrBasy;
import com.mandala.patient.service.ZyEmrBasyService;
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
	 	if(query.getAdmdward() == null || query.getAdmdward() =="" ){
	 		query.setAdmdward("W15胸外科");
	 	}
	 	if(query.getAdmsdate() == null || query.getAdmsdate() =="" ){
	 		query.setAdmsdate("2018-02-09");
	 		query.setAdmsdate2("2018-03-09");
	 	}
	 	
		pageQuery.setQuery(query);
		velocityContext.put("zyEmrBasy",query);
		velocityContext.put("pageInfos",SystemTools.convertPaginatedList(zyEmrBasyService.queryPageList(pageQuery)));
		String viewName = "patient/back/zyEmrBasy-list.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
}

@RequestMapping(value="patientInfo",method = {RequestMethod.GET,RequestMethod.POST})
public void patientInfo(@ModelAttribute ZyEmrBasy query,HttpServletResponse response,HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
	 	PageQuery<ZyEmrBasy> pageQuery = new PageQuery<ZyEmrBasy>();
	 	pageQuery.setPageNo(pageNo);
	 	pageQuery.setPageSize(pageSize);
	 	VelocityContext velocityContext = new VelocityContext();
	 	if(query.getPatname()== null|| query.getPatname()==""){
	 		query.setPatname("丁光辉");
	 		query.setInpatient("1914444");
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

