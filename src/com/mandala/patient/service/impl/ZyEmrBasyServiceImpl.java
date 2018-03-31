package com.mandala.patient.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;
import com.mandala.patient.service.ZyEmrBasyService;
import com.mandala.visitRecord.entity.PvRecord;
import com.mandala.patient.entity.ZyEmrBasy;
import com.mandala.groupPatient.entity.PvGroupPatient;
import com.mandala.patient.dao.ZyEmrBasyDao;

@Service("zyEmrBasyService")
public class ZyEmrBasyServiceImpl implements ZyEmrBasyService {
	@Resource
	private ZyEmrBasyDao zyEmrBasyDao;

	@Override
	public void doAdd(ZyEmrBasy zyEmrBasy) {
		zyEmrBasyDao.add(zyEmrBasy);
	}

	@Override
	public void doEdit(ZyEmrBasy zyEmrBasy) {
		zyEmrBasyDao.update(zyEmrBasy);
	}

	@Override
	public void doDelete(String id) {
		zyEmrBasyDao.delete(id);
	}

	@Override
	public ZyEmrBasy queryById(String id) {
		ZyEmrBasy zyEmrBasy  = (ZyEmrBasy) zyEmrBasyDao.queryById(id);
		return zyEmrBasy;
		
	}

	@Override
	public PageList<ZyEmrBasy> queryPageList(
		PageQuery<ZyEmrBasy> pageQuery) {
		PageList<ZyEmrBasy> result = new PageList<ZyEmrBasy>();
		Integer itemCount = zyEmrBasyDao.count(pageQuery);
		List<ZyEmrBasy> list = zyEmrBasyDao.queryPageList(pageQuery,itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}
	
	@Override
	public PageList<ZyEmrBasy> queryPatient(
		PageQuery<ZyEmrBasy> pageQuery) {
		PageList<ZyEmrBasy> result = new PageList<ZyEmrBasy>();
		Integer itemCount = zyEmrBasyDao.count(pageQuery);
		List<ZyEmrBasy> list = zyEmrBasyDao.queryPatient(pageQuery,itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}

	@Override
	public List<ZyEmrBasy> queryByNameAndZyh(String patname, String visitno) {
		List<ZyEmrBasy> zyEmrBasy  = (List<ZyEmrBasy>) zyEmrBasyDao.queryByNameAndZyh(patname,visitno);
		return zyEmrBasy;
	}

	@Override
	public void doAddVisit(ZyEmrBasy zyEmrBasy) {
		zyEmrBasyDao.addVisit(zyEmrBasy);
		
	}

	@Override
	public PvRecord insertMap(Map<String, Object> conditionMap) {
		PvRecord pvRecord = zyEmrBasyDao.insertMap(conditionMap);
		return pvRecord;
	}

	@Override
	public PvGroupPatient insertGroupMap(Map<String, Object> conditionMap) {
		PvGroupPatient pvGroupPatient = zyEmrBasyDao.insertGroupMap(conditionMap);
		return pvGroupPatient;
	}

	@Override
	public List<PvGroupPatient> queryGroupMap(Map<String, Object> conditionMap) {
		List<PvGroupPatient> pvGroupPatientList = (List<PvGroupPatient>) zyEmrBasyDao.queryGroupMap(conditionMap);
		return pvGroupPatientList;
	}

	
	
}
