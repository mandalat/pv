package com.mandala.visitManager.dao;

import java.util.List;

import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.persistence.GenericDao;

import com.mandala.visitManager.entity.PvPlan;

/**
 * 描述：</b>PvPlanDao<br>
 * @author：zhangliang
 * @since：2018年03月09日 11时28分50秒 星期五 
 * @version:1.0
 */
public interface PvPlanDao extends GenericDao<PvPlan>{
	
	public Integer count(PageQuery<PvPlan> pageQuery);
	
	public List<PvPlan> queryPageList(PageQuery<PvPlan> pageQuery,Integer itemCount);
	
}

