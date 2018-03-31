package com.mandala.groupPatient.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;

import com.mandala.groupPatient.service.PvGroupPatientService;
import com.mandala.groupPatient.entity.PvGroupPatient;
import com.mandala.groupPatient.entity.PvGroupPatientInfo;
import com.mandala.groupPatient.dao.PvGroupPatientDao;

@Service("pvGroupPatientService")
public class PvGroupPatientServiceImpl implements PvGroupPatientService {
	@Resource
	private PvGroupPatientDao pvGroupPatientDao;

	@Override
	public void doAdd(PvGroupPatient pvGroupPatient) {
		pvGroupPatientDao.add(pvGroupPatient);
	}

	@Override
	public void doEdit(PvGroupPatient pvGroupPatient) {
		pvGroupPatientDao.update(pvGroupPatient);
	}

	@Override
	public void doDelete(String id) {
		pvGroupPatientDao.delete(id);
	}

	@Override
	public PvGroupPatient queryById(String id) {
		PvGroupPatient pvGroupPatient  = pvGroupPatientDao.get(id);
		return pvGroupPatient;
	}

	@Override
	public PageList<PvGroupPatient> queryPageList(
		PageQuery<PvGroupPatient> pageQuery) {
		PageList<PvGroupPatient> result = new PageList<PvGroupPatient>();
		Integer itemCount = pvGroupPatientDao.count(pageQuery);
		List<PvGroupPatient> list = pvGroupPatientDao.queryPageList(pageQuery,itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}

	@Override
	public List<PvGroupPatientInfo> queryPatientByGroup(PvGroupPatientInfo query) {
		// TODO Auto-generated method stub
		return pvGroupPatientDao.queryPatientByGroup(query);
	}

	@Override
	public PvGroupPatientInfo queryPatient(String patientId) {
		// TODO Auto-generated method stub
		return pvGroupPatientDao.queryPatient(patientId);
	}

	@Override
	public PvGroupPatientInfo queryPatientAndMedic(String admno,String patientId) {
		// TODO Auto-generated method stub
		return pvGroupPatientDao.queryPatientAndMedic(admno,patientId);
	}

	@Override
	public void deleteByIdAndUser(PvGroupPatient query) {
		// TODO Auto-generated method stub
		pvGroupPatientDao.deleteByIdAndUser(query);
	}
	
}
