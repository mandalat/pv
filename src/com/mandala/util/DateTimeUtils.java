package com.mandala.util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	//SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
	//SimpleDateFormat sdf3 = new SimpleDateFormat("HHmmssSSS"); 
	//SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy年M月dd日"); 
	
	Date date = new Date();
	Calendar calendar = Calendar.getInstance();
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getMon() {
		return mon;
	}
	public void setMon(int mon) {
		this.mon = mon;
	}
	public void setDay(int day) {
		this.day = day;
	}

	int year = calendar.get(Calendar.YEAR);
	int mon = calendar.get(Calendar.MONTH);//获取本月是第几月  从0开始
	int day = calendar.get(Calendar.DAY_OF_MONTH);//今天是当月的第几天 1开始
	/**
	 * 返回当前月，是一年中的第几月，从0开始
	 * @return
	 */
	public int getMonth() {
		return mon;
	}
	/**
	 * 返回当前年
	 * @return
	 */
	public int getYear() {
		return year;
	}
	/**
	 * 返回当前日
	 * @return
	 */
	public int getDay() {
		return day;
	}
	/**
	 * 获取当天日期 yyyy-MM-dd
	 * @return
	 */
	public String getToday(){
		return sdf1.format(date);
	}
	/**
	 * 获取当天日期 
	 * @param format "yyyy-MM-dd"
	 * @return
	 */
	public String getToday(String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	/**
	 * 获取当前时间
	 * @return
	 */
	public String getCurrentTime(){
		return getToday("HH:mm:ss");
	}
	/**
	 * 获取当前时间
	 * @param format 格式
	 * @return
	 */
	public String getCurrentTime(String format){
		return getToday(format);
	}
	/**
	 * 当月第一天
	 * @return
	 */
	public Date getMonthFirstDay(){
		calendar.setTime(date);
		calendar.set(Calendar.MONTH,mon); //设置月份为
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));  
	    Date firstDay = calendar.getTime();  //上月第一天
	    return firstDay;
	}
	/**
	 * 当月最后一天
	 * @return
	 */
	public Date getMonthLastDay(){
		calendar.setTime(date);
		calendar.set(Calendar.MONTH,mon); //设置月份为
	    calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
	    Date lastDay = calendar.getTime();  //上月最后一天
	    return lastDay;
	}
	public Date getLastMonthFirstDay(){
		calendar.setTime(date);
		calendar.set(Calendar.MONTH,mon-1); //设置月份为上月
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));  
	    Date firstDay = calendar.getTime();  //上月第一天
	    return firstDay;
	}
	public Date getLastMonthLastDay(){
		calendar.setTime(date);
		calendar.set(Calendar.MONTH,mon-1); //设置月份为上月
	    calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
	    Date lastDay = calendar.getTime();  //上月最后一天
	    return lastDay;
	}
	public String getLastMonthFirstDay(String format){
		calendar.setTime(date);
		calendar.set(Calendar.MONTH,mon-1); //设置月份为上月
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));  
	    Date firstDay = calendar.getTime();  //上月第一天
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(firstDay);
	}
	public String getLastMonthToday(String format){
		calendar.setTime(date);
		calendar.set(Calendar.MONTH,mon-1); //设置月份为上月
		calendar.set(Calendar.DAY_OF_MONTH,day);  
	    Date today = calendar.getTime();  //上月这一天
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(today);
	}
	public String getLastMonthLastDay(String format){
		calendar.setTime(date);
		calendar.set(Calendar.MONTH,mon-1); //设置月份为上月
	    calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
	    Date lastDay = calendar.getTime();  //上月最后一天
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(lastDay);
	}
	public Date getLastQuarterFisrtDay(){
		calendar.setTime(date);
		calendar.set(Calendar.MONTH,mon-3); //设置为税款所属月份的上个月，目的是 查询税款所属月份的期初数（从它的上个月份中查询出）。
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));  
		Date firstDay = calendar.getTime();  //第一天
		return firstDay;	
	}
	
	/**
	 * 获取上个月税款所属期起止
	 * @return
	 */
	public String getLastMonth(){
		return sdf1.format(getLastMonthFirstDay())+","+sdf1.format(getLastMonthLastDay());
	}
	/**
	 * 获取上个月税款所属期起止
	 * @param format 格式
	 * @return
	 */
	public String getLastMonth(String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(getLastMonthFirstDay())+","+sdf.format(getLastMonthLastDay());
	}
	/**
	 * 上个季度的所属期起止
	 * @return
	 */
	public String getLastQuarter(){
		return sdf1.format(getLastQuarterFisrtDay())+","+sdf1.format(getLastMonthLastDay());
	}
	/**
	 * 上个季度的所属期起止
	 * @param format
	 * @return
	 */
	public String getLastQuarter(String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(getLastQuarterFisrtDay())+","+sdf.format(getLastMonthLastDay());
	}
	/**
	 * 上一年度所属期起止
	 * @return
	 */
	public String getLastYear(){
		Date beginDate,endDate;
		calendar.setTime(date);
		calendar.set(Calendar.YEAR, year-1);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		beginDate=calendar.getTime();
		
		calendar.setTime(date);
		calendar.set(Calendar.YEAR, year-1);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		endDate=calendar.getTime();
		return sdf1.format(beginDate)+","+sdf1.format(endDate);
	}
	/**
	 * 上一年度所属期起止
	 * @param format
	 * @return
	 */
	public String getLastYear(String format){
		Date beginDate,endDate;
		calendar.setTime(date);
		calendar.set(Calendar.YEAR, year-1);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		beginDate=calendar.getTime();
		
		calendar.setTime(date);
		calendar.set(Calendar.YEAR, year-1);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		endDate=calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(beginDate)+","+sdf.format(endDate);
	}
	
	/**
	 * 获取当月税款所属期起止
	 * @return
	 */
	public String getThisMonth(){
		return sdf1.format(getMonthFirstDay())+","+sdf1.format(getMonthLastDay());
	}
	/**
	 * 获取当月税款所属期起止
	 * @param format 格式
	 * @return
	 */
	public String getThisMonth(String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(getMonthFirstDay())+","+sdf.format(getMonthLastDay());
	}
	/**
	 * 获取税款所属期
	 * @param nsqxDm 纳税期限代码
	 * @return
	 */
	public String[] getSkssq(String nsqxDm){
		return getSkssq(nsqxDm,"yyyy-MM-dd");
	}
	/**
	 * 获取税款所属期
	 * @param nsqxDm 纳税期限代码
	 * @param format
	 * @return
	 */
	public String[] getSkssq(String nsqxDm,String format){
		String skssqqz = "";
		DateTimeUtils skssq = new DateTimeUtils();
		if(nsqxDm.equals("06")){
			
			skssqqz = skssq.getLastMonth(format);
		}
		else if(nsqxDm.equals("08")){
		
			skssqqz = skssq.getLastQuarter(format);
		}
		else if(nsqxDm.equals("10")){
		
			skssqqz = skssq.getLastYear(format);
		}else if(nsqxDm.equals("100")){//张亮自定义的查询当月的税款所属期
			skssqqz = skssq.getThisMonth(format);
		}
		return skssqqz.split(",");
	}
	/**
	 * 将起止日期转成数组
	 * @param str
	 * @return
	 */
	public String[] toStrArray(String str){
		return str.split(",");
		
	}
	
	
	public static void main(String[] args) {
		DateTimeUtils sq= new DateTimeUtils();
		System.out.println(sq.year);
		System.out.println(sq.mon);
		System.out.println(sq.day);
		System.out.println(sq.getToday());
		System.out.println(sq.getLastMonthToday("yyyy-MM-dd"));
		System.out.println(sq.getToday("yyyy年M月dd日"));
		System.out.println(sq.getLastMonthFirstDay("yyyy年M月dd日"));
		System.out.println(sq.getLastYear());
		System.out.println(sq.toStrArray(sq.getLastMonth())[0]);
	}
}
