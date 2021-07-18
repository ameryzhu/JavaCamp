import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class TestHttpServerHandler extends SimpleChannelInboundHandler {
    ExecutorService executorService;

    TestHttpServerHandler() {
        executorService = Executors.newFixedThreadPool(4, new ThreadFactory() {
            @Override
            public Thread newThread(@NotNull Runnable r) {
                return new Thread(r, "httpservice_" + r.toString());
            }
        });
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    //要返回的内容, Channel可以理解为连接，而连接中传输的信息要为ByteBuf
                    ByteBuf content;
                    if(GatewayAuthChecker.checkHeaders(((HttpRequest) msg).headers())){
                        content = Unpooled.copiedBuffer("Hello World", CharsetUtil.UTF_8);
                    }else{
                        content = Unpooled.copiedBuffer("request fail, unAuthorized request", CharsetUtil.UTF_8);
                    }

                    //构造响应
                    FullHttpResponse response =
                            new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);

                    //设置头信息的的MIME类型
                    response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");  //内容类型
                    //设置要返回的内容长度
                    response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes()); //内容长度
                    //将响应对象返回
                    ctx.writeAndFlush(response);
                }
            });
        }
        if(msg instanceof HttpContent){
            HttpContent httpContent = (HttpContent) msg;

            ByteBuf content = httpContent.content();

            ByteBuf buf = Unpooled.copiedBuffer("Post request"+content.toString(), CharsetUtil.UTF_8);;

            //构造响应
            FullHttpResponse response =
                    new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, buf);

            //设置头信息的的MIME类型
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");  //内容类型
            //设置要返回的内容长度
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, buf.readableBytes()); //内容长度



            //将响应对象返回
            ctx.writeAndFlush(response);

        }
    }

    //通道注册成功
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel register...");
        super.channelRegistered(ctx);
    }

    /**
     * 自定义的Handler被添加,也就是在TestChannelnitializer的initChannel方法中，
     * pipeline.addLast("testHttpServerHandler", new TestHttpServerHandler());
     * 这行代码执行的时候，该方法被触发
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handler added...");
        super.handlerAdded(ctx);
    }

    //通道处于活动状态，即可用状态
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel active...");
        super.channelActive(ctx);
    }

    //通道处于不活动状态
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel inactive...");
        super.channelInactive(ctx);
    }

    //通道取消注册
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel unregister...");
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }
}
