package com.mandala.groupPatient.service;

import java.util.List;

import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;

import com.mandala.groupPatient.entity.PvGroupPatient;
import com.mandala.groupPatient.entity.PvGroupPatientInfo;

/**
 * 描述：</b>PvGroupPatientService<br>
 * @author：huachao
 * @since：2018年03月21日 14时39分55秒 星期三 
 * @version:1.0
 */
public interface PvGroupPatientService {
	
	
	public void doAdd(PvGroupPatient pvGroupPatient);
	
	public void doEdit(PvGroupPatient pvGroupPatient);
	
	public void doDelete(String id);
	
	public PvGroupPatient queryById(String id);
	
	public PageList<PvGroupPatient> queryPageList(PageQuery<PvGroupPatient> pageQuery);
	public List<PvGroupPatientInfo> queryPatientByGroup(PvGroupPatientInfo query);
	public PvGroupPatientInfo queryPatient(String patientId);
	
	public PvGroupPatientInfo queryPatientAndMedic(String admno,String patientId);
	public void deleteByIdAndUser(PvGroupPatient query);
}

