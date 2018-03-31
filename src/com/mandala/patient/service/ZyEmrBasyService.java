package com.mandala.patient.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;

import com.mandala.groupPatient.entity.PvGroupPatient;
import com.mandala.patient.entity.ZyEmrBasy;
import com.mandala.visitRecord.entity.PvRecord;

/**
 * 描述：</b>ZyEmrBasyService<br>
 * @author：zhangliang
 * @since：2018年03月08日 17时48分09秒 星期四 
 * @version:1.0
 */
public interface ZyEmrBasyService {
	
	
	public void doAdd(ZyEmrBasy zyEmrBasy);
	
	public void doEdit(ZyEmrBasy zyEmrBasy);
	
	public void doDelete(String id);
	
	public ZyEmrBasy queryById(String id);
	
	public List<ZyEmrBasy> queryByNameAndZyh(String patname, String visitno);
	
	public PageList<ZyEmrBasy> queryPageList(PageQuery<ZyEmrBasy> pageQuery);
	
	public PageList<ZyEmrBasy> queryPatient(PageQuery<ZyEmrBasy> pageQuery);
	
	public void doAddVisit(ZyEmrBasy zyEmrBasy);
	
	public PvRecord insertMap(Map<String, Object> conditionMap);
	
	public PvGroupPatient insertGroupMap(Map<String, Object> conditionMap);
	
	public List<PvGroupPatient> queryGroupMap(Map<String, Object> conditionMap);
}

