package pinelabs.rapidpay.merchant.testapp.BusinessLayer.Concrete;

import pinelabs.rapidpay.merchant.testapp.BusinessLayer.Abstract.IEdgePaymentBusinessLayer;
import pinelabs.rapidpay.merchant.testapp.DataModal.AcceptPaymentData;
import pinelabs.rapidpay.merchant.testapp.DataModal.AcceptPaymentRequest;
import pinelabs.rapidpay.merchant.testapp.utilities.ApplicationUtils;
import pinelabs.rapidpay.merchant.testapp.utilities.RapidPayHashingAlgorithm;

import static pinelabs.rapidpay.merchant.testapp.Contants.EDGE_MERCHANT_SECRET_KEY;

public class EdgePaymentBusinessLayer implements IEdgePaymentBusinessLayer {
    ApplicationUtils applicationUtils;
    public AcceptPaymentRequest getAcceptPaymentRequest(AcceptPaymentData acceptPaymentData)
    {
        applicationUtils=new ApplicationUtils();
        AcceptPaymentRequest acceptPaymentRequest=new AcceptPaymentRequest();
        acceptPaymentRequest.request=applicationUtils.convertToBase64String(applicationUtils.convertToJson(acceptPaymentData));
        return acceptPaymentRequest;
    }
    public String getXVerifyHeader(String base64EncodedString)
    {
        byte[] convertedHashKey = new byte[EDGE_MERCHANT_SECRET_KEY.length() / 2];
        for (int i = 0; i < EDGE_MERCHANT_SECRET_KEY.length() / 2; i++) {
            convertedHashKey[i] = (byte)Integer.parseInt(EDGE_MERCHANT_SECRET_KEY.substring(i * 2, (i*2)+2),16); //hexNumber radix
        }
        return RapidPayHashingAlgorithm.hmacDigest(base64EncodedString, convertedHashKey,"HmacSHA256").toUpperCase();
    }
}
