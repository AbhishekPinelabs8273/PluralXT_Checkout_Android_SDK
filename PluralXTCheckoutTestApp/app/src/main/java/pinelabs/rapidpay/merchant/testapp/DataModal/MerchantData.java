package pinelabs.rapidpay.merchant.testapp.DataModal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MerchantData {
    @SerializedName("merchant_id")
    @Expose
    public Integer merchantId;
    @SerializedName("merchant_access_code")
    @Expose
    public String merchantAccessCode;
    @SerializedName("order_id")
    @Expose
    public String uniqueMerchantTxnId;
    @SerializedName("merchant_return_url")
    @Expose
    public String merchantReturnUrl;
}
