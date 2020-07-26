package com.mong.cmmn.util;

import org.apache.log4j.Logger;

import com.mong.cmmn.constant.EncType;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class EncUtil {
    private static Logger log = Logger.getLogger(EncUtil.class);

    public static String getCryptPwd(String cryptType, String password) {
        String cryptPwd = "";

        if (EncType.SHA256.equals(cryptType)) {
            cryptPwd = EncUtil.getSHA256Code( password );
        } else if (EncType.DBCRYPT.equals(cryptType)) {
            //CmsMemberService memberService = Common.getBean(CmsMemberService.class);

            Map<String, Object> param = new HashMap<String, Object>();
            param.put("userPwd", password);

            //cryptPwd = memberService.selectCryptPwd(param);
        } else {
            cryptPwd = StringUtil.defaultString(password);
        }

        return cryptPwd;
    }

    public static String getSHA256Code(String str)
    {
        String SHA256 = "";
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(str.getBytes());
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < byteData.length; i++)
                sb.append(Integer.toString((byteData[i] & 0xff) + 256, 16).substring(1));

            SHA256 = sb.toString();
        }
        catch(NoSuchAlgorithmException e)
        {
            log.info("=============== EncUtil getSHA256Code Error ===================");
            log.info(e.getLocalizedMessage());
            log.info("=============== EncUtil getSHA256Code Error ===================");
            SHA256 = "";
        }
        return SHA256;
    }
}
