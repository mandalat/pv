package com.mandala.dictinfo.dao;

import java.util.List;

import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.persistence.GenericDao;

import com.mandala.dictinfo.entity.Dictinfo;

/**
 * 描述：</b>DictinfoDao<br>
 * @author：chao.hua
 * @since：2017年07月25日 17时04分33秒 星期二 
 * @version:1.0
 */
public interface DictinfoDao extends GenericDao<Dictinfo>{
	
	public Integer count(PageQuery<Dictinfo> pageQuery);
	
	public List<Dictinfo> queryPageList(PageQuery<Dictinfo> pageQuery,Integer itemCount);
	
	public List<Dictinfo> queryList( Dictinfo  pageQuery);
	
	
}

