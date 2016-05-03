/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.yaml.yamlbean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author tao.ke Date: 15/11/26 Time: 上午11:24
 * @version \$Id$
 */
public class YamlBean implements Serializable {


    private String name;
    private List<Map<String,String>> maps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<String, String>> getMaps() {
        return maps;
    }

    public void setMaps(List<Map<String, String>> maps) {
        this.maps = maps;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
