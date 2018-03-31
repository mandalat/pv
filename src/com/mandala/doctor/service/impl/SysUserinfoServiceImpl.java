package com.mandala.doctor.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;
import com.mandala.doctor.service.SysUserinfoService;
import com.mandala.doctor.entity.SysUserinfo;
import com.mandala.doctor.dao.SysUserinfoDao;

@Service("sysUserinfoService")
public class SysUserinfoServiceImpl implements SysUserinfoService {
	@Resource
	private SysUserinfoDao sysUserinfoDao;

	@Override
	public void doAdd(SysUserinfo sysUserinfo) {
		sysUserinfoDao.add(sysUserinfo);
	}

	@Override
	public void doEdit(SysUserinfo sysUserinfo) {
		sysUserinfoDao.update(sysUserinfo);
	}

	@Override
	public void doDelete(String id) {
		sysUserinfoDao.delete(id);
	}

	@Override
	public SysUserinfo queryById(String id) {
		SysUserinfo sysUserinfo  = sysUserinfoDao.get(id);
		return sysUserinfo;
	}

	@Override
	public PageList<SysUserinfo> queryPageList(
		PageQuery<SysUserinfo> pageQuery) {
		PageList<SysUserinfo> result = new PageList<SysUserinfo>();
		Integer itemCount = sysUserinfoDao.count(pageQuery);
		List<SysUserinfo> list = sysUserinfoDao.queryPageList(pageQuery,itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}

	@Override
	public SysUserinfo queryByDoctorAndPwd(Map<String, Object> conditionMap) {
		SysUserinfo sysUserinfo  = sysUserinfoDao.queryByDoctorAndPwd(conditionMap);
		return sysUserinfo;
	}
	
}
