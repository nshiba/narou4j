package narou4j;

import narou4j.enums.*;
import narou4j.exception.NarouDuplicateException;
import narou4j.exception.NarouOutOfRangeException;

import javax.rmi.CORBA.Util;
import java.text.SimpleDateFormat;
import java.util.*;

import static narou4j.enums.RankingType.*;

public class GetParameter4Ranking {
    Map<String, String> params = new HashMap<>();
    boolean isGzip = true;

    /**
     * 出力結果をgzipに圧縮します．
     * デフォルトは 5
     * 転送量上限を減らすためにも推奨
     *
     * @param rate 圧縮レベルは1 ~ 5
     */
    public void setGzip(int rate) {
        if (rate < 1 || rate > 5) {
            throw new NarouOutOfRangeException("out of gzip Compression level (1 ~ 5)");
        }

        params.put("gzip", String.valueOf(rate));
        isGzip = true;
    }

    /**
     * 出力結果をgzipに圧縮して返すためのパラメータ
     * デフォルトは 5 になっているので解除するメソッド
     */
    public void notGzip() {
        params.remove("gzip");
        isGzip = false;
    }
}
