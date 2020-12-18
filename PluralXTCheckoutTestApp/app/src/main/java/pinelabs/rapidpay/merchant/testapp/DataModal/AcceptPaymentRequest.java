package pinelabs.rapidpay.merchant.testapp.DataModal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AcceptPaymentRequest {
    @SerializedName("request")
    @Expose
    public String request;
}
