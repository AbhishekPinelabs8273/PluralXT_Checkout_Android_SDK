package pinelabs.rapidpay.merchant.testapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import pinelabs.rapidpay.merchant.testapp.BusinessLayer.Abstract.IEdgePaymentBusinessLayer;
import pinelabs.rapidpay.merchant.testapp.BusinessLayer.Concrete.EdgePaymentBusinessLayer;
import pinelabs.rapidpay.merchant.testapp.DataModal.AcceptPaymentRequest;
import pinelabs.rapidpay.merchant.testapp.DataModal.CreateRequestForRapidPay;
import pinelabs.rapidpay.sdk.RapidPayOrder;
import pinelabs.rapidpay.sdk.ServiceLayer.Abstract.IRapidPayResponseCallback;
import pinelabs.rapidpay.sdk.ServiceLayer.Concrete.RapidPayCallbackService;
import pinelabs.rapidpay.sdk.annotations.RapidPayBaseUrlTypeAnnotation;

import static pinelabs.rapidpay.merchant.testapp.Contants.EDGE_MERCHANT_ID;

public class MainActivity extends AppCompatActivity {
    Button payNowButton;
    int txnid;
    CreateRequestForRapidPay createRequestForRapidPay;
    EdgePaymentBusinessLayer edgePaymentBusinessLayer;
    String strRequest;
    private AlertDialog.Builder responseDisplayDialogue;
    private TextView tvIsOtpDetected,tvPaymentStatus,tvErrorCode,tvErrorMessage, tvIsBackButtonPreesed,tvLastVistedUrl,
            tvTxnStartTime,tvTxnFinishTime,tvMerchantId,tvTransactionId,tvCustomerId,tvCustomerEmail,tvCustomerPhoneNo,tvAmount;
    private CheckBox cbShouldStartPinePGLoaderLoader;
    private View alertLayout;
    private static String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        payNowButton=findViewById(R.id.payNow);
        payNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RapidPayOrder rapidPayOrder=new RapidPayOrder.Builder().setContext(MainActivity.this).
                        setEnvironment(RapidPayBaseUrlTypeAnnotation.TEST).setMerchantCallBack(rapidPayCallbackService)
                        .setRequest(strCreateRequest()).setXVerifyHeader(edgePaymentBusinessLayer.getXVerifyHeader(strRequest)).create();
                rapidPayOrder.startPaymentService();
            }
        });
        initializeAlertLayout();
    }
    private String strCreateRequest()
    {
        Random random=new Random();
        txnid=random.nextInt(100000) + 75;
        createRequestForRapidPay=new CreateRequestForRapidPay();
        edgePaymentBusinessLayer=new EdgePaymentBusinessLayer();
        AcceptPaymentRequest acceptPaymentRequest= edgePaymentBusinessLayer.getAcceptPaymentRequest( createRequestForRapidPay.getAcceptPaymentData(""+txnid));
        strRequest=acceptPaymentRequest.request;
        return acceptPaymentRequest.request;
    }
    private IRapidPayResponseCallback rapidPayCallbackService=new IRapidPayResponseCallback() {
        @Override
        public void onErrorOccurred(int i, String s) {
            showResponseDialogue();
            tvErrorCode.setText(i+"");
            tvErrorMessage.setText(s);
        }
        @Override
        public void onTransactionResponse(Bundle bundle) {
            showResponseDialogue();
            tvIsBackButtonPreesed.setText("No");
            tvPaymentStatus.setText("Completed");
        }

        @Override
        public void onCancelTxn() {
            showResponseDialogue();
        }

        @Override
        public void onPressedBackButton() {
            showResponseDialogue();
            tvIsBackButtonPreesed.setText("Yes");
        }

        @Override
        public void onPageStarted(WebView webView, String s) {
            showResponseDialogue();
        }

        @Override
        public void onWebViewReady(WebView webView) {

        }
    };
    private void initializeAlertLayout()
    {
        try {
            if(this.alertLayout==null) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                this.alertLayout = inflater.inflate(R.layout.callback_reponse_dialogue, null);
                this.tvPaymentStatus = this.alertLayout.findViewById(R.id.tvPaymentStatus);
                this.tvErrorCode = this.alertLayout.findViewById(R.id.tvErrorCode);
                this.tvErrorMessage=this.alertLayout.findViewById(R.id.tvErrorMessage);
                this.tvIsBackButtonPreesed =this.alertLayout.findViewById(R.id.tvIsBackPressed);
                this.tvMerchantId=this.alertLayout.findViewById(R.id.tvMerchantId);
                this.tvTransactionId=this.alertLayout.findViewById(R.id.tvTransactionId);
            }
        }
        catch (Exception ex)
        {

        }
    }
    private void showResponseDialogue()
    {
        try {
            initializeAlertLayout();
            if(this.responseDisplayDialogue==null) {
                this.responseDisplayDialogue = new AlertDialog.Builder(this);
                this.responseDisplayDialogue.setTitle("Callback Response");
                this.responseDisplayDialogue.setCancelable(true);
                this.responseDisplayDialogue.setView(this.alertLayout);
                this.responseDisplayDialogue.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
            }
            this.tvMerchantId.setText(EDGE_MERCHANT_ID+"");
            this.tvTransactionId.setText(txnid+"");
            responseDisplayDialogue.show();
        }
        catch (Exception ex)
        {
            Log.e(TAG,ex.getMessage());
        }
    }
}
