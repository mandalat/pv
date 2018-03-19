/*     */ package com.jeecg.p3.system.entity;
/*     */ 
/*     */ import java.util.Date;
/*     */ import org.jeecgframework.p3.core.utils.persistence.Entity;
/*     */ 
/*     */ public class JwSystemUser
/*     */   implements Entity<Integer>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Integer id;
/*     */   private String userId;
/*     */   private String userName;
/*     */   private String password;
/*     */   private String userErpNo;
/*     */   private String userTyp;
/*     */   private String opeDepId;
/*     */   private String opePhoneNum;
/*     */   private String email;
/*     */   private String opeEmailAuthinfo;
/*     */   private String userIcon;
/*     */   private String opeMobileAuthInd;
/*     */   private String opeEmailAuthInd;
/*     */   private String idNum;
/*     */   private String idTyp;
/*     */   private String state;
/*     */   private String userStat;
/*     */   private Date lastLognDttm;
/*     */   private String lastLognIp;
/*     */   private String opePasswdInd;
/*     */   private String delStat;
/*     */   private String creator;
/*     */   private String editor;
/*     */   private Date createDt;
/*     */   private Date editDt;
/*     */   private Date lastEditDt;
/*     */   private String recordVersion;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/* 125 */     return this.id;
/*     */   }
/*     */   public void setId(Integer id) {
/* 128 */     this.id = id;
/*     */   }
/*     */   public String getUserId() {
/* 131 */     return this.userId;
/*     */   }
/*     */   public void setUserId(String userId) {
/* 134 */     this.userId = userId;
/*     */   }
/*     */   public String getUserName() {
/* 137 */     return this.userName;
/*     */   }
/*     */   public void setUserName(String userName) {
/* 140 */     this.userName = userName;
/*     */   }
/*     */   public String getUserErpNo() {
/* 143 */     return this.userErpNo;
/*     */   }
/*     */   public void setUserErpNo(String userErpNo) {
/* 146 */     this.userErpNo = userErpNo;
/*     */   }
/*     */   public String getUserTyp() {
/* 149 */     return this.userTyp;
/*     */   }
/*     */   public void setUserTyp(String userTyp) {
/* 152 */     this.userTyp = userTyp;
/*     */   }
/*     */   public String getOpeDepId() {
/* 155 */     return this.opeDepId;
/*     */   }
/*     */   public void setOpeDepId(String opeDepId) {
/* 158 */     this.opeDepId = opeDepId;
/*     */   }
/*     */   public String getOpePhoneNum() {
/* 161 */     return this.opePhoneNum;
/*     */   }
/*     */   public void setOpePhoneNum(String opePhoneNum) {
/* 164 */     this.opePhoneNum = opePhoneNum;
/*     */   }
/*     */   public String getEmail() {
/* 167 */     return this.email;
/*     */   }
/*     */   public void setEmail(String email) {
/* 170 */     this.email = email;
/*     */   }
/*     */   public String getOpeEmailAuthinfo() {
/* 173 */     return this.opeEmailAuthinfo;
/*     */   }
/*     */   public void setOpeEmailAuthinfo(String opeEmailAuthinfo) {
/* 176 */     this.opeEmailAuthinfo = opeEmailAuthinfo;
/*     */   }
/*     */   public String getUserIcon() {
/* 179 */     return this.userIcon;
/*     */   }
/*     */   public void setUserIcon(String userIcon) {
/* 182 */     this.userIcon = userIcon;
/*     */   }
/*     */   public String getOpeMobileAuthInd() {
/* 185 */     return this.opeMobileAuthInd;
/*     */   }
/*     */   public void setOpeMobileAuthInd(String opeMobileAuthInd) {
/* 188 */     this.opeMobileAuthInd = opeMobileAuthInd;
/*     */   }
/*     */   public String getOpeEmailAuthInd() {
/* 191 */     return this.opeEmailAuthInd;
/*     */   }
/*     */   public void setOpeEmailAuthInd(String opeEmailAuthInd) {
/* 194 */     this.opeEmailAuthInd = opeEmailAuthInd;
/*     */   }
/*     */   public String getIdNum() {
/* 197 */     return this.idNum;
/*     */   }
/*     */   public void setIdNum(String idNum) {
/* 200 */     this.idNum = idNum;
/*     */   }
/*     */   public String getIdTyp() {
/* 203 */     return this.idTyp;
/*     */   }
/*     */   public void setIdTyp(String idTyp) {
/* 206 */     this.idTyp = idTyp;
/*     */   }
/*     */   public String getState() {
/* 209 */     return this.state;
/*     */   }
/*     */   public void setState(String state) {
/* 212 */     this.state = state;
/*     */   }
/*     */   public String getUserStat() {
/* 215 */     return this.userStat;
/*     */   }
/*     */   public void setUserStat(String userStat) {
/* 218 */     this.userStat = userStat;
/*     */   }
/*     */   public Date getLastLognDttm() {
/* 221 */     return this.lastLognDttm;
/*     */   }
/*     */   public void setLastLognDttm(Date lastLognDttm) {
/* 224 */     this.lastLognDttm = lastLognDttm;
/*     */   }
/*     */   public String getLastLognIp() {
/* 227 */     return this.lastLognIp;
/*     */   }
/*     */   public void setLastLognIp(String lastLognIp) {
/* 230 */     this.lastLognIp = lastLognIp;
/*     */   }
/*     */   public String getOpePasswdInd() {
/* 233 */     return this.opePasswdInd;
/*     */   }
/*     */   public void setOpePasswdInd(String opePasswdInd) {
/* 236 */     this.opePasswdInd = opePasswdInd;
/*     */   }
/*     */   public String getDelStat() {
/* 239 */     return this.delStat;
/*     */   }
/*     */   public void setDelStat(String delStat) {
/* 242 */     this.delStat = delStat;
/*     */   }
/*     */   public String getCreator() {
/* 245 */     return this.creator;
/*     */   }
/*     */   public void setCreator(String creator) {
/* 248 */     this.creator = creator;
/*     */   }
/*     */   public String getEditor() {
/* 251 */     return this.editor;
/*     */   }
/*     */   public void setEditor(String editor) {
/* 254 */     this.editor = editor;
/*     */   }
/*     */   public Date getCreateDt() {
/* 257 */     return this.createDt;
/*     */   }
/*     */   public void setCreateDt(Date createDt) {
/* 260 */     this.createDt = createDt;
/*     */   }
/*     */   public Date getEditDt() {
/* 263 */     return this.editDt;
/*     */   }
/*     */   public void setEditDt(Date editDt) {
/* 266 */     this.editDt = editDt;
/*     */   }
/*     */   public Date getLastEditDt() {
/* 269 */     return this.lastEditDt;
/*     */   }
/*     */   public void setLastEditDt(Date lastEditDt) {
/* 272 */     this.lastEditDt = lastEditDt;
/*     */   }
/*     */   public String getRecordVersion() {
/* 275 */     return this.recordVersion;
/*     */   }
/*     */   public void setRecordVersion(String recordVersion) {
/* 278 */     this.recordVersion = recordVersion;
/*     */   }
/*     */   public String getPassword() {
/* 281 */     return this.password;
/*     */   }
/*     */   public void setPassword(String password) {
/* 284 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 288 */     return "JwSystemUser [id=" + this.id + ", userId=" + this.userId + ", userName=" + this.userName + ", userErpNo=" + this.userErpNo + ", userTyp=" + this.userTyp + ", opeDepId=" + this.opeDepId + ", opePhoneNum=" + this.opePhoneNum + ", email=" + this.email + ", opeEmailAuthinfo=" + this.opeEmailAuthinfo + ", userIcon=" + this.userIcon + ", opeMobileAuthInd=" + this.opeMobileAuthInd + ", opeEmailAuthInd=" + this.opeEmailAuthInd + ", idNum=" + this.idNum + ", idTyp=" + this.idTyp + ", state=" + this.state + ", userStat=" + this.userStat + ", lastLognDttm=" + this.lastLognDttm + ", lastLognIp=" + this.lastLognIp + ", opePasswdInd=" + this.opePasswdInd + ", delStat=" + this.delStat + ", creator=" + this.creator + ", editor=" + this.editor + ", createDt=" + this.createDt + ", editDt=" + this.editDt + ", lastEditDt=" + this.lastEditDt + ", recordVersion=" + this.recordVersion + "]";
/*     */   }
/*     */ }

/* Location:           E:\eclipse_workspace\myproject\PatientVisit\WebContent\WEB-INF\lib\P3-Base-system-2.1-SNAPSHOT.jar
 * Qualified Name:     com.jeecg.p3.system.entity.JwSystemUser
 * JD-Core Version:    0.6.2
 */