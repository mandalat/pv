package com.mandala.patientGroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;
import com.mandala.patientGroup.service.PvGroupinfoService;
import com.mandala.patientGroup.entity.PvGroupinfo;
import com.mandala.patientGroup.dao.PvGroupinfoDao;

@Service("pvGroupinfoService")
public class PvGroupinfoServiceImpl implements PvGroupinfoService {
	@Resource
	private PvGroupinfoDao pvGroupinfoDao;

	@Override
	public void doAdd(PvGroupinfo pvGroupinfo) {
		pvGroupinfoDao.add(pvGroupinfo);
	}

	@Override
	public void doEdit(PvGroupinfo pvGroupinfo) {
		pvGroupinfoDao.update(pvGroupinfo);
	}

	@Override
	public void doDelete(String id) {
		pvGroupinfoDao.delete(id);
	}

	@Override
	public PvGroupinfo queryById(String id) {
		PvGroupinfo pvGroupinfo  = pvGroupinfoDao.get(id);
		return pvGroupinfo;
	}

	@Override
	public PageList<PvGroupinfo> queryPageList(
		PageQuery<PvGroupinfo> pageQuery) {
		PageList<PvGroupinfo> result = new PageList<PvGroupinfo>();
		Integer itemCount = pvGroupinfoDao.count(pageQuery);
		List<PvGroupinfo> list = pvGroupinfoDao.queryPageList(pageQuery,itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}

	@Override
	public List<PvGroupinfo> queryList(PvGroupinfo query) {
		// TODO Auto-generated method stub
		return pvGroupinfoDao.queryList(query);
	}

	
}
