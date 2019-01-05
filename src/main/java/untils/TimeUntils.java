package untils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUntils {
    /**
     * 获取当前时间
     * @return
     */
    public static String getNowTime(){
        String nowTime="";
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        nowTime=dateString;
        return nowTime;
    }

    /*public static void main(String[] arg){
        System.out.println(getNowTime());
    }*/
}
