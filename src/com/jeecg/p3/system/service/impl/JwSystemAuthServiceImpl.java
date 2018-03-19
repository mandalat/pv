/*     */ package com.jeecg.p3.system.service.impl;
/*     */ 
/*     */ import com.jeecg.p3.system.dao.JwSystemAuthDao;
/*     */ import com.jeecg.p3.system.entity.Auth;
/*     */ import com.jeecg.p3.system.entity.JwSystemAuth;
/*     */ import com.jeecg.p3.system.entity.Menu;
/*     */ import com.jeecg.p3.system.entity.MenuFunction;
/*     */ import com.jeecg.p3.system.service.JwSystemAuthService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import javax.annotation.Resource;
/*     */ import org.jeecgframework.p3.core.utils.common.PageList;
/*     */ import org.jeecgframework.p3.core.utils.common.PageQuery;
/*     */ import org.jeecgframework.p3.core.utils.common.Pagenation;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ 
/*     */ @Service("jwSystemAuthService")
/*     */ public class JwSystemAuthServiceImpl
/*     */   implements JwSystemAuthService
/*     */ {
/*     */ 
/*     */   @Resource
/*     */   private JwSystemAuthDao jwSystemAuthDao;
/*     */ 
/*     */   public void doAdd(JwSystemAuth jwSystemAuth)
/*     */   {
/*  29 */     jwSystemAuth.setDelStat("0");
/*  30 */     this.jwSystemAuthDao.add(jwSystemAuth);
/*     */   }
/*     */ 
/*     */   public void doEdit(JwSystemAuth jwSystemAuth)
/*     */   {
/*  35 */     this.jwSystemAuthDao.update(jwSystemAuth);
/*     */   }
/*     */ 
/*     */   public void doDelete(Long id)
/*     */   {
/*  40 */     this.jwSystemAuthDao.delete(id);
/*     */   }
/*     */ 
/*     */   public JwSystemAuth queryById(Long id)
/*     */   {
/*  45 */     JwSystemAuth jwSystemAuth = (JwSystemAuth)this.jwSystemAuthDao.get(id);
/*  46 */     return jwSystemAuth;
/*     */   }
/*     */ 
/*     */   public PageList<JwSystemAuth> queryPageList(PageQuery<JwSystemAuth> pageQuery)
/*     */   {
/*  52 */     PageList result = new PageList();
/*  53 */     Integer itemCount = this.jwSystemAuthDao.count(pageQuery);
/*  54 */     List list = this.jwSystemAuthDao.queryPageList(pageQuery, itemCount);
/*  55 */     Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount.intValue(), pageQuery.getPageSize());
/*  56 */     result.setPagenation(pagenation);
/*  57 */     result.setValues(list);
/*  58 */     return result;
/*     */   }
/*     */ 
/*     */   public List<MenuFunction> queryMenuAndFuncAuth()
/*     */   {
/*  63 */     return this.jwSystemAuthDao.queryMenuAndFuncAuth();
/*     */   }
/*     */ 
/*     */   public List<MenuFunction> queryMenuAndFuncAuthByRoleId(String roleId)
/*     */   {
/*  68 */     return this.jwSystemAuthDao.queryMenuAndFuncAuthByRoleId(roleId);
/*     */   }
/*     */ 
/*     */   public Menu queryMenuByAuthId(String authId)
/*     */   {
/*  73 */     return this.jwSystemAuthDao.queryMenuByAuthId(authId);
/*     */   }
/*     */ 
/*     */   @Transactional(rollbackFor={Exception.class})
/*     */   public void modifyOperateRoleAuthRel(String roleId, List<String> authIds)
/*     */   {
/*  79 */     this.jwSystemAuthDao.deleteRoleAuthRels(roleId);
/*  80 */     if ((authIds != null) && (authIds.size() > 0))
/*  81 */       for (String authId : authIds)
/*  82 */         this.jwSystemAuthDao.insertRoleAuthRels(roleId, authId);
/*     */   }
/*     */ 
/*     */   public LinkedHashMap<Menu, ArrayList<Menu>> getSubMenuTree(String userId, String parentAuthId)
/*     */   {
/*  90 */     List<Menu> allSubMenuList = getAllSubMenuList(userId, parentAuthId, new ArrayList());
/*     */ 
/*  92 */     LinkedHashMap result = new LinkedHashMap();
/*     */ 
/*  94 */     for (Menu menu : allSubMenuList) {
/*  95 */       if (isParentMenu(menu, allSubMenuList).booleanValue()) {
/*  96 */         ArrayList subMenuList = getSubMenuList(allSubMenuList, menu.getAuthId());
/*  97 */         result.put(menu, subMenuList);
/*  98 */       } else if (!isSonMenu(menu, allSubMenuList).booleanValue()) {
/*  99 */         result.put(menu, null);
/*     */       }
/*     */     }
/*     */ 
/* 103 */     return result;
/*     */   }
/*     */ 
/*     */   private List<Menu> getAllSubMenuList(String userId, String parentAuthId, List<Menu> allSubMenu)
/*     */   {
/* 114 */     List<Menu> curSubMenu = this.jwSystemAuthDao.queryMenuByUserIdAndParentAuthId(userId, parentAuthId);
/*     */ 
/* 116 */     if (curSubMenu.size() == 0)
/* 117 */       return allSubMenu;
/* 118 */     for (Menu menu : curSubMenu) { allSubMenu.add(menu);
/* 120 */       int allNum = allSubMenu.size();
/* 121 */       allSubMenu = getAllSubMenuList(userId, menu.getAuthId(), allSubMenu);
/* 122 */       int tmpNum = allSubMenu.size();
/*     */ 
/* 124 */       if (allNum == tmpNum); } return allSubMenu;
/*     */   }
/*     */ 
/*     */   private Boolean isParentMenu(Menu curMenu, List<Menu> subMenuList)
/*     */   {
/* 137 */     for (Menu menu : subMenuList) {
/* 138 */       if (curMenu.getAuthId().equals(menu.getParentAuthId())) {
/* 139 */         return Boolean.valueOf(true);
/*     */       }
/*     */     }
/* 142 */     return Boolean.valueOf(false);
/*     */   }
/*     */ 
/*     */   private Boolean isSonMenu(Menu curMenu, List<Menu> subMenuList)
/*     */   {
/* 153 */     for (Menu menu : subMenuList) {
/* 154 */       if (menu.getAuthId().equals(curMenu.getParentAuthId())) {
/* 155 */         return Boolean.valueOf(true);
/*     */       }
/*     */     }
/*     */ 
/* 159 */     return Boolean.valueOf(false);
/*     */   }
/*     */ 
/*     */   private ArrayList<Menu> getSubMenuList(List<Menu> subMenuList, String parentId)
/*     */   {
/* 168 */     ArrayList result = new ArrayList();
/* 169 */     for (Menu menu : subMenuList) {
/* 170 */       if (parentId.equals(menu.getParentAuthId())) {
/* 171 */         result.add(menu);
/*     */       }
/*     */     }
/* 174 */     return result;
/*     */   }
/*     */ 
/*     */   public List<Auth> queryAuthByUserId(String userId)
/*     */   {
/* 179 */     return this.jwSystemAuthDao.queryAuthByUserId(userId);
/*     */   }
/*     */ 
/*     */   public List<Auth> queryAuthByAuthContr(String authContr)
/*     */   {
/* 184 */     return this.jwSystemAuthDao.queryAuthByAuthContr(authContr);
/*     */   }
/*     */ 
/*     */   public List<Auth> queryAuthByUserIdAndAuthContr(String userId, String authContr)
/*     */   {
/* 190 */     return this.jwSystemAuthDao.queryAuthByUserIdAndAuthContr(userId, authContr);
/*     */   }
/*     */ }

/* Location:           E:\eclipse_workspace\myproject\PatientVisit\WebContent\WEB-INF\lib\P3-Base-system-2.1-SNAPSHOT.jar
 * Qualified Name:     com.jeecg.p3.system.service.impl.JwSystemAuthServiceImpl
 * JD-Core Version:    0.6.2
 */