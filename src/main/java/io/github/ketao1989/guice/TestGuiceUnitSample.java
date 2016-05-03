/*
* Copyright (c) 2015 ketao1989.github.com. All Rights Reserved.
*/
package io.github.ketao1989.guice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;

import com.google.inject.Inject;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * @author tao.ke Date: 16/3/7 Time: 下午9:41
 */
@RunWith(GuiceJUnitRunner.class)
//@GuiceJUnitRunner.GuiceModules({})
public class TestGuiceUnitSample {

    @InjectMocks
    @Inject
    private GuiceBiz guiceBiz;

    @Mock
    private GuiceServiceImpl guiceServiceImpl;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetRoleAdmin(){

        Mockito.when(guiceServiceImpl.getRole(Matchers.anyString())).thenReturn("admin");

        Assert.assertEquals("hello Admin",guiceBiz.helloRole("test"));

    }

    @Test
    public void testGetRoleGuest(){

        Mockito.when(guiceServiceImpl.getRole(Matchers.anyString())).thenReturn("");

        Assert.assertEquals("hello Guest",guiceBiz.helloRole("test"));

    }


    @Test
    public void testConcatString(){
        System.out.println(guiceBiz.concatString("ktcoder","hello,"));
        Assert.assertEquals("hello,ktcoder",guiceBiz.concatString("ktcoder","hello,"));
        System.out.println("----------end------------");
    }


    @Test
    public void testIgnoreConcatString(){
        System.out.println(guiceBiz.concatString("ktcoder","hello,"));
        Assert.assertEquals("hello,ktcoder",guiceBiz.concatString("ktcoder","hello,"));
        System.out.println("----------end------------");
    }
}
