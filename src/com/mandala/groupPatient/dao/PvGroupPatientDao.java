package com.mandala.groupPatient.dao;

import java.util.List;

import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.persistence.GenericDao;

import com.mandala.groupPatient.entity.PvGroupPatient;
import com.mandala.groupPatient.entity.PvGroupPatientInfo;

/**
 * 描述：</b>PvGroupPatientDao<br>
 * @author：huachao
 * @since：2018年03月21日 14时39分55秒 星期三 
 * @version:1.0
 */
public interface PvGroupPatientDao extends GenericDao<PvGroupPatient>{
	
	public Integer count(PageQuery<PvGroupPatient> pageQuery);
	
	public List<PvGroupPatient> queryPageList(PageQuery<PvGroupPatient> pageQuery,Integer itemCount);
	
	public List<PvGroupPatientInfo> queryPatientByGroup(PvGroupPatientInfo query);
	
	public PvGroupPatientInfo queryPatient(String patientId);
	
	public PvGroupPatientInfo queryPatientAndMedic(String admno,String patientId);
	
	public void deleteByIdAndUser(PvGroupPatient query);
	
	
}

