package net.ruixin.hk.test;

import net.ruixin.hk.HkUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dingmx
 * @date 2020/2/10 18:07
 */
public class HkUtilsTest {

    @Test
    public void testPreviewURLs() {
        String url = "/api/video/v1/cameras/previewURLs";
        Map<String, Object> params = new HashMap<>();
        params.put("cameraIndexCode", "e0544e148f744bbe887142007b013e61");
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
        params.put("pageSize", 10);
        String result = HkUtils.getDataByUrl(url, params);
        System.out.println(result);
    }

    @Test
    public void testCameras() {
        String url = "/api/resource/v1/regions/regionIndexCode/cameras";
        Map<String, Object> params = new HashMap<>();
        params.put("regionIndexCode", "1703265c-52aa-4637-a8fa-2e368e634f97");
        params.put("pageNo", 1);
        params.put("pageSize", 10);
        String result = HkUtils.getDataByUrl(url, params);
        System.out.println(result);
    }
}
