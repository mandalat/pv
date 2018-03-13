package org.jeecgframework.p3.cg.factory;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.p3.cg.CommonPageParser;
import org.jeecgframework.p3.cg.CreateBean;
import org.jeecgframework.p3.cg.def.CodeResourceUtil;
import org.jeecgframework.p3.cg.def.FreemarkerEngine;

public class CodeGenerateFactory
{
  private static final Log log = LogFactory.getLog(CodeGenerateFactory.class);
  private static String url = CodeResourceUtil.URL;
  private static String username = CodeResourceUtil.USERNAME;
  private static String passWord = CodeResourceUtil.PASSWORD;

  private static String buss_package = CodeResourceUtil.bussiPackage;

  public static void codeGenerateByVM(String tableName, String codeName, String keyType)
  {
    try
    {
      CreateBean createBean = new CreateBean();
      createBean.setMysqlInfo(url, username, passWord);

      String className = createBean.getTablesNameToClassName(tableName);
      String lowerName = className.substring(0, 1).toLowerCase() + className.substring(1, className.length());
      String tableNameUpper = tableName.toUpperCase();
      String tablesAsName = createBean.getTablesASName(tableName);
      if (StringUtils.isEmpty(codeName)) {
        Map tableCommentMap = createBean.getTableCommentMap();
        codeName = (String)tableCommentMap.get(tableNameUpper);
      }
      String sqlmapPathSrc = CodeResourceUtil.getConfigInfo("sqlmap_path_src");
      String domainPathSrc = CodeResourceUtil.getConfigInfo("domain_path_src");
      String daoPathSrc = CodeResourceUtil.getConfigInfo("dao_path_src");
      String daoImplPathSrc = CodeResourceUtil.getConfigInfo("dao_impl_path_src");
      String managerPathSrc = CodeResourceUtil.getConfigInfo("manager_path_src");
      String managerImplPathSrc = CodeResourceUtil.getConfigInfo("manager_impl_path_src");
      String servicePathSrc = CodeResourceUtil.getConfigInfo("service_path_src");
      String serviceImplPathSrc = CodeResourceUtil.getConfigInfo("service_impl_path_src");

      String sqlmapPackage = CodeResourceUtil.getConfigInfo("sqlmap_path");
      String domainPackage = CodeResourceUtil.getConfigInfo("domain_path");
      String daoPackage = CodeResourceUtil.getConfigInfo("dao_path");
      String daoImplPackage = CodeResourceUtil.getConfigInfo("dao_impl_path");
      String managerPackage = CodeResourceUtil.getConfigInfo("manager_path");
      String managerImplPackage = CodeResourceUtil.getConfigInfo("manager_impl_path");
      String servicePackage = CodeResourceUtil.getConfigInfo("service_path");
      String serviceImplPackage = CodeResourceUtil.getConfigInfo("service_impl_path");

      String sqlMapperPath = sqlmapPackage.replace(".", "\\") + "\\" + tableNameUpper + ".xml";
      String domainPath = domainPackage.replace(".", "\\") + "\\" + className + ".java";
      String daoPath = daoPackage.replace(".", "\\") + "\\" + className + "Dao.java";
      String daoImplPath = daoImplPackage.replace(".", "\\") + "\\" + className + "DaoImpl.java";
      String managerPath = managerPackage.replace(".", "\\") + "\\" + className + "Manager.java";
      String managerImplPath = managerImplPackage.replace(".", "\\") + "\\" + className + "ManagerImpl.java";
      String servicePath = servicePackage.replace(".", "\\") + "\\" + className + "Service.java";
      String serviceImplPath = serviceImplPackage.replace(".", "\\") + "\\" + className + "ServiceImpl.java";

      String sqlMapperFlag = CodeResourceUtil.getConfigInfo("sqlmap_flag");
      String domainFlag = CodeResourceUtil.getConfigInfo("domain_flag");
      String daoFlag = CodeResourceUtil.getConfigInfo("dao_flag");
      String daoImplFlag = CodeResourceUtil.getConfigInfo("dao_impl_flag");
      String managerFlag = CodeResourceUtil.getConfigInfo("manager_flag");
      String managerImplFlag = CodeResourceUtil.getConfigInfo("manager_impl_flag");
      String serviceFlag = CodeResourceUtil.getConfigInfo("service_flag");
      String serviceImplFlag = CodeResourceUtil.getConfigInfo("service_impl_flag");

      VelocityContext context = new VelocityContext();
      context.put("className", className);
      context.put("lowerName", lowerName);
      context.put("codeName", codeName);
      context.put("tableName", tableName);
      context.put("tableNameUpper", tableNameUpper);
      context.put("tablesAsName", tablesAsName);
      context.put("bussPackage", buss_package);
      context.put("domainPackage", domainPackage);
      context.put("daoPackage", daoPackage);
      context.put("daoImplPackage", daoImplPackage);
      context.put("managerPackage", managerPackage);
      context.put("managerImplPackage", managerImplPackage);
      context.put("servicePackage", servicePackage);
      context.put("serviceImplPackage", serviceImplPackage);
      context.put("keyType", keyType);

      context.put("feilds", createBean.getBeanFeilds(tableName, className));

      Map sqlMap = createBean.getAutoCreateSql(tableName);
      List columnDatas = createBean.getColumnDatas(tableName);
      context.put("columnDatas", columnDatas);
      List columnKeyDatas = createBean.getColumnKeyDatas(columnDatas);
      context.put("columnKeyDatas", columnKeyDatas);
      context.put("SQL", sqlMap);

      if ("Y".equals(sqlMapperFlag)) {
        CommonPageParser.WriterPage(context, "sqlmap.vm", sqlmapPathSrc, sqlMapperPath);
      }
      if ("Y".equals(domainFlag)) {
        CommonPageParser.WriterPage(context, "domainClass.vm", domainPathSrc, domainPath);
      }
      if ("Y".equals(daoFlag)) {
        CommonPageParser.WriterPage(context, "daoClass.vm", daoPathSrc, daoPath);
      }
      if ("Y".equals(daoImplFlag)) {
        CommonPageParser.WriterPage(context, "daoImplClass.vm", daoImplPathSrc, daoImplPath);
      }
      if ("Y".equals(managerFlag)) {
        CommonPageParser.WriterPage(context, "managerClass.vm", managerPathSrc, managerPath);
      }
      if ("Y".equals(managerImplFlag)) {
        CommonPageParser.WriterPage(context, "managerImplClass.vm", managerImplPathSrc, managerImplPath);
      }
      if ("Y".equals(serviceFlag)) {
        CommonPageParser.WriterPage(context, "serviceClass.vm", servicePathSrc, servicePath);
      }
      if ("Y".equals(serviceImplFlag)) {
        CommonPageParser.WriterPage(context, "serviceImplClass.vm", serviceImplPathSrc, serviceImplPath);
      }
      log.info("----------------------------代码生成完毕---------------------------");
      System.out.println("----------------------------代码生成完毕---------------------------");
    } catch (Exception e1) {
      e1.printStackTrace();
    }
  }

  public static void codeGenerateByFTL(String tableName, String codeName, String keyType)
  {
    try
    {
      CreateBean createBean = new CreateBean();
      createBean.setMysqlInfo(url, username, passWord);

      String className = createBean.getTablesNameToClassName(tableName);
      String lowerName = className.substring(0, 1).toLowerCase() + className.substring(1, className.length());
      String tableNameUpper = tableName.toUpperCase();
      String tablesAsName = createBean.getTablesASName(tableName);
      if (StringUtils.isEmpty(codeName)) {
         Map tableCommentMap = createBean.getTableCommentMap();
         codeName = (String)tableCommentMap.get(tableNameUpper);
      }

      String pathSrc = CodeResourceUtil.getConfigInfo("path_src");
      String basePackage = CodeResourceUtil.getConfigInfo("base_package");
      String bussiPackage = CodeResourceUtil.getConfigInfo("bussi_package");
      String author = CodeResourceUtil.getConfigInfo("author");
      String baseDao = CodeResourceUtil.getConfigInfo("baseDao");

      String sqlmapPackage = basePackage + "." + bussiPackage + ".sqlmap";
      String domainPackage = basePackage + "." + bussiPackage + ".entity";
      String daoPackage = basePackage + "." + bussiPackage + ".dao";
      String daoImplPackage = basePackage + "." + bussiPackage + ".dao.impl";
      String servicePackage = basePackage + "." + bussiPackage + ".service";
      String serviceImplPackage = basePackage + "." + bussiPackage + ".service.impl";
      String controllerPackage = basePackage + "." + bussiPackage + ".web.back";
      String domainQueryPackage = basePackage + "." + bussiPackage + ".vo";

      String pagePackage = "content." + bussiPackage + ".back";

      String sqlMapperPath = sqlmapPackage.replace(".", "\\") + "\\" + className + ".xml";
      String domainPath = domainPackage.replace(".", "\\") + "\\" + className + ".java";
      String daoPath = daoPackage.replace(".", "\\") + "\\" + className + "Dao.java";
      String daoImplPath = daoImplPackage.replace(".", "\\") + "\\" + className + "DaoImpl.java";
      String servicePath = servicePackage.replace(".", "\\") + "\\" + className + "Service.java";
      String serviceImplPath = serviceImplPackage.replace(".", "\\") + "\\" + className + "ServiceImpl.java";
      String controllerPath = controllerPackage.replace(".", "\\") + "\\" + className + "Controller.java";
      String domainQueryPath = domainQueryPackage.replace(".", "\\") + "\\" + className + "Vo.java";

      String pageIndexPath = pagePackage.replace(".", "\\") + "\\" + lowerName + "-list.vm";
      String pageAddPath = pagePackage.replace(".", "\\") + "\\" + lowerName + "-add.vm";
      String pageEditPath = pagePackage.replace(".", "\\") + "\\" + lowerName + "-edit.vm";
      String pageDetailPath = pagePackage.replace(".", "\\") + "\\" + lowerName + "-detail.vm";

      String sqlMapperFlag = CodeResourceUtil.getConfigInfo("sqlmap_flag");
      String domainFlag = CodeResourceUtil.getConfigInfo("domain_flag");
      String daoFlag = CodeResourceUtil.getConfigInfo("dao_flag");
      String daoImplFlag = CodeResourceUtil.getConfigInfo("dao_impl_flag");
      String serviceFlag = CodeResourceUtil.getConfigInfo("service_flag");
      String serviceImplFlag = CodeResourceUtil.getConfigInfo("service_impl_flag");
      String controllerFlag = CodeResourceUtil.getConfigInfo("controller_flag");
      String domainQueryFlag = CodeResourceUtil.getConfigInfo("domain_query_flag");

      String pageFlag = CodeResourceUtil.getConfigInfo("page_flag");

      Map sqlMap = createBean.getAutoCreateSql(tableName);
      List columnDatas = createBean.getColumnDatas(tableName);
      List columnKeyDatas = createBean.getColumnKeyDatas(columnDatas);
      String columnKeyParam = createBean.getColumnKeyParam(columnKeyDatas);
      String columnKeyUseParam = createBean.getColumnKeyUseParam(columnKeyDatas);
      SimpleDateFormat dateformat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");
      String nowDate = dateformat.format(new Date());
      System.out.println("时间:" + nowDate);

      Map root = new HashMap();
      root.put("author", author);
      root.put("baseDao", baseDao);
      root.put("className", className);
      root.put("lowerName", lowerName);
      root.put("codeName", codeName);
      root.put("tableName", tableName);
      root.put("tableNameUpper", tableNameUpper);
      root.put("tablesAsName", tablesAsName);
      root.put("bussPackage", bussiPackage);
      root.put("domainPackage", domainPackage);
      root.put("domainQueryPackage", domainQueryPackage);
      root.put("daoPackage", daoPackage);
      root.put("daoImplPackage", daoImplPackage);
      root.put("servicePackage", servicePackage);
      root.put("serviceImplPackage", serviceImplPackage);
      root.put("controllerPackage", controllerPackage);

      root.put("keyType", keyType);
      root.put("nowDate", nowDate);

      root.put("feilds", createBean.getBeanFeilds(tableName, className));
      root.put("queryfeilds", createBean.getQueryBeanFeilds(tableName, className));

      root.put("columnDatas", columnDatas);
      root.put("columnKeyDatas", columnKeyDatas);
      root.put("columnKeyParam", columnKeyParam);
      root.put("columnKeyUseParam", columnKeyUseParam);
      root.put("SQL", sqlMap);

      Configuration cfg = new Configuration();
      String templateBasePath = getClassPath() + CodeResourceUtil.getConfigInfo("templatepath_ftl");
      cfg.setDirectoryForTemplateLoading(new File(templateBasePath));
      cfg.setObjectWrapper(new DefaultObjectWrapper());
      if ("Y".equals(sqlMapperFlag)) {
        FreemarkerEngine.createFileByFTL(cfg, root, "sqlmap.ftl", pathSrc, sqlMapperPath);
      }
      if ("Y".equals(domainFlag)) {
        FreemarkerEngine.createFileByFTL(cfg, root, "domainClass.ftl", pathSrc, domainPath);
      }
      if ("Y".equals(daoFlag)) {
        FreemarkerEngine.createFileByFTL(cfg, root, "daoClass.ftl", pathSrc, daoPath);
      }
      if ("Y".equals(daoImplFlag)) {
        FreemarkerEngine.createFileByFTL(cfg, root, "daoImplClass.ftl", pathSrc, daoImplPath);
      }
      if ("Y".equals(serviceFlag)) {
        FreemarkerEngine.createFileByFTL(cfg, root, "serviceClass.ftl", pathSrc, servicePath);
      }
      if ("Y".equals(serviceImplFlag)) {
        FreemarkerEngine.createFileByFTL(cfg, root, "serviceImplClass.ftl", pathSrc, serviceImplPath);
      }
      if ("Y".equals(controllerFlag)) {
        FreemarkerEngine.createFileByFTL(cfg, root, "controllerClass.ftl", pathSrc, controllerPath);
      }
      if ("Y".equals(pageFlag)) {
        FreemarkerEngine.createFileByFTL(cfg, root, "pageIndex.ftl", pathSrc, pageIndexPath);
        FreemarkerEngine.createFileByFTL(cfg, root, "pageAdd.ftl", pathSrc, pageAddPath);
        FreemarkerEngine.createFileByFTL(cfg, root, "pageDetail.ftl", pathSrc, pageDetailPath);
        FreemarkerEngine.createFileByFTL(cfg, root, "pageEdit.ftl", pathSrc, pageEditPath);
      }
      if ("Y".equals(domainQueryFlag)) {
        FreemarkerEngine.createFileByFTL(cfg, root, "domainQueryClass.ftl", pathSrc, domainQueryPath);
      }

      log.info("----------------------------代码生成完毕---------------------------");
      System.out.println("----------------------------代码生成完毕---------------------------");
    } catch (Exception e1) {
      e1.printStackTrace();
    }
  }

  public static String getProjectPath()
  {
    String path = System.getProperty("user.dir").replace("\\", "/") + "/";
    return path;
  }

  public static String getClassPath()
  {
    String path = new CodeGenerateFactory().getClass().getResource("/").getPath();
    return path;
  }
}