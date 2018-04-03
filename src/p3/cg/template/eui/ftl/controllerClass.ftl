package ${controllerPackage};

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import net.sf.json.JsonConfig;
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
import org.jeecgframework.p3.core.util.UUIDGenerator;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import ${domainPackage}.${className};
import ${servicePackage}.${className}Service;
import org.jeecgframework.p3.core.web.BaseController;
import com.mandala.util.JsonDateValueProcessor;

 /**
 * 描述：</b>${className}Controller<br>${codeName}
 * @author ${author}
 * @since：${nowDate}
 * @version:1.0
 */
@Controller
@RequestMapping("/${bussPackage}/back/${lowerName}")
public class ${className}Controller extends BaseController{
  @Autowired
  private ${className}Service ${lowerName}Service;
  
  				<#assign columnName="" >	
				<#assign domainPropertyName="" >	
				<#list columnDatas as item> 
						<#if item.columnKey =='PRI' >
							<#assign columnName="${item.columnName}" >
							<#assign domainPropertyName="${item.domainPropertyName}" >
						</#if> 
				</#list>
/**
  * 列表页面
  * @return
  */
@RequestMapping(value="list",method = {RequestMethod.GET,RequestMethod.POST})
public void list(@ModelAttribute ${className} query,HttpServletResponse response,HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
	 	PageQuery<${className}> pageQuery = new PageQuery<${className}>();
	 	pageQuery.setPageNo(pageNo);
	 	pageQuery.setPageSize(pageSize);
	 	VelocityContext velocityContext = new VelocityContext();
		pageQuery.setQuery(query);
		net.sf.json.JSONObject queryForm =new net.sf.json.JSONObject();
				JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		velocityContext.put("${lowerName}",queryForm.fromObject(query,jsonConfig).toString());
		velocityContext.put("pageInfos",SystemTools.convertPaginatedList(${lowerName}Service.queryPageList(pageQuery)));
		String viewName = "${bussPackage}/back/${lowerName}-list.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
}


@RequestMapping(value="getList",method = {RequestMethod.GET,RequestMethod.POST})
@ResponseBody
public String  getList(@ModelAttribute ${className} query,HttpServletResponse response,HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
	 	PageQuery<${className}> pageQuery = new PageQuery<${className}>();
	 	pageQuery.setPageNo(pageNo);
	 	pageQuery.setPageSize(pageSize);
	 	VelocityContext velocityContext = new VelocityContext();
		pageQuery.setQuery(query);
		net.sf.json.JSONArray dataArr = new net.sf.json.JSONArray();
		net.sf.json.JSONObject dataobj = new net.sf.json.JSONObject();
						JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		PageList<${className}> pl = ${lowerName}Service.queryPageList(pageQuery);
		dataobj.put("result", true);
		dataobj.put("data", dataArr.fromObject(pl.getValues(),jsonConfig));
		dataobj.put("total", SystemTools.convertPaginatedList(pl).getTotalItem()); 
		dataobj.put("pageSize", pageSize);
		dataobj.put("pageNo", pageNo);
		return dataobj.toString();
}

 /**
  * 详情
  * @return
  */
@RequestMapping(value="toDetail",method = RequestMethod.GET)
public void ${lowerName}Detail(@RequestParam(required = true, value = "${domainPropertyName}" ) String ${domainPropertyName},HttpServletResponse response,HttpServletRequest request)throws Exception{
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "${bussPackage}/back/${lowerName}-detail.vm";
		${className} ${lowerName} = ${lowerName}Service.queryById(${domainPropertyName});
		velocityContext.put("${lowerName}",${lowerName});
		ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 跳转到添加页面
 * @return
 */
@RequestMapping(value = "/toAdd",method ={RequestMethod.GET, RequestMethod.POST})
public void toAddDialog(HttpServletRequest request,HttpServletResponse response,ModelMap model)throws Exception{
	 VelocityContext velocityContext = new VelocityContext();
	 String viewName = "${bussPackage}/back/${lowerName}-add.vm";
	 ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 保存信息
 * @return
 */
@RequestMapping(value = "/doAdd",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doAdd(@ModelAttribute ${className} ${lowerName}){
	AjaxJson j = new AjaxJson();
	try {
		//${lowerName}.setId(UUIDGenerator.generate());
		${lowerName}Service.doAdd(${lowerName});
				net.sf.json.JSONObject dataobj = new net.sf.json.JSONObject();
						JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		j.setObj(dataobj.fromObject(${lowerName},jsonConfig));
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
public void toEdit(@RequestParam(required = true, value = "${domainPropertyName}" ) String ${domainPropertyName},HttpServletResponse response,HttpServletRequest request) throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 ${className} ${lowerName} = ${lowerName}Service.queryById(${domainPropertyName});
		 velocityContext.put("${lowerName}",${lowerName});
		 String viewName = "${bussPackage}/back/${lowerName}-edit.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 编辑
 * @return
 */
@RequestMapping(value = "/doEdit",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doEdit(@ModelAttribute ${className} ${lowerName}){
	AjaxJson j = new AjaxJson();
	try {
		${lowerName}Service.doEdit(${lowerName});
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
public AjaxJson doDelete(@RequestParam(required = true, value = "${domainPropertyName}" ) String ${domainPropertyName}){
		AjaxJson j = new AjaxJson();
		try {
			${lowerName}Service.doDelete(${domainPropertyName});
			j.setMsg("删除成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("删除失败");
		}
		return j;
}


}

