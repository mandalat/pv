package com.mandala.visitManager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;
import com.mandala.visitManager.service.PvPlanService;
import com.mandala.visitManager.entity.PvPlan;
import com.mandala.visitManager.dao.PvPlanDao;

@Service("pvPlanService")
public class PvPlanServiceImpl implements PvPlanService {
	@Resource
	private PvPlanDao pvPlanDao;

	@Override
	public void doAdd(PvPlan pvPlan) {
		pvPlanDao.add(pvPlan);
	}

	@Override
	public void doEdit(PvPlan pvPlan) {
		pvPlanDao.update(pvPlan);
	}

	@Override
	public void doDelete(String id) {
		pvPlanDao.delete(id);
	}

	@Override
	public PvPlan queryById(String id) {
		PvPlan pvPlan  = pvPlanDao.get(id);
		return pvPlan;
	}

	@Override
	public PageList<PvPlan> queryPageList(
		PageQuery<PvPlan> pageQuery) {
		PageList<PvPlan> result = new PageList<PvPlan>();
		Integer itemCount = pvPlanDao.count(pageQuery);
		List<PvPlan> list = pvPlanDao.queryPageList(pageQuery,itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}
	
}
