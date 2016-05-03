/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
/**
 * @author tao.ke Date: 16/1/2 Time: 下午2:12
 */
package io.github.ketao1989.scheduler.client;

// 通过rpc 来执行定时任务
// 主要是对非事业kafka 的项目,屏蔽掉这一层.使用者直接使用接口,就可以完成定时执行某个接口
// 使用场景:比如最近有个需求,调用外部的异步接口.外部通过回调或者内部使用查询来获取最终的结果,这种case,
// 对于查询就需要延迟10s或者20s再触发查询.

// 定时任务,一般有直接HTTP 调用,或者 RPC调用.
// 这里简单实现,即使用者将对于的jar包引入,然后由于在同一个项目中,consumer是可以到API中找到对应的方法来执行,
// 而不需要配置各种rpc相关client 配置.

// 使用接口,必须要做到幂等.避免接口多次请求重复操作导致数据错误.