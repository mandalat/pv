package com.mandala.mbData.service;

import java.util.List;

import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import com.mandala.mbData.entity.PvTemplateView;

/**
 * 描述：</b>PvTemplateViewService<br>
 * @author：zhangliang
 * @since：2018年03月19日 11时50分39秒 星期一 
 * @version:1.0
 */
public interface PvTemplateViewService {
	
	
	public void doAdd(PvTemplateView pvTemplateView);
	
	public void doEdit(PvTemplateView pvTemplateView);
	
	public void doDelete(String id);
	
	public PvTemplateView queryById(String id);
	
	public PageList<PvTemplateView> queryPageList(PageQuery<PvTemplateView> pageQuery);
	
	public List<PvTemplateView> queryList(PvTemplateView pvTemplateView);
}

