package com.jia.code.generator.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


public class DateUtil {

	// 鏃堕棿鏍煎紡
	private static SimpleDateFormat SDF_YMDHMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat SDF_Y_M_D = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat SDF_YMDHMS_FNAME = new SimpleDateFormat("yyyyMMddHHmmss");
	private static SimpleDateFormat SDF_YMD = new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat SDF_MD = new SimpleDateFormat("MMdd");
	private static SimpleDateFormat SDF_CHINA_MD = new SimpleDateFormat("MM鏈坉d鏃�");


	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }
    
	
	
	public static String getYmdhms() {
		return SDF_YMDHMS.format(new Date());
	}
	public static String getY_m_d(Date date) {
		return SDF_Y_M_D.format(date);
	}

	public static Date changeStrToDate(String dateStr) {
		try {
			return  SDF_Y_M_D.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date changeStrToDate(String dateStr, String pattern) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return  df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getYmdhmsFName() {
		return SDF_YMDHMS_FNAME.format(new Date());
	}

	public static String getYmd() {
		return SDF_YMD.format(new Date());
	}

	/**
	 * @author chenyi
	 * @Description: 鑾峰彇MMDD鏃堕棿鏍煎紡
	 * @param tags
	 * @date 2017-1-31 涓嬪崍1:14:19
	 */
	public static String getMd() {
		return SDF_MD.format(new Date());
	}

	/**
	 * @author chenyi
	 * @Description 鑾峰彇涓枃鐨勬湀鏃ユ牸寮�
	 * @param
	 * @date 2017-6-2 涓嬪崍3:19:23
	 */
	public static String getChinaMd(String dateStr) {
		if (StringUtils.isEmpty(dateStr))
			return "";
		Date date = null;
		try {
			date = SDF_Y_M_D.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return SDF_CHINA_MD.format(date);
	}

	/**
	 * @author chenyi
	 * @Description 鑾峰彇鍓嶅悗鍑犲垎閽熺殑鏃堕棿
	 * @param
	 * @date 2017-3-3 涓嬪崍2:11:14
	 */
	public static String getTimeByMinute(int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, minute);
		return SDF_YMDHMS.format(calendar.getTime());

	}

	/**
	 * @author chenyi
	 * @Description 鑾峰彇鍓嶅悗鍑犲ぉ鐨勬棩鏈�
	 * @param
	 * @date 2017-3-3 涓嬪崍2:11:14
	 */
	public static String getDateByDay(int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, day);
		return SDF_Y_M_D.format(calendar.getTime());

	}

	/**
	 * @author chenyi
	 * @Description 鏍规嵁浼犲叆鐨勬椂闂翠覆鏍煎紡鍖栨椂闂�
	 * @param
	 * @date 2017-3-20 涓嬪崍3:50:50
	 */
	public static String getYmdDate(Date date) {
		return SDF_Y_M_D.format(date);
	}
	public static String getYmdhmsDate(Date date) {
		return SDF_YMDHMS.format(date);
	}

	/**
	 * @author chenyi
	 * @Description 姣旇緝涓や釜鏃ユ湡鐨勫ぇ灏�
	 * @param
	 * @return 0:琛ㄧず鐩哥瓑 -1:DATE2鍦―ATE1涔嬪墠 1:DATE2鍦―ATE1涔嬪悗
	 * @date 2017-3-13 涓嬪崍4:25:47
	 */
	public static int compareDate(Date DATE1, Date DATE2) {
		try {
//			Date dt1 = SDF_Y_M_D.parse(DATE1);
//			Date dt2 = SDF_Y_M_D.parse(DATE2);
			if (DATE1.getTime() > DATE2.getTime()) {
				return 1;
			} else if (DATE1.getTime() < DATE2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * @author chenyi
	 * @Description 璺熷綋鍓嶆椂闂存瘮杈冨ぇ灏�
	 * @param
	 * @date 2017-3-13 涓嬪崍4:50:35
	 */
	public static int compareDate(Date DATE) {
		return compareDate((new Date()), DATE);
	}

	/**
	 * 比较两个时间大小（精确到时分秒）
	 * 
	 * @param timeone
	 *            格式（2017-02-07）
	 * @param timetow
	 *            格式（2017-02-07）
	 * @param type
	 *            (1比较大小有等于 2比较大小没等于)
	 * @return 1(timeone>timetow) -1(timeone<timetow) 2(timeone=timetow) 0错误
	 *         3(timeone>=timetow) -3(timeone<=timetow)
	 */
	public static int compare_dateTime(String timeone, String timetow, int type) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date dateone = sdf.parse(timeone);
			Date datetow = sdf.parse(timetow);
			if (type == 1) {
				if (dateone.getTime() >= datetow.getTime()) {
					return 3;
				} else if (dateone.getTime() <= datetow.getTime()) {
					return -3;
				} else if (dateone.getTime() == datetow.getTime()) {
					return 2;
				}
			} else if (type == 2) {
				if (dateone.getTime() > datetow.getTime()) {
					return 1;
				} else if (dateone.getTime() < datetow.getTime()) {
					return -1;
				} else if (dateone.getTime() == datetow.getTime()) {
					return 2;
				}
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 比较两个时间大小（精确到天）
	 * 
	 * @param timeone
	 *            格式（2017-02-07）
	 * @param timetow
	 *            格式（2017-02-07）
	 * @param type
	 *            (1比较大小有等于 2比较大小没等于)
	 * @return 1(timeone>timetow) -1(timeone<timetow) 2(timeone=timetow) 0错误
	 *         3(timeone>=timetow) -3(timeone<=timetow)
	 */
	public static int compare_date(String timeone, String timetow, int type) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dateone = sdf.parse(timeone);
			Date datetow = sdf.parse(timetow);
			if (type == 1) {
				if (dateone.getTime() >= datetow.getTime()) {
					return 3;
				} else if (dateone.getTime() <= datetow.getTime()) {
					return -3;
				} else if (dateone.getTime() == datetow.getTime()) {
					return 2;
				}
			} else if (type == 2) {
				if (dateone.getTime() > datetow.getTime()) {
					return 1;
				} else if (dateone.getTime() < datetow.getTime()) {
					return -1;
				} else if (dateone.getTime() == datetow.getTime()) {
					return 2;
				}
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * @author chenyi
	 * @Description 时间字符串，转时间戳
	 * @param
	 * @date 2017年8月5日 下午3:49:53
	 */
	public static String getTime(String dateStr) {
		String re_time = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d;
		try {
			d = sdf.parse(dateStr);
			long l = d.getTime();
			String str = String.valueOf(l);
			re_time = str.substring(0, 10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return re_time;
	}
	/**
	 * @author chenjiabin
	 * @Description 修改时间格式 yyyy-MM-dd 23:59:59
	 * @param
	 * @date
	 */
	public static Date changeDate(Date date) {
		String dateStr = SDF_Y_M_D.format(date);
		dateStr= dateStr + " 23:59:59";
		Date date2 = null;
		try {
			date2 = SDF_YMDHMS.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date2;
	}
	
	/**
	 * 获取截止月底时间秒数
	 * @Title: getEndSecondOfTheMonth
	 * @data:2018-04-16 11:10
	 * @author:zhangsy
	 *
	 * @return
	 */
	public static int getEndSecondOfTheMonth(){
		DateFormat format = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(format.parse(format.format(new Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	calendar.add(Calendar.MONTH, 1);
    	calendar.add(Calendar.SECOND, -1);
    	long time = calendar.getTimeInMillis() / 1000;
        long now = System.currentTimeMillis() / 1000;
    	return (int)(time - now);
    }
	
	/**
	 * 获取当天结束时间秒数
	 * @Title: getDayEnd
	 * @data:2018-04-24 09:34
	 * @author:zhangsy
	 *
	 * @return
	 */
    public static int getDayEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        long time = cal.getTimeInMillis() / 1000;
        long now = System.currentTimeMillis() / 1000;
        return (int)(time - now);
    }

	/**
	 * 获取月初日期
	 * @Title: monthFirstDay
	 * @data:2018-04-17 16:10
	 * @author:zhangsy
	 *
	 * @param date
	 * @return
	 */
	 public static String monthFirstDay(String date){
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		try {
			if(!date.isEmpty()){
				Date curr = format.parse(date);
				calendar.setTime(curr);
			}else{
				Date curr = format.parse(format.format(new Date()));
				calendar.setTime(curr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	 }
	
	/**
	 * 获取月底日期
	 * @Title: monthLastDay
	 * @data:2018-04-17 16:10
	 * @author:zhangsy
	 *
	 * @param date
	 * @return
	 */
	 public static String monthLastDay(String date){
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		try {
			if(!date.isEmpty()){
				Date curr = format.parse(date);
				calendar.setTime(curr);
			}else{
				Date curr = format.parse(format.format(new Date()));
				calendar.setTime(curr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	calendar.add(Calendar.MONTH, 1);
    	calendar.add(Calendar.DAY_OF_MONTH, -1);
    	return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	 }
	 
	 /**
	 * 获得时间相减天数
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long getDaySub(Date startTime,Date endTime){
		long day=0;
		day=(endTime.getTime()-startTime.getTime())/(24*60*60*1000);
		return day+1;
	}
	
	/**
	 * 按天增加时间
	 * @param date
	 * @param day
	 * @return
	 * @throws Exception
	 */
	public static Date changeDayExpireTime(Date date,int day) throws Exception {
		Date now = new Date();
		Calendar calendar = new GregorianCalendar();
		if (date.after(now)) {
			calendar.setTime(date);
			calendar.add(Calendar.DATE, day);// 把日期往后增加月.整数往后推,负数往前移动
			date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		} else {
			calendar.setTime(now);
			calendar.add(Calendar.DATE, day);// 把日期往后增加一月.整数往后推,负数往前移动
			date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		}
		return date;
	}
	
	/**
	 * 校验传入的时间是否为今天
	 * @param date 
	 * @return true or false
	 */
	public static boolean isToday(Date date) {
		if (date != null) {
			Calendar curCalnedar = Calendar.getInstance();
			
			Calendar dateCalendar = Calendar.getInstance();
			dateCalendar.setTime(date);
			
			if (curCalnedar.get(Calendar.YEAR) == dateCalendar.get(Calendar.YEAR)
					&& curCalnedar.get(Calendar.MONTH) == dateCalendar.get(Calendar.MONTH)
					&& curCalnedar.get(Calendar.DATE) == dateCalendar.get(Calendar.DATE)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 获取当前周所有日期
	 * 时间类型 yyyy-MM-dd
	 * @return
	 */
	public static List<String> getCurrentWeekRange() {
        List<String> dataList = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);//设置周一为一周之内的第一天
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String monday = dateFormat.format(calendar.getTime());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        String tuesday = dateFormat.format(calendar.getTime());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        String wednesday = dateFormat.format(calendar.getTime());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        String thursday = dateFormat.format(calendar.getTime());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        String friday = dateFormat.format(calendar.getTime());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        String saturday = dateFormat.format(calendar.getTime());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        String sunday = dateFormat.format(calendar.getTime());
        dataList.add(monday);
        dataList.add(tuesday);
        dataList.add(wednesday);
        dataList.add(thursday);
        dataList.add(friday);
        dataList.add(sunday);
        dataList.add(saturday);
        dataList.add(sunday);
        return dataList;
    }
	
	 /**
     * 获取过去 任意天内的日期数组
     * @param intervals      intervals天内
     * @return              日期数组
     */
    public static ArrayList<String> getPastDaysList(int intervals ) {
        ArrayList<String> pastDaysList = new ArrayList<>();
        for (int i = 0; i <intervals; i++) {
            pastDaysList.add(getPastDate(i));
        }
        return pastDaysList;
    }
    
    /**
     * 获取未来 任意天内的日期数组
     * @param intervals      intervals天内
     * @return              日期数组
     */
    public static ArrayList<String> getFetureDaysList(int intervals ) {
    	ArrayList<String> fetureDaysList = new ArrayList<>();
    	for (int i = 0; i <intervals; i++) {
    		fetureDaysList.add(getFetureDate(i));
    	}
    	return fetureDaysList;
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    /**
     * 获取未来 第 past 天的日期
     * @param past
     * @return
     */
    public static String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }
    
    /**
     * 获取未来 第 past 天的日期
     * @param past
     * @return
     */
    public static Date getAddDate(Date date, int hours) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);   //设置时间  
    	calendar.add(Calendar.HOUR, hours); //日期分钟加1,Calendar.DATE(天),Calendar.HOUR(小时)    
        return calendar.getTime();
    }
    
    /**
     * 给时间加上几个小时
     * @param date 
     * @param hour 需要加的时间
     * @return
     */
    public static Date addDateMinut(Date date, int hour){   
        Calendar cal = Calendar.getInstance();   
        cal.setTime(date);   
        cal.add(Calendar.HOUR, hour);// 24小时制   
        date = cal.getTime();   
        return date; 
    }
    
}
