package com.mandala.visitManager.service;

import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import com.mandala.visitManager.entity.PvPlan;

/**
 * 描述：</b>PvPlanService<br>
 * @author：zhangliang
 * @since：2018年03月09日 11时28分50秒 星期五 
 * @version:1.0
 */
public interface PvPlanService {
	
	
	public void doAdd(PvPlan pvPlan);
	
	public void doEdit(PvPlan pvPlan);
	
	public void doDelete(String id);
	
	public PvPlan queryById(String id);
	
	public PageList<PvPlan> queryPageList(PageQuery<PvPlan> pageQuery);
}

