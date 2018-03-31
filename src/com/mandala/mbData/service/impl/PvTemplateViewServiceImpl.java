package com.mandala.mbData.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;
import com.mandala.mbData.service.PvTemplateViewService;
import com.mandala.mbData.entity.PvTemplateView;
import com.mandala.mbData.dao.PvTemplateViewDao;

@Service("pvTemplateViewService")
public class PvTemplateViewServiceImpl implements PvTemplateViewService {
	@Resource
	private PvTemplateViewDao pvTemplateViewDao;

	@Override
	public void doAdd(PvTemplateView pvTemplateView) {
		pvTemplateViewDao.add(pvTemplateView);
	}

	@Override
	public void doEdit(PvTemplateView pvTemplateView) {
		pvTemplateViewDao.update(pvTemplateView);
	}

	@Override
	public void doDelete(String id) {
		pvTemplateViewDao.delete(id);
	}

	@Override
	public PvTemplateView queryById(String id) {
		PvTemplateView pvTemplateView  = pvTemplateViewDao.get(id);
		return pvTemplateView;
	}

	@Override
	public PageList<PvTemplateView> queryPageList(
		PageQuery<PvTemplateView> pageQuery) {
		PageList<PvTemplateView> result = new PageList<PvTemplateView>();
		Integer itemCount = pvTemplateViewDao.count(pageQuery);
		List<PvTemplateView> list = pvTemplateViewDao.queryPageList(pageQuery,itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}

	@Override
	public List<PvTemplateView> queryList(PvTemplateView pvTemplateView) {
		List<PvTemplateView> list = pvTemplateViewDao.queryList(pvTemplateView);
		return list;
	}
	
}
