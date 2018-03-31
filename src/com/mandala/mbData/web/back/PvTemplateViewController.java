package com.mandala.mbData.web.back;

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

import com.mandala.dictinfo.entity.Dictinfo;
import com.mandala.dictinfo.service.DictinfoService;
import com.mandala.mbData.entity.PvTemplateView;
import com.mandala.mbData.service.PvTemplateViewService;
import com.mandala.system.vo.LoginUserNew;

import org.jeecgframework.p3.core.web.BaseController;

 /**
 * 描述：</b>PvTemplateViewController<br>
 * @author zhangliang
 * @since：2018年03月19日 11时50分39秒 星期一 
 * @version:1.0
 */
@Controller
@RequestMapping("/mbData/back/pvTemplateView")
public class PvTemplateViewController extends BaseController{
  @Autowired
  private PvTemplateViewService pvTemplateViewService;
  @Autowired
  private DictinfoService dictinfoService;
  
/**
  * 列表页面
  * @return
  */
@RequestMapping(value="list",method = {RequestMethod.GET,RequestMethod.POST})
public void list(@ModelAttribute PvTemplateView query,HttpServletResponse response,HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
	 	PageQuery<PvTemplateView> pageQuery = new PageQuery<PvTemplateView>();
	 	pageQuery.setPageNo(pageNo);
	 	pageQuery.setPageSize(pageSize);
	 	VelocityContext velocityContext = new VelocityContext();
		pageQuery.setQuery(query);
		//获取科室
		Dictinfo dic = new Dictinfo();
		dic.setTypeid("402881be6222014e016222014e500000");
		List<Dictinfo> deptList = dictinfoService.queryList(dic);
		 velocityContext.put("deptListInfos",  deptList );
		velocityContext.put("pvTemplateView",query);
		velocityContext.put("pageInfos",SystemTools.convertPaginatedList(pvTemplateViewService.queryPageList(pageQuery)));
		String viewName = "mbData/back/pvTemplateView-list.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
}

 /**
  * 详情
  * @return
  */
@RequestMapping(value="toDetail",method = RequestMethod.GET)
public void pvTemplateViewDetail(@RequestParam(required = true, value = "tid" ) String tid,HttpServletResponse response,HttpServletRequest request)throws Exception{
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "mbData/back/pvTemplateView-detail.vm";
		PvTemplateView pvTemplateView = pvTemplateViewService.queryById(tid);
		velocityContext.put("pvTemplateView",pvTemplateView);
		ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 跳转到添加页面
 * @return
 */
@RequestMapping(value = "/toAdd",method ={RequestMethod.GET, RequestMethod.POST})
public void toAddDialog(HttpServletRequest request,HttpServletResponse response,ModelMap model)throws Exception{
	 VelocityContext velocityContext = new VelocityContext();
	 String viewName = "mbData/back/pvTemplateView-add.vm";
		//获取科室
		Dictinfo dic = new Dictinfo();
		dic.setTypeid("402881be6222014e016222014e500000");
		List<Dictinfo> deptList = dictinfoService.queryList(dic);
		 velocityContext.put("deptListInfos",  deptList );
	 ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 保存信息
 * @return
 */
@RequestMapping(value = "/doAdd",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doAdd(@ModelAttribute PvTemplateView pvTemplateView,HttpServletRequest request){
	AjaxJson j = new AjaxJson();
	LoginUserNew user = (LoginUserNew)request.getSession().getAttribute("LOGIN_USER");
	try {
		if(null != user){
			pvTemplateView.setTempCreatetiime(new Date()); 
			pvTemplateView.setTempCreateUserid(user.getUserId()); 
			pvTemplateView.setTid(UUIDGenerator.generate());
			pvTemplateViewService.doAdd(pvTemplateView);
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
public void toEdit(@RequestParam(required = true, value = "tid" ) String tid,HttpServletResponse response,HttpServletRequest request) throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 PvTemplateView pvTemplateView = pvTemplateViewService.queryById(tid);
			//获取科室
			Dictinfo dic = new Dictinfo();
			dic.setTypeid("402881be6222014e016222014e500000");
			List<Dictinfo> deptList = dictinfoService.queryList(dic);
			 velocityContext.put("deptListInfos",  deptList );
		 velocityContext.put("pvTemplateView",pvTemplateView);
		 String viewName = "mbData/back/pvTemplateView-edit.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 编辑
 * @return
 */
@RequestMapping(value = "/doEdit",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doEdit(@ModelAttribute PvTemplateView pvTemplateView,HttpServletRequest request){
	
	AjaxJson j = new AjaxJson();
	LoginUserNew user = (LoginUserNew)request.getSession().getAttribute("LOGIN_USER");
	try {
		if(null != user){
			pvTemplateView.setTempUpdatetime(new Date()); 
			pvTemplateView.setTempUpdateUserid(user.getUserId()); 
			pvTemplateViewService.doEdit(pvTemplateView);
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
public AjaxJson doDelete(@RequestParam(required = true, value = "tid" ) String tid){
		AjaxJson j = new AjaxJson();
		try {
			pvTemplateViewService.doDelete(tid);
			j.setMsg("删除成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("删除失败");
		}
		return j;
}


}

