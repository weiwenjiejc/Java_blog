package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {
    public static String getDateTime() {
        Date date = new Date();
        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = SimpleDateFormat.format(date);
        return datetime;
    }

    public static void main(String[] args) {
        System.out.println(getDateTime());
    }
}
