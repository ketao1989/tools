package io.github.ketao1989.yaml;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.io.Resources;
import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ketao on 15-7-21.
 */
public class YamlParser {

    public static void main(String[] args) throws FileNotFoundException {
        Yaml yaml = new Yaml();

        System.out.println(Resources.getResource("test.yml").getPath());;

        File file = new File(Resources.getResource("test.yml").getPath());

        Map<String,Object> maps = yaml.loadAs(new FileInputStream(file), HashMap.class);

        for(String key : maps.keySet()){

            if (StringUtils.equals(key,"sharding")){
                List<String> values = (List<String>)maps.get(key);

                for (String value :values){
                    System.out.println(value);
                    Map<String,String> pairs = Splitter.on(CharMatcher.WHITESPACE).withKeyValueSeparator(":").split(value);
                    System.out.println("======="+pairs.get("host"));
                }
            }else {

                System.out.println("------"+maps.get(key));

            }



        }
    }
}
