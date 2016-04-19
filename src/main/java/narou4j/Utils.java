package narou4j;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import narou4j.enums.RankingType;
import okhttp3.Response;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;

import static narou4j.enums.RankingType.*;

class Utils {

    static List<Novel> response2Json4Novel(Response response, boolean isGzip) {
        ObjectMapper mapper = new ObjectMapper();
        String str = getBodyString(response, isGzip);

        List<Novel> novels = null;
        try {
            novels = mapper.readValue(str, new TypeReference<List<Novel>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return novels;
    }

    static List<NovelRank> response2Json4Ranking(Response response, boolean isGzip) {
        ObjectMapper mapper = new ObjectMapper();
        String str =  getBodyString(response, isGzip);

        List<NovelRank> rankings = null;
        try {
            rankings = mapper.readValue(str, new TypeReference<List<NovelRank>>() { });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rankings;
    }

    private static String getBodyString(Response response, boolean isGzip) {
//        try {
//            String string = response.body().string();
//            System.out.println(string);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        if (isGzip) {
            try {
                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(new GZIPInputStream(response.body().byteStream())))) {

                    StringBuilder builder = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        builder.append(line);
                    }

                    return builder.toString();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                return  response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    static String day2ThuesDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        calendar.setTime(date);

        int week = calendar.get(Calendar.DAY_OF_WEEK);
        if (week == Calendar.MONDAY || week == Calendar.SUNDAY) {
            week += 7;
        }
        calendar.add(Calendar.DAY_OF_MONTH,  -week);
        calendar.add(Calendar.DAY_OF_MONTH, Calendar.TUESDAY);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(calendar.getTime());
    }

    static String day2MonthOne(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        calendar.setTime(date);

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DAY_OF_MONTH, -day +1);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(calendar.getTime());
    }

    static String getRankingType2String(RankingType type, Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        StringBuilder builder = new StringBuilder();
        switch (type) {
            case DAILY: {
                builder.append(format.format(date));
                builder.append(type.getId());
                break;
            }
            case WEEKLY: {
                builder.append(Utils.day2ThuesDay(date));
                builder.append(type.getId());
                break;
            }
            case MONTHLY: {
                builder.append(Utils.day2MonthOne(date));
                builder.append(type.getId());
                break;
            }
            case QUARTET: {
                builder.append(Utils.day2MonthOne(date));
                builder.append(type.getId());
                break;
            }
            default: {
                return "";
            }
        }
        System.out.println(builder.toString());
        return builder.toString();
    }
}
