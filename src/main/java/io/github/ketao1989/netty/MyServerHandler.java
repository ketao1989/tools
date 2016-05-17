/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.netty;

import com.google.common.base.Charsets;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author tao.ke Date: 16/5/10 Time: 下午6:27
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
        System.out.println("----------conn active----------");

        ByteBuf byteBuf = ctx.alloc().buffer();
        byte[] back = "Welcome to netty server.......你好\n".getBytes(Charsets.UTF_8);
        byteBuf.writeInt(back.length);
        byteBuf.writeBytes(back);

        ChannelFuture future = ctx.writeAndFlush(byteBuf);

        future.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture future) throws Exception {
                //ctx.close();
                future.channel().close();
                System.out.println("back msg ok.");
            }
        });

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println(((ByteBuf)msg).toString(Charsets.UTF_8));
        ctx.writeAndFlush(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }


}
