package com.mandala.patientGroup.dao.impl;

import java.util.List;

import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.PageQueryWrapper;
import org.jeecgframework.p3.core.utils.persistence.mybatis.GenericDaoDefault;
import org.springframework.stereotype.Repository;

import com.mandala.patientGroup.dao.PvGroupinfoDao;
import com.mandala.patientGroup.entity.PvGroupinfo;

/**
 * 描述：</b>PvGroupinfoDaoImpl<br>
 * @author：huachao
 * @since：2018年03月21日 14时37分24秒 星期三 
 * @version:1.0
 */
@Repository("pvGroupinfoDao")
public class PvGroupinfoDaoImpl extends GenericDaoDefault<PvGroupinfo> implements PvGroupinfoDao{

	@Override
	public Integer count(PageQuery<PvGroupinfo> pageQuery) {
		return (Integer) super.queryOne("count",pageQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PvGroupinfo> queryPageList(
			PageQuery<PvGroupinfo> pageQuery,Integer itemCount) {
		PageQueryWrapper<PvGroupinfo> wrapper = new PageQueryWrapper<PvGroupinfo>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery());
		return (List<PvGroupinfo>)super.query("queryPageList",wrapper);
	}

	@Override
	public List<PvGroupinfo> queryList(PvGroupinfo query) {
		// TODO Auto-generated method stub
		return (List<PvGroupinfo>)super.query("queryALL", query);
	}
 


}

