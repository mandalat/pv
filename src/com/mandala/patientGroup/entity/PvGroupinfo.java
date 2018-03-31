package com.mandala.patientGroup.entity;

import java.util.Date;
import java.math.BigDecimal;

import org.jeecgframework.p3.core.utils.persistence.Entity;

/**
 * 描述：</b>PvGroupinfo:<br>
 * @author huachao
 * @since：2018年03月21日 14时37分24秒 星期三 
 * @version:1.0
 */
public class PvGroupinfo implements Entity<String> {
	private static final long serialVersionUID = 1L;
		/**	 *群组描述	 */	private String groupDes;	/**	 *备用字段	 */	private String groupExtend1;	/**	 *备用字段	 */	private String groupExtend0;	/**	 *群组状态	 */	private String groupStatus;	/**	 *群组更新时间	 */	private Date groupUpdatetime;	/**	 *群组创建时间	 */	private Date groupCreatetime;	/**	 *群组修改人	 */	private String groupUpdateUserid;	/**	 *群组创建人	 */	private String groupCreateUserid;	/**	 *群组排序	 */	private Integer groupOrder;	/**	 *群组随访模板ID	 */	private String groupTempId;	/**	 *群组名称	 */	private String groupName;	/**	 *主键ID	 */	private String gid;	public String getGroupDes() {	    return this.groupDes;	}	public void setGroupDes(String groupDes) {	    this.groupDes=groupDes;	}	public String getGroupExtend1() {	    return this.groupExtend1;	}	public void setGroupExtend1(String groupExtend1) {	    this.groupExtend1=groupExtend1;	}	public String getGroupExtend0() {	    return this.groupExtend0;	}	public void setGroupExtend0(String groupExtend0) {	    this.groupExtend0=groupExtend0;	}	public String getGroupStatus() {	    return this.groupStatus;	}	public void setGroupStatus(String groupStatus) {	    this.groupStatus=groupStatus;	}	public Date getGroupUpdatetime() {	    return this.groupUpdatetime;	}	public void setGroupUpdatetime(Date groupUpdatetime) {	    this.groupUpdatetime=groupUpdatetime;	}	public Date getGroupCreatetime() {	    return this.groupCreatetime;	}	public void setGroupCreatetime(Date groupCreatetime) {	    this.groupCreatetime=groupCreatetime;	}	public String getGroupUpdateUserid() {	    return this.groupUpdateUserid;	}	public void setGroupUpdateUserid(String groupUpdateUserid) {	    this.groupUpdateUserid=groupUpdateUserid;	}	public String getGroupCreateUserid() {	    return this.groupCreateUserid;	}	public void setGroupCreateUserid(String groupCreateUserid) {	    this.groupCreateUserid=groupCreateUserid;	}	public Integer getGroupOrder() {	    return this.groupOrder;	}	public void setGroupOrder(Integer groupOrder) {	    this.groupOrder=groupOrder;	}	public String getGroupTempId() {	    return this.groupTempId;	}	public void setGroupTempId(String groupTempId) {	    this.groupTempId=groupTempId;	}	public String getGroupName() {	    return this.groupName;	}	public void setGroupName(String groupName) {	    this.groupName=groupName;	}	public String getGid() {	    return this.gid;	}	public void setGid(String gid) {	    this.gid=gid;	}
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

