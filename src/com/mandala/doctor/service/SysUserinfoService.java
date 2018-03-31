package com.mandala.doctor.service;

import java.util.Map;

import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import com.mandala.doctor.entity.SysUserinfo;
import com.mandala.patient.entity.ZyEmrBasy;

/**
 * 描述：</b>SysUserinfoService<br>
 * @author：zhangliang
 * @since：2018年03月13日 10时07分53秒 星期二 
 * @version:1.0
 */
public interface SysUserinfoService {
	
	
	public void doAdd(SysUserinfo sysUserinfo);
	
	public void doEdit(SysUserinfo sysUserinfo);
	
	public void doDelete(String id);
	
	public SysUserinfo queryById(String id);
	
	public PageList<SysUserinfo> queryPageList(PageQuery<SysUserinfo> pageQuery);
	
	public SysUserinfo queryByDoctorAndPwd(Map<String, Object> conditionMap);
}

