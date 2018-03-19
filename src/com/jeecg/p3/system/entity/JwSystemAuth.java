/*     */ package com.jeecg.p3.system.entity;
/*     */ 
/*     */ import org.jeecgframework.p3.core.utils.persistence.Entity;
/*     */ 
/*     */ public class JwSystemAuth
/*     */   implements Entity<Integer>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Integer id;
/*     */   private String authId;
/*     */   private String authName;
/*     */   private String isLogs;
/*     */   private String authType;
/*     */   private String authDesc;
/*     */   private String authContr;
/*     */   private String parentAuthId;
/*     */   private Integer sortNo;
/*     */   private String bizLevel;
/*     */   private String leafInd;
/*     */   private String delStat;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  63 */     return this.id;
/*     */   }
/*     */   public void setId(Integer id) {
/*  66 */     this.id = id;
/*     */   }
/*     */   public String getAuthId() {
/*  69 */     return this.authId;
/*     */   }
/*     */   public void setAuthId(String authId) {
/*  72 */     this.authId = authId;
/*     */   }
/*     */   public String getAuthName() {
/*  75 */     return this.authName;
/*     */   }
/*     */   public void setAuthName(String authName) {
/*  78 */     this.authName = authName;
/*     */   }
/*     */   public String getIsLogs() {
/*  81 */     return this.isLogs;
/*     */   }
/*     */   public void setIsLogs(String isLogs) {
/*  84 */     this.isLogs = isLogs;
/*     */   }
/*     */   public String getAuthType() {
/*  87 */     return this.authType;
/*     */   }
/*     */   public void setAuthType(String authType) {
/*  90 */     this.authType = authType;
/*     */   }
/*     */   public String getAuthDesc() {
/*  93 */     return this.authDesc;
/*     */   }
/*     */   public void setAuthDesc(String authDesc) {
/*  96 */     this.authDesc = authDesc;
/*     */   }
/*     */   public String getAuthContr() {
/*  99 */     return this.authContr;
/*     */   }
/*     */   public void setAuthContr(String authContr) {
/* 102 */     this.authContr = authContr;
/*     */   }
/*     */   public String getParentAuthId() {
/* 105 */     return this.parentAuthId;
/*     */   }
/*     */   public void setParentAuthId(String parentAuthId) {
/* 108 */     this.parentAuthId = parentAuthId;
/*     */   }
/*     */   public Integer getSortNo() {
/* 111 */     return this.sortNo;
/*     */   }
/*     */   public void setSortNo(Integer sortNo) {
/* 114 */     this.sortNo = sortNo;
/*     */   }
/*     */   public String getBizLevel() {
/* 117 */     return this.bizLevel;
/*     */   }
/*     */   public void setBizLevel(String bizLevel) {
/* 120 */     this.bizLevel = bizLevel;
/*     */   }
/*     */   public String getLeafInd() {
/* 123 */     return this.leafInd;
/*     */   }
/*     */   public void setLeafInd(String leafInd) {
/* 126 */     this.leafInd = leafInd;
/*     */   }
/*     */   public String getDelStat() {
/* 129 */     return this.delStat;
/*     */   }
/*     */   public void setDelStat(String delStat) {
/* 132 */     this.delStat = delStat;
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 136 */     return "JwSystemAuth [id=" + this.id + ", authId=" + this.authId + ", authName=" + this.authName + ", isLogs=" + this.isLogs + ", authType=" + this.authType + ", authDesc=" + this.authDesc + ", authContr=" + this.authContr + ", parentAuthId=" + this.parentAuthId + ", sortNo=" + this.sortNo + ", bizLevel=" + this.bizLevel + ", leafInd=" + this.leafInd + ", delStat=" + this.delStat + "]";
/*     */   }
/*     */ }

/* Location:           E:\eclipse_workspace\myproject\PatientVisit\WebContent\WEB-INF\lib\P3-Base-system-2.1-SNAPSHOT.jar
 * Qualified Name:     com.jeecg.p3.system.entity.JwSystemAuth
 * JD-Core Version:    0.6.2
 */