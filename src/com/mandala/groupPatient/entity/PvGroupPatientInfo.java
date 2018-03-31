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
public class PvGroupPatientInfo implements Entity<String> {
	private static final long serialVersionUID = 1L;
		/**	 *备用字段	 */	private String gpExtend1;	/**	 *备用字段	 */	private String gpExtend0;	/**	 *记录创建人ID	 */	private String gpCreateUserid;	/**	 *群组ID	 */	private String groupId;	/**	 *病人住院号	 */	private String patientId;	/**	 *主键ID	 */	private String gpid;
	
	private String diagnosecode1;
	/**
	 *入院诊断
	 */
	private String diagnosedesc1;
	/**
	 *
	 */
	private String diswardcode;

	private String patname;
	private String admdward;
	private String admsdate;
	private String admddate;
	private String admdays;
	private String sex;
	private String marrycode;
	private String nation;
	private String nationality;
	private String birthday;
	private String credentialno;
	private String linkname;
	private String linktelephone;
	private String linkvillage;
	private String workdesc;
	private String attendingdesc;
	private String medicId;
	private String medicName;
	private String medicPhone;
	private String admno;
	
	
		public String getAdmno() {
		return admno;
	}
	public void setAdmno(String admno) {
		this.admno = admno;
	}
	public String getGpExtend1() {	    return this.gpExtend1;	}	public void setGpExtend1(String gpExtend1) {	    this.gpExtend1=gpExtend1;	}	public String getGpExtend0() {	    return this.gpExtend0;	}	public void setGpExtend0(String gpExtend0) {	    this.gpExtend0=gpExtend0;	}	public String getGpCreateUserid() {	    return this.gpCreateUserid;	}	public void setGpCreateUserid(String gpCreateUserid) {	    this.gpCreateUserid=gpCreateUserid;	}	public String getGroupId() {	    return this.groupId;	}	public void setGroupId(String groupId) {	    this.groupId=groupId;	}	public String getPatientId() {	    return this.patientId;	}	public void setPatientId(String patientId) {	    this.patientId=patientId;	}	public String getGpid() {	    return this.gpid;	}	public void setGpid(String gpid) {	    this.gpid=gpid;	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setId(String arg0) {
		// TODO Auto-generated method stub
		
	}
	public String getPatname() {
		return patname;
	}
	public void setPatname(String patname) {
		this.patname = patname;
	}
	public String getAdmdward() {
		return admdward;
	}
	public void setAdmdward(String admdward) {
		this.admdward = admdward;
	}
	public String getAdmsdate() {
		return admsdate;
	}
	public void setAdmsdate(String admsdate) {
		this.admsdate = admsdate;
	}
	public String getAdmddate() {
		return admddate;
	}
	public void setAdmddate(String admddate) {
		this.admddate = admddate;
	}
	public String getAdmdays() {
		return admdays;
	}
	public void setAdmdays(String admdays) {
		this.admdays = admdays;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMarrycode() {
		return marrycode;
	}
	public void setMarrycode(String marrycode) {
		this.marrycode = marrycode;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCredentialno() {
		return credentialno;
	}
	public void setCredentialno(String credentialno) {
		this.credentialno = credentialno;
	}
	public String getLinkname() {
		return linkname;
	}
	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}
	public String getLinktelephone() {
		return linktelephone;
	}
	public void setLinktelephone(String linktelephone) {
		this.linktelephone = linktelephone;
	}
	public String getLinkvillage() {
		return linkvillage;
	}
	public void setLinkvillage(String linkvillage) {
		this.linkvillage = linkvillage;
	}
	public String getWorkdesc() {
		return workdesc;
	}
	public void setWorkdesc(String workdesc) {
		this.workdesc = workdesc;
	}
	public String getAttendingdesc() {
		return attendingdesc;
	}
	public void setAttendingdesc(String attendingdesc) {
		this.attendingdesc = attendingdesc;
	}
	public String getDiagnosecode1() {
		return diagnosecode1;
	}
	public void setDiagnosecode1(String diagnosecode1) {
		this.diagnosecode1 = diagnosecode1;
	}
	public String getDiagnosedesc1() {
		return diagnosedesc1;
	}
	public void setDiagnosedesc1(String diagnosedesc1) {
		this.diagnosedesc1 = diagnosedesc1;
	}
	public String getDiswardcode() {
		return diswardcode;
	}
	public void setDiswardcode(String diswardcode) {
		this.diswardcode = diswardcode;
	}
	public String getMedicId() {
		return medicId;
	}
	public void setMedicId(String medicId) {
		this.medicId = medicId;
	}
	public String getMedicName() {
		return medicName;
	}
	public void setMedicName(String medicName) {
		this.medicName = medicName;
	}
	public String getMedicPhone() {
		return medicPhone;
	}
	public void setMedicPhone(String medicPhone) {
		this.medicPhone = medicPhone;
	}
	
	
}

