package com.mandala.doctor.dao;

import java.util.List;
import java.util.Map;

import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.persistence.GenericDao;

import com.mandala.doctor.entity.SysUserinfo;

/**
 * 描述：</b>SysUserinfoDao<br>
 * @author：zhangliang
 * @since：2018年03月13日 10时07分53秒 星期二 
 * @version:1.0
 */
public interface SysUserinfoDao extends GenericDao<SysUserinfo>{
	
	public Integer count(PageQuery<SysUserinfo> pageQuery);
	
	public List<SysUserinfo> queryPageList(PageQuery<SysUserinfo> pageQuery,Integer itemCount);
	
	public SysUserinfo queryByDoctorAndPwd(Map<String, Object> conditionMap);
	
}

