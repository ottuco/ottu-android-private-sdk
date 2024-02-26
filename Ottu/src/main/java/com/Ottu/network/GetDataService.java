package com.Ottu.network;

import com.Ottu.model.GenerateToken.CreatePaymentTransaction;
import com.Ottu.model.StcPayMNumber.StcPayPayload;
import com.Ottu.model.StcPayMNumber.StcPayResponce;
import com.Ottu.model.StcPayOtp.StcOtpPayload;
import com.Ottu.model.StcPayOtp.StcOtpResponce;
import com.Ottu.model.RedirectUrl.CreateRedirectUrl;
import com.Ottu.model.RedirectUrl.RespoRedirectUrl;
import com.Ottu.model.fetchTxnDetail.RespoFetchTxnDetail;
import com.Ottu.model.submitCHD.SubmitCHDToOttoPG;
import com.Ottu.model.submitCHD.SubmitCHDToOttoPGEncrypted;
import okhttp3.ResponseBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface GetDataService {


    @POST("checkout/v1/pymt-txn/")
    Call<RespoFetchTxnDetail> createPaymentTxn(@Body CreatePaymentTransaction transaction);

    @GET()
    Call<RespoFetchTxnDetail> fetchTxnDetail(@Url String url);

    @POST()
    Call<ResponseBody> respoSubmitCHDEncrypted(@Url String submitUrlCard,@Body SubmitCHDToOttoPGEncrypted submitCHDToOttoPG);
    @POST()
    Call<ResponseBody> respoSubmitCHD(@Url String submitUrlCard,@Body SubmitCHDToOttoPG submitCHDToOttoPG);


    @POST()
    Call<RespoRedirectUrl> createRedirectUrl(@Url String url,
                                             @Body CreateRedirectUrl redirectUrl);

    @DELETE()
    Call<ResponseBody> deleteCard1(@Url String token);

    @GET()
    Call<ResponseBody> getPublicKey(@Url String urlPublicKey);

    @POST()
    Call<StcPayResponce> submitSTCPay(@Url String urlPublicKey,@Body StcPayPayload stcPayLoad);
    @POST()
    Call<StcOtpResponce> sendStcOtp(@Url String urlPublicKey, @Body StcOtpPayload stcPayLoad);
}