package com.nightteam.httpso;

import com.fw.myapplication.ndktest.NdkTest;
import com.yanzhenjie.andserver.annotation.Controller;
import com.yanzhenjie.andserver.annotation.GetMapping;
import com.yanzhenjie.andserver.framework.body.JsonBody;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.HttpResponse;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {

    @GetMapping("/nightteam_sign")
    public void post_sign(HttpRequest request, HttpResponse response) {
        String sign = request.getQuery("sign");
        Map<String, String> sign_map = new HashMap<>();
        sign = NdkTest.stringFromUTF(sign);
        sign_map.put("signature", sign+" " + MyApp.getInstance().getApplicationInfo().packageName);
        JSONObject jsonObject = new JSONObject(sign_map);
        response.setBody(new JsonBody(jsonObject));
    }
}
