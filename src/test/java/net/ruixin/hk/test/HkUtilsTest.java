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
}
