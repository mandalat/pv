package com.mandala.visitRecord.service;

import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import com.mandala.visitRecord.entity.PvRecord;

/**
 * 描述：</b>PvRecordService<br>
 * @author：zhangliang
 * @since：2018年03月13日 17时18分14秒 星期二 
 * @version:1.0
 */
public interface PvRecordService {
	
	
	public void doAdd(PvRecord pvRecord);
	
	public void doEdit(PvRecord pvRecord);
	
	public void doDelete(String id);
	
	public PvRecord queryById(String id);
	
	public PageList<PvRecord> queryPageList(PageQuery<PvRecord> pageQuery);
}

