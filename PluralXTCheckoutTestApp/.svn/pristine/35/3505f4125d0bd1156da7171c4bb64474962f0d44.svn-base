package pinelabs.rapidpay.merchant.testapp.utilities;

import android.util.Base64;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

public class ApplicationUtils {
    public String convertToJson(Object object)
    {
        Gson gson = new Gson();
        return   gson.toJson(object);
    }
    public String convertToBase64String(String requestString)
    {
        byte[] data = new byte[0];
        String base64=null;
        try {
            data = requestString.getBytes("UTF-8");
            base64 = Base64.encodeToString(data, Base64.DEFAULT);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
       return base64;
    }

}
