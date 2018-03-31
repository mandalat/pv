package com.mandala.visitRecord.dao;

import java.util.List;

import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.persistence.GenericDao;

import com.mandala.visitRecord.entity.PvRecord;

/**
 * 描述：</b>PvRecordDao<br>
 * @author：zhangliang
 * @since：2018年03月13日 17时18分14秒 星期二 
 * @version:1.0
 */
public interface PvRecordDao extends GenericDao<PvRecord>{
	
	public Integer count(PageQuery<PvRecord> pageQuery);
	
	public List<PvRecord> queryPageList(PageQuery<PvRecord> pageQuery,Integer itemCount);
	
	public Integer countToDo(PageQuery<PvRecord> pageQuery);
	
	public List<PvRecord> queryPageListToDo(PageQuery<PvRecord> pageQuery,Integer itemCount);
	
}

