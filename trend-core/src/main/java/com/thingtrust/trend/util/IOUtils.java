package com.thingtrust.trend.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class IOUtils {
    public static void write(final StringBuffer stringBuffer) {
        try {
            /* 写入Txt文件 */
            final File writename = new File("/Users/liwang/IdeaProjects/springboot-trend/trend-core/src/main/resources/templates/payment.sh");
            writename.createNewFile(); // 创建新文件
            final BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(stringBuffer.toString());
            out.flush();
            out.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
