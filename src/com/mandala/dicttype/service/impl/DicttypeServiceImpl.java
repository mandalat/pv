package com.mandala.dicttype.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;

import com.mandala.dicttype.dao.DicttypeDao;
import com.mandala.dicttype.entity.Dicttype;
import com.mandala.dicttype.service.DicttypeService;

@Service("dicttypeService")
public class DicttypeServiceImpl implements DicttypeService {
	@Resource
	private DicttypeDao dicttypeDao;

	@Override
	public void doAdd(Dicttype dicttype) {
		dicttypeDao.add(dicttype);
	}

	@Override
	public void doEdit(Dicttype dicttype) {
		dicttypeDao.update(dicttype);
	}

	@Override
	public void doDelete(String id) {
		dicttypeDao.delete(id);
	}

	@Override
	public Dicttype queryById(String id) {
		Dicttype dicttype  = dicttypeDao.get(id);
		return dicttype;
	}

	@Override
	public PageList<Dicttype> queryPageList(
		PageQuery<Dicttype> pageQuery) {
		PageList<Dicttype> result = new PageList<Dicttype>();
		Integer itemCount = dicttypeDao.count(pageQuery);
		List<Dicttype> list = dicttypeDao.queryPageList(pageQuery,itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount, pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}
	
}
