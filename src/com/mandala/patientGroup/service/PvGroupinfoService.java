package com.mandala.patientGroup.service;

import java.util.List;

import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;

import com.mandala.patientGroup.entity.PvGroupinfo;

/**
 * 描述：</b>PvGroupinfoService<br>
 * @author：huachao
 * @since：2018年03月21日 14时37分24秒 星期三 
 * @version:1.0
 */
public interface PvGroupinfoService {
	
	
	public void doAdd(PvGroupinfo pvGroupinfo);
	
	public void doEdit(PvGroupinfo pvGroupinfo);
	
	public void doDelete(String id);
	
	public PvGroupinfo queryById(String id);
	
	public PageList<PvGroupinfo> queryPageList(PageQuery<PvGroupinfo> pageQuery);
	
	public List<PvGroupinfo> queryList(PvGroupinfo  query );
}

