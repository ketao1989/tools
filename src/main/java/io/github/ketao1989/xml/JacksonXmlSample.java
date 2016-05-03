/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * @author tao.ke Date: 15/11/24 Time: 下午2:54
 * @version \$Id$
 */
public class JacksonXmlSample {

    public static void main(String[] args) throws Exception {

        XmlSampleNode node = new XmlSampleNode();
        node.setHead(new XmlHead(1,"test"));
        node.setAge(22);
        node.setName("xml-name");
        node.setIsChinese(false);

        XmlMapper mapper = new XmlMapper();
        String src = mapper.writeValueAsString(node);
        System.out.println(src);

        XmlSampleNode parseNode = mapper.readValue(src,XmlSampleNode.class);
        System.out.println(parseNode);

    }
}
