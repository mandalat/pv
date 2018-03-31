package com.mandala.doctor.entity;

import java.util.Date;
import java.math.BigDecimal;
import java.sql.Clob;

import org.jeecgframework.p3.core.utils.persistence.Entity;

/**
 * 描述：</b>SysUserinfo:<br>
 * @author zhangliang
 * @since：2018年03月13日 10时07分53秒 星期二 
 * @version:1.0
 */
public class SysUserinfo implements Entity<String> {
	private static final long serialVersionUID = 1L;
		/**	 *	 */	private String 是否医技;	/**	 *	 */	private String 发薪号;	/**	 *	 */	private String isadmin;	/**	 *	 */	private String appBi;	/**	 *	 */	private String 病区名称;	/**	 *	 */	private String 病区代码;	/**	 *	 */	private String unit;	/**	 *	 */	private String 是否专家;	/**	 *	 */	private String 手机号;	/**	 *	 */	private String uRoleid;	/**	 *	 */	private String 状态;	/**	 *	 */	private Date 修改时间;	/**	 *	 */	private String 修改人;	/**	 *	 */	private Date 创建时间;	/**	 *	 */	private String 创建人;	/**	 *	 */	private String 备注;	/**	 *	 */	private String 专业;	/**	 *	 */	private String 人员类别;	/**	 *	 */	private String 所学专业;	/**	 *	 */	private String 最高学历毕业院校;	/**	 *	 */	private String 最高学历;	/**	 *	 */	private String 第一学历毕业院校;	/**	 *	 */	private String 第一学历;	/**	 *	 */	private String 是否为全科医生;	/**	 *	 */	private String 执业单位名称;	/**	 *	 */	private String 执业证书号;	/**	 *	 */	private String 执业资格名称;	/**	 *	 */	private String 职称名称;	/**	 *	 */	private String 职称代码;	/**	 *	 */	private String 职务名称;	/**	 *	 */	private String 职务代码;	/**	 *	 */	private String 科室名称;	/**	 *	 */	private String 科室代码;	/**	 *	 */	private Date 参加工作时间;	/**	 *	 */	private String 身份证号码;	/**	 *	 */	private String 出生日期;	/**	 *	 */	private String 性别;	/**	 *	 */	private String 姓名;	/**	 *	 */	private String 工号;	/**	 *	 */	private String 行政区划名称;	/**	 *	 */	private String 行政区划编码;	/**	 *	 */	private String 医疗机构名称;	/**	 *	 */	private String 医疗机构代码;	/**	 *	 */	private Clob 权限属性;	/**	 *	 */	private String password;	/**	 *	 */	private String username;	/**	 *	 */	private String sn;	public String get是否医技() {	    return this.是否医技;	}	public void set是否医技(String 是否医技) {	    this.是否医技=是否医技;	}	public String get发薪号() {	    return this.发薪号;	}	public void set发薪号(String 发薪号) {	    this.发薪号=发薪号;	}	public String getIsadmin() {	    return this.isadmin;	}	public void setIsadmin(String isadmin) {	    this.isadmin=isadmin;	}	public String getAppBi() {	    return this.appBi;	}	public void setAppBi(String appBi) {	    this.appBi=appBi;	}	public String get病区名称() {	    return this.病区名称;	}	public void set病区名称(String 病区名称) {	    this.病区名称=病区名称;	}	public String get病区代码() {	    return this.病区代码;	}	public void set病区代码(String 病区代码) {	    this.病区代码=病区代码;	}	public String getUnit() {	    return this.unit;	}	public void setUnit(String unit) {	    this.unit=unit;	}	public String get是否专家() {	    return this.是否专家;	}	public void set是否专家(String 是否专家) {	    this.是否专家=是否专家;	}	public String get手机号() {	    return this.手机号;	}	public void set手机号(String 手机号) {	    this.手机号=手机号;	}	public String getURoleid() {	    return this.uRoleid;	}	public void setURoleid(String uRoleid) {	    this.uRoleid=uRoleid;	}	public String get状态() {	    return this.状态;	}	public void set状态(String 状态) {	    this.状态=状态;	}	public Date get修改时间() {	    return this.修改时间;	}	public void set修改时间(Date 修改时间) {	    this.修改时间=修改时间;	}	public String get修改人() {	    return this.修改人;	}	public void set修改人(String 修改人) {	    this.修改人=修改人;	}	public Date get创建时间() {	    return this.创建时间;	}	public void set创建时间(Date 创建时间) {	    this.创建时间=创建时间;	}	public String get创建人() {	    return this.创建人;	}	public void set创建人(String 创建人) {	    this.创建人=创建人;	}	public String get备注() {	    return this.备注;	}	public void set备注(String 备注) {	    this.备注=备注;	}	public String get专业() {	    return this.专业;	}	public void set专业(String 专业) {	    this.专业=专业;	}	public String get人员类别() {	    return this.人员类别;	}	public void set人员类别(String 人员类别) {	    this.人员类别=人员类别;	}	public String get所学专业() {	    return this.所学专业;	}	public void set所学专业(String 所学专业) {	    this.所学专业=所学专业;	}	public String get最高学历毕业院校() {	    return this.最高学历毕业院校;	}	public void set最高学历毕业院校(String 最高学历毕业院校) {	    this.最高学历毕业院校=最高学历毕业院校;	}	public String get最高学历() {	    return this.最高学历;	}	public void set最高学历(String 最高学历) {	    this.最高学历=最高学历;	}	public String get第一学历毕业院校() {	    return this.第一学历毕业院校;	}	public void set第一学历毕业院校(String 第一学历毕业院校) {	    this.第一学历毕业院校=第一学历毕业院校;	}	public String get第一学历() {	    return this.第一学历;	}	public void set第一学历(String 第一学历) {	    this.第一学历=第一学历;	}	public String get是否为全科医生() {	    return this.是否为全科医生;	}	public void set是否为全科医生(String 是否为全科医生) {	    this.是否为全科医生=是否为全科医生;	}	public String get执业单位名称() {	    return this.执业单位名称;	}	public void set执业单位名称(String 执业单位名称) {	    this.执业单位名称=执业单位名称;	}	public String get执业证书号() {	    return this.执业证书号;	}	public void set执业证书号(String 执业证书号) {	    this.执业证书号=执业证书号;	}	public String get执业资格名称() {	    return this.执业资格名称;	}	public void set执业资格名称(String 执业资格名称) {	    this.执业资格名称=执业资格名称;	}	public String get职称名称() {	    return this.职称名称;	}	public void set职称名称(String 职称名称) {	    this.职称名称=职称名称;	}	public String get职称代码() {	    return this.职称代码;	}	public void set职称代码(String 职称代码) {	    this.职称代码=职称代码;	}	public String get职务名称() {	    return this.职务名称;	}	public void set职务名称(String 职务名称) {	    this.职务名称=职务名称;	}	public String get职务代码() {	    return this.职务代码;	}	public void set职务代码(String 职务代码) {	    this.职务代码=职务代码;	}	public String get科室名称() {	    return this.科室名称;	}	public void set科室名称(String 科室名称) {	    this.科室名称=科室名称;	}	public String get科室代码() {	    return this.科室代码;	}	public void set科室代码(String 科室代码) {	    this.科室代码=科室代码;	}	public Date get参加工作时间() {	    return this.参加工作时间;	}	public void set参加工作时间(Date 参加工作时间) {	    this.参加工作时间=参加工作时间;	}	public String get身份证号码() {	    return this.身份证号码;	}	public void set身份证号码(String 身份证号码) {	    this.身份证号码=身份证号码;	}	public String get出生日期() {	    return this.出生日期;	}	public void set出生日期(String 出生日期) {	    this.出生日期=出生日期;	}	public String get性别() {	    return this.性别;	}	public void set性别(String 性别) {	    this.性别=性别;	}	public String get姓名() {	    return this.姓名;	}	public void set姓名(String 姓名) {	    this.姓名=姓名;	}	public String get工号() {	    return this.工号;	}	public void set工号(String 工号) {	    this.工号=工号;	}	public String get行政区划名称() {	    return this.行政区划名称;	}	public void set行政区划名称(String 行政区划名称) {	    this.行政区划名称=行政区划名称;	}	public String get行政区划编码() {	    return this.行政区划编码;	}	public void set行政区划编码(String 行政区划编码) {	    this.行政区划编码=行政区划编码;	}	public String get医疗机构名称() {	    return this.医疗机构名称;	}	public void set医疗机构名称(String 医疗机构名称) {	    this.医疗机构名称=医疗机构名称;	}	public String get医疗机构代码() {	    return this.医疗机构代码;	}	public void set医疗机构代码(String 医疗机构代码) {	    this.医疗机构代码=医疗机构代码;	}	public Clob get权限属性() {	    return this.权限属性;	}	public void set权限属性(Clob 权限属性) {	    this.权限属性=权限属性;	}	public String getPassword() {	    return this.password;	}	public void setPassword(String password) {	    this.password=password;	}	public String getUsername() {	    return this.username;	}	public void setUsername(String username) {	    this.username=username;	}	public String getSn() {	    return this.sn;	}	public void setSn(String sn) {	    this.sn=sn;	}
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

