package org.conan.taobao;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public final class TaoBaoAuth {
    
    /**
     * 签名运算
     * @param parameter
     * @param secret
     * @return
     */
    public static String sign(String parameter, String secret) {
        // 对参数+密钥做MD5运算
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] digest = md.digest((parameter + secret).getBytes());

        // 对运算结果做BASE64运算并加密
        BASE64Encoder encode = new BASE64Encoder();
        return encode.encode(digest);
    }

    /**
     * 验证签名
     * @param sign
     * @param parameter
     * @param secret
     * @return
     */
    public static boolean validateSign(String sign, String parameter, String secret) {
        boolean tmp = sign != null 
        && parameter != null // 注意，这个parameter并不就是上面的top_paramater，而是指的待签名验证的参数，即上面的top_appkey+top_parameter+top_session
        && secret != null 
        && sign.equals(sign(parameter, secret));
        System.out.println("Valid Sign = "+ tmp);
        return tmp;
    }
    
    /**
     * 把经过BASE64编码的字符串转换为Map对象
     * @param str
     * @return
     */

    public static Map<String, String> convertBase64StringtoMap(String str){
       if(str == null) {
           return null;
       }
       
       BASE64Decoder decoder = new BASE64Decoder();
       String keyvalues = null;
       try {
           keyvalues = new String(decoder.decodeBuffer(str));
       } catch (IOException e) {
           System.err.println(str + "不是一个合法的BASE64编码字符串");
           return null;
       }
       if(keyvalues == null || keyvalues.length() == 0){
           return null;
       }

       String[] keyvalueArray = keyvalues.split("&");
       Map<String, String> map = new HashMap<String, String>();
       for(String keyvalue:keyvalueArray){
           String[] s = keyvalue.split("=");
           if(s==null || s.length!=2){
              return null;
           }
           map.put(s[0], s[1]);
       }
       return map;
    } 
    
    /** 
     * 验证TOP回调地址的签名是否合法。要求所有参数均为已URL反编码的。 
     *  
     * @param topParams TOP私有参数（未经BASE64解密） 
     * @param topSession TOP私有会话码 
     * @param topSign TOP回调签名 
     * @param appKey 应用公钥 
     * @param appSecret 应用密钥 
     * @return 验证成功返回true，否则返回false 
     * @throws NoSuchAlgorithmException 
     * @throws IOException 
     */ 
    public static boolean verifyTopResponse(String topParams, String topSession, String topSign,String appKey, String appSecret) throws NoSuchAlgorithmException, IOException { 
        StringBuilder result = new StringBuilder(); 
        MessageDigest md5 = MessageDigest.getInstance("MD5"); 
        result.append(appKey).append(topParams).append(topSession).append(appSecret); 
        byte[] bytes = md5.digest(result.toString().getBytes("UTF-8")); 
        BASE64Encoder encoder = new BASE64Encoder(); 
        return encoder.encode(bytes).equals(topSign); 
    }
    
    @SuppressWarnings("rawtypes")
    public static String parametersName(String top_parameters){
        String nick=null; 
        Map<String, String> map= convertBase64StringtoMap(top_parameters); 
        Iterator keyValuePairs = map.entrySet().iterator(); 
        for (int i = 0; i < map.size(); i++) { 
            Map.Entry entry = (Map.Entry) keyValuePairs.next(); 
            Object key = entry.getKey(); 
            Object value = entry.getValue(); 
            if(key.equals("visitor_nick")){
                nick=(String) value; 
            } 
            System.out.println(key+":"+value);
        } 
        return nick; 
    } 

}
