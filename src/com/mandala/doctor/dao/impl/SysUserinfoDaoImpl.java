package com.mandala.doctor.dao.impl;

import java.util.List;
import java.util.Map;

import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.PageQueryWrapper;
import org.jeecgframework.p3.core.utils.persistence.mybatis.GenericDaoDefault;
import org.springframework.stereotype.Repository;
import com.mandala.doctor.dao.SysUserinfoDao;
import com.mandala.doctor.entity.SysUserinfo;

/**
 * 描述：</b>SysUserinfoDaoImpl<br>
 * @author：zhangliang
 * @since：2018年03月13日 10时07分53秒 星期二 
 * @version:1.0
 */
@Repository("sysUserinfoDao")
public class SysUserinfoDaoImpl extends GenericDaoDefault<SysUserinfo> implements SysUserinfoDao{

	@Override
	public Integer count(PageQuery<SysUserinfo> pageQuery) {
		return (Integer) super.queryOne("count",pageQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SysUserinfo> queryPageList(
			PageQuery<SysUserinfo> pageQuery,Integer itemCount) {
		PageQueryWrapper<SysUserinfo> wrapper = new PageQueryWrapper<SysUserinfo>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery());
		return (List<SysUserinfo>)super.query("queryPageList",wrapper);
	}

	@Override
	public SysUserinfo queryByDoctorAndPwd(Map<String, Object> conditionMap) {
		return (SysUserinfo) super.queryOne("queryByDoctorAndPwd",conditionMap);
	}


}

