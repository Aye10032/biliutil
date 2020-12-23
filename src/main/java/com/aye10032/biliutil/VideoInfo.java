package com.aye10032.biliutil;

import com.aye10032.biliutil.data.URL;
import com.aye10032.biliutil.util.Util;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

/**
 * @program: biliutil
 * @description: 视频信息
 * @author: Aye10032
 * @create: 2020-12-23 18:36
 **/
public class VideoInfo {

    private final StringBuilder url;
    private JsonObject body_json;

    public VideoInfo(String id){
        url = new StringBuilder();
        url.append(URL.url_video_info)
                .append("?");
        if (Util.IsBvid(id)){
            url.append("bvid=")
                    .append(id);
        }else {
            url.append("aid=")
                    .append(id);
        }
        init(url.toString());
    }

    private void init(String url){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(Objects.requireNonNull(response.body()).string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}