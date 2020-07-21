package com.mong.cmmn.util;

import org.apache.log4j.Logger;

public class XSSFilterUtil {
	static Logger log = Logger.getLogger(XSSFilterUtil.class);

	public static String doFilter(String value) {
        if (value == null) {
            value = "";
        } else {
            //log.info("value 2: " + value);
            //value = StringUtil.stripValueXSS(value);
            //value = StringUtil.convertRemark(value);
            //log.info("value 3: " + value);
            //value = StringEscapeUtils.escapeSql(value);
            //log.info("value 4: " + value);
            //value = value.replaceAll("\\r|\\n|\\t", "");
            //log.info("value 5: " + value);
            value = value.replaceAll("''", "'");
            value = value.trim();
        }

        return value;
	}
}
