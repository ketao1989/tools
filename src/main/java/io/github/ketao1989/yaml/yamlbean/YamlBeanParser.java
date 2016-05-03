/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.yaml.yamlbean;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;

import java.io.FileReader;
import java.util.List;
import java.util.Map;

/**
 * @author tao.ke Date: 15/11/26 Time: 上午11:26
 * @version \$Id$
 */
public class YamlBeanParser {

    public static void main(String[] args) throws Exception {

        YamlBean yb = new YamlBean();
        yb.setName("testname");

        List<Map<String,String>> maps = Lists.newArrayList();

        Map<String,String> map1 = Maps.newHashMap();
        map1.put("age","13");
        map1.put("name","zhangsan");
        map1.put("school","qhu");
        maps.add(map1);


        Map<String,String> map2 = Maps.newHashMap();
        map2.put("age","14");
        map2.put("name","lisi");
        map2.put("school","bju");
        maps.add(map2);

        yb.setMaps(maps);

//        YamlWriter writer = new YamlWriter(new FileWriter("testt.yml"));
//        writer.write(yb);
//        writer.close();

        YamlReader reader = new YamlReader(new FileReader(Resources.getResource("yamlbean.yml").getPath()));
        YamlBean bean = reader.read(YamlBean.class);
        System.out.println(bean);
        reader.close();
    }
}
