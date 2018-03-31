package com.mandala.patientGroup.dao;

import java.util.List;

import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.persistence.GenericDao;

import com.mandala.patientGroup.entity.PvGroupinfo;

/**
 * 描述：</b>PvGroupinfoDao<br>
 * @author：huachao
 * @since：2018年03月21日 14时37分24秒 星期三 
 * @version:1.0
 */
public interface PvGroupinfoDao extends GenericDao<PvGroupinfo>{
	
	public Integer count(PageQuery<PvGroupinfo> pageQuery);
	
	public List<PvGroupinfo> queryPageList(PageQuery<PvGroupinfo> pageQuery,Integer itemCount);
	
	public List<PvGroupinfo> queryList(PvGroupinfo  query );
	
}

