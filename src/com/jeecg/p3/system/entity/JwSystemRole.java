/*     */ package com.jeecg.p3.system.entity;
/*     */ 
/*     */ import java.util.Date;
/*     */ import org.jeecgframework.p3.core.utils.persistence.Entity;
/*     */ 
/*     */ public class JwSystemRole
/*     */   implements Entity<Integer>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Integer id;
/*     */   private String roleId;
/*     */   private String roleName;
/*     */   private String crtOperator;
/*     */   private Date crtDt;
/*     */   private String roleTyp;
/*     */   private String delStat;
/*     */   private String creator;
/*     */   private String editor;
/*     */   private Date createDt;
/*     */   private Date editDt;
/*     */   private Date lastEditDt;
/*     */   private String recordVersion;
/*     */   private Boolean isChecked;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  71 */     return this.id;
/*     */   }
/*     */   public void setId(Integer id) {
/*  74 */     this.id = id;
/*     */   }
/*     */   public String getRoleId() {
/*  77 */     return this.roleId;
/*     */   }
/*     */   public void setRoleId(String roleId) {
/*  80 */     this.roleId = roleId;
/*     */   }
/*     */   public String getRoleName() {
/*  83 */     return this.roleName;
/*     */   }
/*     */   public void setRoleName(String roleName) {
/*  86 */     this.roleName = roleName;
/*     */   }
/*     */   public String getCrtOperator() {
/*  89 */     return this.crtOperator;
/*     */   }
/*     */   public void setCrtOperator(String crtOperator) {
/*  92 */     this.crtOperator = crtOperator;
/*     */   }
/*     */   public Date getCrtDt() {
/*  95 */     return this.crtDt;
/*     */   }
/*     */   public void setCrtDt(Date crtDt) {
/*  98 */     this.crtDt = crtDt;
/*     */   }
/*     */   public String getRoleTyp() {
/* 101 */     return this.roleTyp;
/*     */   }
/*     */   public void setRoleTyp(String roleTyp) {
/* 104 */     this.roleTyp = roleTyp;
/*     */   }
/*     */   public String getDelStat() {
/* 107 */     return this.delStat;
/*     */   }
/*     */   public void setDelStat(String delStat) {
/* 110 */     this.delStat = delStat;
/*     */   }
/*     */   public String getCreator() {
/* 113 */     return this.creator;
/*     */   }
/*     */   public void setCreator(String creator) {
/* 116 */     this.creator = creator;
/*     */   }
/*     */   public String getEditor() {
/* 119 */     return this.editor;
/*     */   }
/*     */   public void setEditor(String editor) {
/* 122 */     this.editor = editor;
/*     */   }
/*     */   public Date getCreateDt() {
/* 125 */     return this.createDt;
/*     */   }
/*     */   public void setCreateDt(Date createDt) {
/* 128 */     this.createDt = createDt;
/*     */   }
/*     */   public Date getEditDt() {
/* 131 */     return this.editDt;
/*     */   }
/*     */   public void setEditDt(Date editDt) {
/* 134 */     this.editDt = editDt;
/*     */   }
/*     */   public Date getLastEditDt() {
/* 137 */     return this.lastEditDt;
/*     */   }
/*     */   public void setLastEditDt(Date lastEditDt) {
/* 140 */     this.lastEditDt = lastEditDt;
/*     */   }
/*     */   public String getRecordVersion() {
/* 143 */     return this.recordVersion;
/*     */   }
/*     */   public void setRecordVersion(String recordVersion) {
/* 146 */     this.recordVersion = recordVersion;
/*     */   }
/*     */   public Boolean getIsChecked() {
/* 149 */     return this.isChecked;
/*     */   }
/*     */   public void setIsChecked(Boolean isChecked) {
/* 152 */     this.isChecked = isChecked;
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 156 */     return "JwSystemRole [id=" + this.id + ", roleId=" + this.roleId + ", roleName=" + this.roleName + ", crtOperator=" + this.crtOperator + ", crtDt=" + this.crtDt + ", roleTyp=" + this.roleTyp + ", delStat=" + this.delStat + ", creator=" + this.creator + ", editor=" + this.editor + ", createDt=" + this.createDt + ", editDt=" + this.editDt + ", lastEditDt=" + this.lastEditDt + ", recordVersion=" + this.recordVersion + "]";
/*     */   }
/*     */ }

/* Location:           E:\eclipse_workspace\myproject\PatientVisit\WebContent\WEB-INF\lib\P3-Base-system-2.1-SNAPSHOT.jar
 * Qualified Name:     com.jeecg.p3.system.entity.JwSystemRole
 * JD-Core Version:    0.6.2
 */