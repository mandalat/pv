package com.mandala.visitManager.dao.impl;

import java.util.List;

import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.PageQueryWrapper;
import org.jeecgframework.p3.core.utils.persistence.mybatis.GenericDaoDefault;
import org.springframework.stereotype.Repository;
import com.mandala.visitManager.dao.PvPlanDao;
import com.mandala.visitManager.entity.PvPlan;

/**
 * 描述：</b>PvPlanDaoImpl<br>
 * @author：zhangliang
 * @since：2018年03月09日 11时28分50秒 星期五 
 * @version:1.0
 */
@Repository("pvPlanDao")
public class PvPlanDaoImpl extends GenericDaoDefault<PvPlan> implements PvPlanDao{

	@Override
	public Integer count(PageQuery<PvPlan> pageQuery) {
		return (Integer) super.queryOne("count",pageQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PvPlan> queryPageList(
			PageQuery<PvPlan> pageQuery,Integer itemCount) {
		PageQueryWrapper<PvPlan> wrapper = new PageQueryWrapper<PvPlan>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery());
		return (List<PvPlan>)super.query("queryPageList",wrapper);
	}


}

