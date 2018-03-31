package com.mandala.mbData.dao.impl;

import java.util.List;

import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.PageQueryWrapper;
import org.jeecgframework.p3.core.utils.persistence.mybatis.GenericDaoDefault;
import org.springframework.stereotype.Repository;
import com.mandala.mbData.dao.PvTemplateViewDao;
import com.mandala.mbData.entity.PvTemplateView;

/**
 * 描述：</b>PvTemplateViewDaoImpl<br>
 * @author：zhangliang
 * @since：2018年03月19日 11时50分39秒 星期一 
 * @version:1.0
 */
@Repository("pvTemplateViewDao")
public class PvTemplateViewDaoImpl extends GenericDaoDefault<PvTemplateView> implements PvTemplateViewDao{

	@Override
	public Integer count(PageQuery<PvTemplateView> pageQuery) {
		return (Integer) super.queryOne("count",pageQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PvTemplateView> queryPageList(
			PageQuery<PvTemplateView> pageQuery,Integer itemCount) {
		PageQueryWrapper<PvTemplateView> wrapper = new PageQueryWrapper<PvTemplateView>(pageQuery.getPageNo(), pageQuery.getPageSize(),itemCount, pageQuery.getQuery());
		return (List<PvTemplateView>)super.query("queryPageList",wrapper);
	}

	@Override
	public List<PvTemplateView> queryList(PvTemplateView pvTemplateView) {
		return (List<PvTemplateView>)super.query("queryList",pvTemplateView);
	}


}

