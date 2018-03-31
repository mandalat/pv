package com.mandala.mbData.entity;

import java.util.Date;
import java.math.BigDecimal;
import org.jeecgframework.p3.core.utils.persistence.Entity;

/**
 * 描述：</b>PvTemplateView:<br>
 * @author zhangliang
 * @since：2018年03月19日 11时50分39秒 星期一 
 * @version:1.0
 */
public class PvTemplateView implements Entity<String> {
	private static final long serialVersionUID = 1L;
		/**	 *	 */	private String tempExtend1;	/**	 *	 */	private String tempExtend0;	/**	 *模板修改人ID	 */	private String tempUpdateUserid;	/**	 *模板创建人ID	 */	private String tempCreateUserid;	/**	 *模板修改时间	 */	private Date tempUpdatetime;	/**	 *模板创建时间	 */	private Date tempCreatetiime;	/**	 *主要诊断	 */	private String mainDaignos;	/**	 *模板存放路径	 */	private String tempFileUrl;	/**	 *模板名称	 */	private String tempName;	/**	 *所属科室编码	 */	private String deptCode;	/**	 *随访模板ID 	 */	private String tid;	public String getTempExtend1() {	    return this.tempExtend1;	}	public void setTempExtend1(String tempExtend1) {	    this.tempExtend1=tempExtend1;	}	public String getTempExtend0() {	    return this.tempExtend0;	}	public void setTempExtend0(String tempExtend0) {	    this.tempExtend0=tempExtend0;	}	public String getTempUpdateUserid() {	    return this.tempUpdateUserid;	}	public void setTempUpdateUserid(String tempUpdateUserid) {	    this.tempUpdateUserid=tempUpdateUserid;	}	public String getTempCreateUserid() {	    return this.tempCreateUserid;	}	public void setTempCreateUserid(String tempCreateUserid) {	    this.tempCreateUserid=tempCreateUserid;	}	public Date getTempUpdatetime() {	    return this.tempUpdatetime;	}	public void setTempUpdatetime(Date tempUpdatetime) {	    this.tempUpdatetime=tempUpdatetime;	}	public Date getTempCreatetiime() {	    return this.tempCreatetiime;	}	public void setTempCreatetiime(Date tempCreatetiime) {	    this.tempCreatetiime=tempCreatetiime;	}	public String getMainDaignos() {	    return this.mainDaignos;	}	public void setMainDaignos(String mainDaignos) {	    this.mainDaignos=mainDaignos;	}	public String getTempFileUrl() {	    return this.tempFileUrl;	}	public void setTempFileUrl(String tempFileUrl) {	    this.tempFileUrl=tempFileUrl;	}	public String getTempName() {	    return this.tempName;	}	public void setTempName(String tempName) {	    this.tempName=tempName;	}	public String getDeptCode() {	    return this.deptCode;	}	public void setDeptCode(String deptCode) {	    this.deptCode=deptCode;	}	public String getTid() {	    return this.tid;	}	public void setTid(String tid) {	    this.tid=tid;	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setId(String arg0) {
		// TODO Auto-generated method stub
		
	}
}

