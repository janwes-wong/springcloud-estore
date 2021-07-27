package com.estore.gatewayorder.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Janwes
 * @version 1.0
 * @package com.estore.gatewayorder.filter
 * @date 2021/7/27 17:47
 * @description 自定义网关全局过滤器  模拟用户登录
 */
@Component
public class CustomGlobalFilter implements GlobalFilter, Ordered {

    /**
     * 过滤拦截
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1. 获取请求对象request
        ServerHttpRequest request = exchange.getRequest();
        // 2. 获取响应对象response
        ServerHttpResponse response = exchange.getResponse();
        // 3. 获取请求参数中的token的值
//        String token = request.getQueryParams().getFirst("token");
        // 获取请求头requestHeader的token
        String token = request.getHeaders().getFirst("token");
        // 4. 判断验证登录携带的token是否正确
        if (!"123456".equals(token)) {
            // 错误 返回401 权限不足
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        // 5. 判断验证正确放行过滤器
        return chain.filter(exchange);
    }

    /***
     * 定义过滤器执行顺序
     * 返回值越小，过滤器被执行的优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
