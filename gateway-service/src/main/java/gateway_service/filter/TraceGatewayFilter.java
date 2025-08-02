package gateway_service.filter;

import io.micrometer.tracing.Tracer;
import io.opentelemetry.context.Scope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import io.opentelemetry.api.trace.Span;


@Component
//@Configuration(proxyBeanMethods = false)
public class TraceGatewayFilter implements GlobalFilter, Ordered{
    private final Tracer tracer;

    public TraceGatewayFilter(Tracer tracer) {
        this.tracer = tracer;
    }


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        tracer.currentSpan().name("gateway-filter").start();
        return chain.filter(exchange).doFinally(signal -> tracer.currentSpan().end());
//        Span span = tracer.spanBuilder("gateway-filter").startSpan();
//        try (Scope scope = span.makeCurrent()) {
//            // You can add attributes or events to the span here
//            return chain.filter(exchange);
//        } finally {
//            span.end();
//        }
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
