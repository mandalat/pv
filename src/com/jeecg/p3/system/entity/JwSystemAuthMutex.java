/*    */ package com.jeecg.p3.system.entity;
/*    */ 
/*    */ import org.jeecgframework.p3.core.utils.persistence.Entity;
/*    */ 
/*    */ public class JwSystemAuthMutex
/*    */   implements Entity<Integer>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private Integer id;
/*    */   private String authId;
/*    */   private String mutexAuthId;
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 27 */     return this.id;
/*    */   }
/*    */   public void setId(Integer id) {
/* 30 */     this.id = id;
/*    */   }
/*    */   public String getAuthId() {
/* 33 */     return this.authId;
/*    */   }
/*    */   public void setAuthId(String authId) {
/* 36 */     this.authId = authId;
/*    */   }
/*    */   public String getMutexAuthId() {
/* 39 */     return this.mutexAuthId;
/*    */   }
/*    */   public void setMutexAuthId(String mutexAuthId) {
/* 42 */     this.mutexAuthId = mutexAuthId;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 46 */     return "JwSystemAuthMutex [id=" + this.id + ", authId=" + this.authId + ", mutexAuthId=" + this.mutexAuthId + "]";
/*    */   }
/*    */ }

/* Location:           E:\eclipse_workspace\myproject\PatientVisit\WebContent\WEB-INF\lib\P3-Base-system-2.1-SNAPSHOT.jar
 * Qualified Name:     com.jeecg.p3.system.entity.JwSystemAuthMutex
 * JD-Core Version:    0.6.2
 */