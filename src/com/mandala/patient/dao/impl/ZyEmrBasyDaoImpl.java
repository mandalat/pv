package com.mandala.patient.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.PageQueryWrapper;
import org.jeecgframework.p3.core.utils.persistence.mybatis.GenericDaoDefault;
import org.springframework.stereotype.Repository;
import com.mandala.patient.dao.ZyEmrBasyDao;
import com.mandala.patient.entity.ZyEmrBasy;

/**
 * 描述：</b>ZyEmrBasyDaoImpl<br>
 * @author：zhangliang
 * @since：2018年03月08日 17时48分09秒 星期四 
 * @version:1.0
 */
@Repository("zyEmrBasyDao")
public class ZyEmrBasyDaoImpl extends GenericDaoDefault<ZyEmrBasy> implements ZyEmrBasyDao{

	@Override
	public Integer count(PageQuery<ZyEmrBasy> pageQuery) {
		return (Integer) super.queryOne("count",pageQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ZyEmrBasy> queryPageList(
			PageQuery<ZyEmrBasy> pageQuery,Integer itemCount) {
		PageQueryWrapper<ZyEmrBasy> wrapper = new PageQueryWrapper<ZyEmrBasy>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery());
		return (List<ZyEmrBasy>)super.query("queryPageList",wrapper);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ZyEmrBasy> queryPatient(
			PageQuery<ZyEmrBasy> pageQuery,Integer itemCount) {
		PageQueryWrapper<ZyEmrBasy> wrapper = new PageQueryWrapper<ZyEmrBasy>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery());
		return (List<ZyEmrBasy>)super.query("queryPatient",wrapper);
	}

	@Override
	public ZyEmrBasy queryByNameAndZyh(@Param("patname") String patname, @Param("visitno") String visitno) {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("patname", patname);
		conditionMap.put("visitno", visitno);
		ZyEmrBasy zyEmrBasy = (ZyEmrBasy) super.queryOne("queryByNameAndZyh",conditionMap); 
		return zyEmrBasy; 
	}


}

