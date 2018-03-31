package com.mandala.groupPatient.entity;

import java.util.Date;
import java.math.BigDecimal;

import org.jeecgframework.p3.core.utils.persistence.Entity;

/**
 * 描述：</b>PvGroupPatient:<br>
 * @author huachao
 * @since：2018年03月21日 14时39分55秒 星期三 
 * @version:1.0
 */
public class PvGroupPatient implements Entity<String> {
	private static final long serialVersionUID = 1L;
		/**	 *备用字段	 */	private String gpExtend1;	/**	 *备用字段	 */	private String gpExtend0;	/**	 *记录创建人ID	 */	private String gpCreateUserid;	/**	 *群组ID	 */	private String groupId;	/**	 *病人住院号	 */	private String patientId;	/**	 *主键ID	 */	private String gpid;	public String getGpExtend1() {	    return this.gpExtend1;	}	public void setGpExtend1(String gpExtend1) {	    this.gpExtend1=gpExtend1;	}	public String getGpExtend0() {	    return this.gpExtend0;	}	public void setGpExtend0(String gpExtend0) {	    this.gpExtend0=gpExtend0;	}	public String getGpCreateUserid() {	    return this.gpCreateUserid;	}	public void setGpCreateUserid(String gpCreateUserid) {	    this.gpCreateUserid=gpCreateUserid;	}	public String getGroupId() {	    return this.groupId;	}	public void setGroupId(String groupId) {	    this.groupId=groupId;	}	public String getPatientId() {	    return this.patientId;	}	public void setPatientId(String patientId) {	    this.patientId=patientId;	}	public String getGpid() {	    return this.gpid;	}	public void setGpid(String gpid) {	    this.gpid=gpid;	}
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

