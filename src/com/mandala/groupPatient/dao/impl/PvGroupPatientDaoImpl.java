package com.mandala.groupPatient.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.PageQueryWrapper;
import org.jeecgframework.p3.core.utils.persistence.mybatis.GenericDaoDefault;
import org.springframework.stereotype.Repository;

import com.mandala.groupPatient.dao.PvGroupPatientDao;
import com.mandala.groupPatient.entity.PvGroupPatient;
import com.mandala.groupPatient.entity.PvGroupPatientInfo;

/**
 * 描述：</b>PvGroupPatientDaoImpl<br>
 * @author：huachao
 * @since：2018年03月21日 14时39分55秒 星期三 
 * @version:1.0
 */
@Repository("pvGroupPatientDao")
public class PvGroupPatientDaoImpl extends GenericDaoDefault<PvGroupPatient> implements PvGroupPatientDao{

	@Override
	public Integer count(PageQuery<PvGroupPatient> pageQuery) {
		return (Integer) super.queryOne("count",pageQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PvGroupPatient> queryPageList(
			PageQuery<PvGroupPatient> pageQuery,Integer itemCount) {
		PageQueryWrapper<PvGroupPatient> wrapper = new PageQueryWrapper<PvGroupPatient>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery());
		return (List<PvGroupPatient>)super.query("queryPageList",wrapper);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PvGroupPatientInfo> queryPatientByGroup(PvGroupPatientInfo query) {
		// TODO Auto-generated method stub
		return (List<PvGroupPatientInfo>)super.query("queryPatientByGroup",query);
	}

	@Override
	public PvGroupPatientInfo queryPatient(String patientId) {
		// TODO Auto-generated method stub
		return (PvGroupPatientInfo) super.queryOne("queryPatient",new HashMap<String, Object>().put("patientId", patientId));
	}

	@Override
	public PvGroupPatientInfo queryPatientAndMedic(String admno,String patientId) {
		// TODO Auto-generated method stub
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("patientId", patientId);
		conditionMap.put("admno", admno);
		return (PvGroupPatientInfo) super.queryOne("queryPatientAndMedic",conditionMap);
	}

	@Override
	public void deleteByIdAndUser(PvGroupPatient query) {
		// TODO Auto-generated method stub
		super.delete("deleteByIdAndUser", query);
	}


}

