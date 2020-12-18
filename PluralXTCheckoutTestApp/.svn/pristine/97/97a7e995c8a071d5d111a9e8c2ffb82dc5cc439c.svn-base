package pinelabs.rapidpay.merchant.testapp.utilities;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class RapidPayHashingAlgorithm {

    /**
     * This method will generate key hash
     * @param requestMap
     * @param strSecretKey
     * @param strHashType
     * @return
     */
    public static String GenerateHash(Map<String, String> requestMap, String strSecretKey, String strHashType) {
        String strHash = "";
        try {
            if (requestMap == null || requestMap.size() == 0 || !isValidString(strSecretKey) || !isValidString(strHashType)) {
                return strHash;
            }
            TreeMap<String, String> sortdRequestMap = new TreeMap<String, String>(requestMap);
            //Convert Secret Key to required format
            byte[] convertedHashKey = new byte[strSecretKey.length() / 2];
            for (int i = 0; i < strSecretKey.length() / 2; i++) {
                convertedHashKey[i] = (byte)Integer.parseInt(strSecretKey.substring(i * 2, (i*2)+2),16); //hexNumber radix
            }

            //   StringBuilder sbMessage = new StringBuilder();
            StringBuilder sbMessage = new StringBuilder();
            for (Map.Entry<String, String> kvp : sortdRequestMap.entrySet()) {
//                if(kvp.getValue()!=null && kvp.getValue()!=""  && kvp.getValue().trim().length()>0)
//                {
                sbMessage.append(kvp.getKey()+ "=" + kvp.getValue() + "&");
                //  }

            }
            sbMessage.deleteCharAt(sbMessage.length()-1);
            //generate hash
            if (strHashType.equalsIgnoreCase("SHA256")) {
                strHash = hmacDigest(sbMessage.toString(), convertedHashKey, "HmacSHA256");

            }
            else if (strHashType.equalsIgnoreCase("MD5")) {
                strHash = hmacDigest(sbMessage.toString(), convertedHashKey, "HmacMD5");
            }
        } catch (Exception ex) {
            strHash = "";
        }
        return strHash.toUpperCase();
    }
    public static String GenerateHashV2(String base64String, String strSecretKey, String strHashType) {
        String strHash = "";
        try {
            byte[] convertedHashKey = new byte[strSecretKey.length() / 2];
            for (int i = 0; i < strSecretKey.length() / 2; i++) {
                convertedHashKey[i] = (byte)Integer.parseInt(strSecretKey.substring(i * 2, (i*2)+2),16); //hexNumber radix
            }
            //generate hash
            if (strHashType.equalsIgnoreCase("SHA256")) {
                strHash = hmacDigest(base64String, convertedHashKey, "HmacSHA256");

            }
        } catch (Exception ex) {
            strHash = "";
        }
        return strHash.toUpperCase();
    }

    public static String hmacDigest(String msg, byte[] keyString, String algo) {
        String digest = null;
        try {
            SecretKeySpec key = new SecretKeySpec(keyString, algo);
            Mac mac = Mac.getInstance(algo);
            mac.init(key);
            byte[] bytes = mac.doFinal(msg.getBytes("UTF-8"));
            StringBuffer hash = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xFF & bytes[i]);
                if (hex.length() == 1) {
                    hash.append('0');
                }
                hash.append(hex);
            }
            digest = hash.toString();
        } catch (UnsupportedEncodingException e) {
//	    	logger.error("Exception occurred in hashing the pine payment gateway request"+e);
        } catch (InvalidKeyException e) {
//	    	logger.error("Exception occurred in hashing the pine payment gateway request"+e);
        } catch (NoSuchAlgorithmException e) {
//	    	logger.error("Exception occurred in hashing the pine payment gateway request"+e);
        }
        return digest;
    }

    public static boolean isValidString(String str){
        if(str != null && !"".equals(str.trim())){
            return true;
        }
        return false;
    }
}
