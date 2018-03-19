package com.mandala.visitRecord.dao.impl;

import java.util.List;

import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.PageQueryWrapper;
import org.jeecgframework.p3.core.utils.persistence.mybatis.GenericDaoDefault;
import org.springframework.stereotype.Repository;
import com.mandala.visitRecord.dao.PvRecordDao;
import com.mandala.visitRecord.entity.PvRecord;

/**
 * 描述：</b>PvRecordDaoImpl<br>
 * @author：zhangliang
 * @since：2018年03月13日 17时18分14秒 星期二 
 * @version:1.0
 */
@Repository("pvRecordDao")
public class PvRecordDaoImpl extends GenericDaoDefault<PvRecord> implements PvRecordDao{

	@Override
	public Integer count(PageQuery<PvRecord> pageQuery) {
		return (Integer) super.queryOne("count",pageQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PvRecord> queryPageList(
			PageQuery<PvRecord> pageQuery,Integer itemCount) {
		PageQueryWrapper<PvRecord> wrapper = new PageQueryWrapper<PvRecord>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery());
		return (List<PvRecord>)super.query("queryPageList",wrapper);
	}


}

