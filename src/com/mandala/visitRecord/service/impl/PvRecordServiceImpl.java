package com.mandala.visitRecord.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;

import com.mandala.visitRecord.service.PvRecordService;
import com.mandala.visitRecord.entity.PvRecord;
import com.mandala.visitRecord.dao.PvRecordDao;

@Service("pvRecordService")
public class PvRecordServiceImpl implements PvRecordService {
	@Resource
	private PvRecordDao pvRecordDao;

	@Override
	public void doAdd(PvRecord pvRecord) {
		pvRecordDao.add(pvRecord);
	}

	@Override
	public void doEdit(PvRecord pvRecord) {
		pvRecordDao.update(pvRecord);
	}

	@Override
	public void doDelete(String id) {
		pvRecordDao.delete(id);
	}

	@Override
	public PvRecord queryById(String id) {
		PvRecord pvRecord  = pvRecordDao.get(id);
		return pvRecord;
	}

	@Override
	public PageList<PvRecord> queryPageList(
		PageQuery<PvRecord> pageQuery) {
		PageList<PvRecord> result = new PageList<PvRecord>();
		Integer itemCount = pvRecordDao.count(pageQuery);
		List<PvRecord> list = pvRecordDao.queryPageList(pageQuery,itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}
	

	@Override
	public PageList<PvRecord> queryPageListToDo(PageQuery<PvRecord> pageQuery ) {
		// TODO Auto-generated method stub
		PageList<PvRecord> result = new PageList<PvRecord>();
		Integer itemCount = pvRecordDao.countToDo(pageQuery);
		List<PvRecord> list = pvRecordDao.queryPageListToDo(pageQuery,itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}
	
}
