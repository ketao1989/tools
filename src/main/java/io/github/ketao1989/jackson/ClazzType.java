package io.github.ketao1989.jackson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tao.ke Date: 2017/12/19 Time: 下午4:36
 */
public class ClazzType implements Serializable {

  private static final long serialVersionUID = -8417220400369519831L;

  private String buyerId;

  private String buyerName;

  private String address;

  private String ppId;

  public String getBuyerId() {
    return buyerId;
  }

  public void setBuyerId(String buyerId) {
    this.buyerId = buyerId;
  }

  public String getBuyerName() {
    return buyerName;
  }

  public void setBuyerName(String buyerName) {
    this.buyerName = buyerName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPpId() {
    return ppId;
  }

  public void setPpId(String ppId) {
    this.ppId = ppId;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }

  public static void main(String[] args) {

    ClazzType clazzType = new ClazzType();
    clazzType.setAddress("1234");
    clazzType.setBuyerId("");
    clazzType.setBuyerName("");
    clazzType.setPpId("");

    SerializeFilter filter = new ValueFilter() {
      @Override
      public Object process(Object object, String name, Object value) {
        return value == null || value.equals("") ? null : value;
      }
    };
    System.out.println(com.alibaba.fastjson.JSON.toJSONString(clazzType, filter));


    ClazzType type = JSON.parseObject("{\"address\":\"1234\"}",ClazzType.class);
    System.out.println(type);


     Pattern BAIFUBAO_RETURN_URL = Pattern.compile("^((https|http):\\/\\/)?([^\\/]+)");
    Matcher matcher = BAIFUBAO_RETURN_URL.matcher("https://trade.koudaitong.com/trade/order/paid?order_no=E20171219181316018800009&kdt_id=18602098");
    System.out.println(matcher.find());;
    System.out.println( matcher.group(0) + "/pay/baiduwap/return");;

  }
}
