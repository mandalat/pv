package com.mandala.mbData.dao;

import java.util.List;

import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.persistence.GenericDao;

import com.mandala.mbData.entity.PvTemplateView;

/**
 * 描述：</b>PvTemplateViewDao<br>
 * @author：zhangliang
 * @since：2018年03月19日 11时50分39秒 星期一 
 * @version:1.0
 */
public interface PvTemplateViewDao extends GenericDao<PvTemplateView>{
	
	public Integer count(PageQuery<PvTemplateView> pageQuery);
	
	public List<PvTemplateView> queryPageList(PageQuery<PvTemplateView> pageQuery,Integer itemCount);
	
	public List<PvTemplateView> queryList(PvTemplateView pvTemplateView);
	
}

