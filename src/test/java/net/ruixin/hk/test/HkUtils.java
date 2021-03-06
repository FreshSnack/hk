package net.ruixin.hk.test;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import com.hikvision.artemis.sdk.constant.Constants;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author dingmx
 * @date 2020/2/10 17:57
 */
public class HkUtils {

    public static String getDataByUrl(String url, Map<String, Object> params) {

        // 设置超长时间
        Constants.DEFAULT_TIMEOUT = 10000;
        /**
         * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
         */
        ArtemisConfig.host = "101.69.216.133:444"; // artemis网关服务器ip端口
        ArtemisConfig.appKey = "23876851";  // 秘钥appkey
        ArtemisConfig.appSecret = "Dno78vgjTbEHASX71vg0";// 秘钥appSecret

        /**
         * STEP2：设置OpenAPI接口的上下文
         */
        final String ARTEMIS_PATH = "/artemis";

        /**
         * STEP3：设置接口的URI地址
         */
        final String apiUri = ARTEMIS_PATH + url;
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                put("https://", apiUri);//根据现场环境部署确认是http还是https
            }
        };

        /**
         * STEP4：设置参数提交方式
         */
        String contentType = "application/json";

        /*
         * STEP5：组装请求参数
         */
        JSONObject jsonBody = new JSONObject();
        Iterator<String> it =  params.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            jsonBody.put(key, params.get(key));
        }
        String body = jsonBody.toJSONString();

        /**
         * STEP6：调用接口
         */
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, contentType , null);// post请求application/json类型参数
        return result;

    }
}
