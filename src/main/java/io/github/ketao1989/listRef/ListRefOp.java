/*
* Copyright (c) 2015 ketao1989.github.com. All Rights Reserved.
*/
package io.github.ketao1989.listRef;

import io.github.ketao1989.jackson.JsonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tao.ke Date: 16/2/26 Time: 上午10:38
 */
public class ListRefOp {

    public static void main(String[] args) {

        List<ObjRef> objRefs = new ArrayList<ObjRef>();
        objRefs.add(new ObjRef(1,"test1"));
        objRefs.add(new ObjRef(2,"test2"));
        objRefs.add(new ObjRef(3,"test3"));

        System.out.println(JsonUtils.encode(objRefs));

        ObjRef tmp = objRefs.get(1);
        tmp.setName("after2");

        System.out.println(JsonUtils.encode(objRefs));




    }
}
