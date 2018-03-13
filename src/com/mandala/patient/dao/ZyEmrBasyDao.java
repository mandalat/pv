package com.mandala.patient.dao;

import java.util.List;

import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.persistence.GenericDao;

import com.mandala.patient.entity.ZyEmrBasy;

/**
 * 描述：</b>ZyEmrBasyDao<br>
 * @author：zhangliang
 * @since：2018年03月08日 17时48分09秒 星期四 
 * @version:1.0
 */
public interface ZyEmrBasyDao extends GenericDao<ZyEmrBasy>{
	
	public Integer count(PageQuery<ZyEmrBasy> pageQuery);
	
	public List<ZyEmrBasy> queryPageList(PageQuery<ZyEmrBasy> pageQuery,Integer itemCount);
	
	public List<ZyEmrBasy> queryPatient(PageQuery<ZyEmrBasy> pageQuery,Integer itemCount);
	
	public ZyEmrBasy queryByNameAndZyh(String patname,String visitno);
	
}

