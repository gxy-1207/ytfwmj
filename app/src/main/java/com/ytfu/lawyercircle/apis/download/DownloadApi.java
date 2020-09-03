package com.ytfu.lawyercircle.apis.download;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface DownloadApi {

    @Streaming
    @GET
    Call<ResponseBody> downloadByGet(@Url String url);
}
