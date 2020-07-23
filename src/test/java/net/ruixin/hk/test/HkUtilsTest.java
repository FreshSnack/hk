package net.ruixin.hk.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.*;

/**
 * @author dingmx
 * @date 2020/2/10 18:07
 */
public class HkUtilsTest {

    @Test
    public void testPreviewURLs() {
        String url = "/api/video/v1/cameras/previewURLs";
        Map<String, Object> params = new HashMap<>();
        params.put("cameraIndexCode", "3209f4d747e0431cb1a0fb7efe181ee6");
        //params.put("transmode", "0");
        params.put("protocol", "rtsp");
        params.put("expand", "streamform=rtp");
        String result = HkUtils.getDataByUrl(url, params);
        System.out.println(result);
    }

    @Test
    public void testCameras() {
        String url = "/api/resource/v1/cameras";
        Map<String, Object> params = new HashMap<>();
        params.put("pageNo", 1);
        params.put("pageSize", 1000);
        String result = HkUtils.getDataByUrl(url, params);
        System.out.println(result);
    }

    @Test
    public void testRegionsRoot() {
        String url = "/api/resource/v1/regions/root";
        Map<String, Object> params = new HashMap<>();
        String result = HkUtils.getDataByUrl(url, params);
        System.out.println(result);
    }

    @Test
    public void testNodesByParams() {
        String url = "/api/irds/v2/region/nodesByParams";
        Map<String, Object> params = new HashMap<>();
        params.put("pageNo", 1);
        params.put("pageSize", 10);
        String result = HkUtils.getDataByUrl(url, params);
        System.out.println(result);
    }

    @Test
    public void testRegions() {
        String url = "/api/resource/v1/regions";
        Map<String, Object> params = new HashMap<>();
        params.put("pageNo", 1);
        params.put("pageSize", 1000);
        String result = HkUtils.getDataByUrl(url, params);
        System.out.println(result);
    }

    @Test
    public void testRegionCameras() {
        String url = "/api/resource/v1/regions/regionIndexCode/cameras";
        Map<String, Object> params = new HashMap<>();
        params.put("regionIndexCode", "5ed1a431-dd12-4af6-a424-bf58e9591cba");
        params.put("pageNo", 1);
        params.put("pageSize", 10);
        String result = HkUtils.getDataByUrl(url, params);
        System.out.println(result);
    }

    @Test
    public void testSubRegions() {
        String url = "/api/resource/v2/regions/subRegions";
        List<Map> resultList = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();
        params.put("parentIndexCode", "82fbcc99-8390-46f3-b889-d040735717db");
        params.put("resourceType", "camera");
        params.put("pageNo", 1);
        params.put("pageSize", 10);
        String result = HkUtils.getDataByUrl(url, params);
        JSONObject jsonObject = JSONObject.parseObject(result);
        if("0".equals(jsonObject.getString("code"))) {
            JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("list");
            /*jsonArray.forEach(it-> {
                JSONObject jsonObj = (JSONObject) it;
                Map<String, Object> map = jsonObj.toJavaObject(Map.class);
                resultList.add(map);
            });*/
        } else {
            System.out.println(jsonObject.getString("msg"));
        }
        System.out.println(result);
    }
}
