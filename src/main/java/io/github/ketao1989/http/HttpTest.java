package io.github.ketao1989.http;

import com.alibaba.dubbo.common.json.JSON;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tao.ke Date: 2017/9/28 Time: 下午8:06
 */
public class HttpTest {

  /**
   * http连接池相关配置
   */
  private static final PoolingHttpClientConnectionManager hctManager = new PoolingHttpClientConnectionManager();

  static {
    hctManager.setMaxTotal(100);
    hctManager.setDefaultMaxPerRoute(50);
  }

  private static final CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(hctManager).build();


  public static void main(String[] args) throws Exception {

    HttpPost post = new HttpPost("http://api.koudaitong.com/shop/cert/qualification/getQualificationCert");

    // 构造请求参数
    Map<String, Object> params = new HashMap<>();
    params.put("partnerId",410987 );
    params.put("partnerType", 1);
    params.put("qualType", 2);
    StringEntity content = new StringEntity(JSON.json(params), ContentType.APPLICATION_JSON);
    post.setEntity(content);

    System.out.println(EntityUtils.toString(post.getEntity(),Charset.defaultCharset()));

    String data = EntityUtils.toString(httpClient.execute(post).getEntity(), Charset.defaultCharset());
    System.out.println(data);

  }

}
