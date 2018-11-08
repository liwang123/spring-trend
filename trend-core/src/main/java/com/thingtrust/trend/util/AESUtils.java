package com.thingtrust.trend.util;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;

/**
 * Created by tiny on 2018/6/27.
 *
 * @author tiny
 * @date 2018/06/27
 */
public class AESUtils {

    /**
     * AES解密
     *
     * @param data      //密文，被加密的数据
     * @param key      //秘钥
     * @param iv       //偏移量
     * @param encodingFormat //解密后的结果需要进行的编码
     * @return
     * @throws Exception
     */
    public static String decrypt(String data, String key, String iv, String encodingFormat) throws Exception {
//    initialize();

        //被加密的数据
        byte[] dataByte = Base64.decodeBase64(data);
        //加密秘钥
        byte[] keyByte = Base64.decodeBase64(key);
        //偏移量
        byte[] ivByte = Base64.decodeBase64(iv);


        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");

            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));

            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, encodingFormat);
                return result;
            }
            return null;
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) throws Exception {
        String data = "hello";
        String key = "hi";
//        String cipher = AESUtils.encrypt(data, key);
        String encry ="7ckFirbVun2Wn8pV+qB3GCEXBxacISVqRAs6qG54fEy7bvIRbE+pdP8LT94Zl/ix94DM6WbSdJg9QP0rj/XN+uBxfTlZ/cSoDzLjJboiL9JCJ4h/WlixxCE/DYPwvjyTg6rXoJ66jrDmaYbWCrSEnBKrTdzT7V8147AbiBv00rixhsmC9iwIFOXMnr1Kd8a7QsQLa61tobAmHHwnjTVo7XyNpczPwb85h16PzC9P0HHwVv7vUArLrVwJA2I6B2s8lnsOpgOG2SzQ8Q5PXj5KEoqBfLCN3HqT/vFOz2VEjB733GTk0+O9IwX5+vHr/lo4puIQLvgGeoza8N4njHfX/KCtZ5Q04LDPE/QM5RbIPJwWDcvk8w1Vmk/4q6PtAwpZE4EM1kqeXi8mS/CdNJCxfWmRW/XmpPGNNvPl8xfDRC4sIxEN26O7iamTp5UsUZ/lf7Dw7HvXTONl7nNY5nCd48mUCdkf2/bMM2tNkWeg0/0=";
        String sessionKey = "iD9SU6y61Zqpbf3jRDhVKA==";
        String iv = "U+1l4Rxqy6I8srsjdoiJGw==";

        String decipher = AESUtils.decrypt(encry, sessionKey,iv,"UTF-8");
//        System.out.println(cipher);
        System.out.println(decipher);
    }
}
