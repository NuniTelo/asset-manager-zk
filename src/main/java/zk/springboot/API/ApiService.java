package zk.springboot.API;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import zk.springboot.Models.AssetMainModel;

import java.util.Map;

import static org.zkoss.zkplus.spring.SpringUtil.getApplicationContext;

public class ApiService {

    OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    public static String getData(String url) throws Exception{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        String data =  response.body().toString();

        AssetMainModel assetMainModel = new Gson().fromJson(response.body().charStream(), AssetMainModel.class);


        return assetMainModel.getId();

    }


}
