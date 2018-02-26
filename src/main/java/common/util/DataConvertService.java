package common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jiangxiangwen
 * @ClassName DataConvert$
 * @Description 时间封装方法
 * @date 2018/1/15/
 */

/**
     SimpleDateFormat函数语法：
     G 年代标志符
     y 年
     M 月
     d 日
     h 时 在上午或下午 (1~12)
     H 时 在一天中 (0~23)
     m 分
     s 秒
     S 毫秒
     E 星期
     D 一年中的第几天
     F 一月中第几个星期几
     w 一年中第几个星期
     W 一月中第几个星期
     a 上午 / 下午 标记符
     k 时 在一天中 (1~24)
     K 时 在上午或下午 (0~11)
     z 时区
     */
    public class DataConvertService {
        /**
         * @Title: dateyMdHms
         * @Description: 将时间转换成年月日时分秒
         * @author jiangxiangwen
         * @date 2018/1/15
         * @param date  时间
         * @return 返回字符串类型的时间格式
         */
        public String dateyMdHms(Date date){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.format(date);
        }

    /**
     * @Title: dateyMd
     * @Description: 将时间转换成年月日
     * @author jiangxiangwen
     * @date 2018/1/15
     * @param date  时间
     * @return  返回字符串类型的时间格式
     *
     */
    public String dateyMd(Date date){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * @Title: dateWeek
     * @Description: 将时间转换星期
     * @author jiangxiangwen
     * @date 2018/1/15
     * @param date  时间
     * @return  返回字符串类型的时间格式
     *
     */
    public String dateWeek(Date date){
        SimpleDateFormat format=new SimpleDateFormat("E");
        return format.format(date);
    }

    /**
     * @Title: dateYearDay
     * @Description: 一年中的第几天
     * @author jiangxiangwen
     * @date 2018/1/15
     * @param date  时间
     * @return  返回字符串类型的时间格式
     *
     */
    public String dateYearDay(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("D");
        return format.format(date);
    }

    /**
     * @Title: dateYearWeek
     * @Description: 一年中第几个星期
     * @author jiangxiangwen
     * @date 2018/1/15
     * @param date  时间
     * @return  返回字符串类型的时间格式
     *
     */
    public String dateYearWeek(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("w");
        return format.format(date);
    }
}
