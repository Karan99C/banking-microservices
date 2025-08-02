//package com.cust.tracer;
//
//
//
//import io.opentelemetry.api.OpenTelemetry;
//import io.opentelemetry.api.trace.Tracer;
//
//import io.opentelemetry.exporter.logging.LoggingSpanExporter;
//import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
//import io.opentelemetry.sdk.OpenTelemetrySdk;
//import io.opentelemetry.sdk.resources.Resource;
//import io.opentelemetry.sdk.trace.SdkTracerProvider;
//import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class TracingConfig {
//
//    @Bean
//    public OtlpGrpcSpanExporter otlpSpanExporter() {
//        return OtlpGrpcSpanExporter.builder()
//                .setEndpoint("http://localhost:4317") // Replace with your collector endpoint
//                .build();
//    }
//
//    @Bean
//    public SdkTracerProvider sdkTracerProvider(OtlpGrpcSpanExporter exporter) {
//        return SdkTracerProvider.builder()
//                .addSpanProcessor(BatchSpanProcessor.builder(exporter).build())
//                .setResource(Resource.getDefault())
//                .build();
//    }
//
//    @Bean
//    public OpenTelemetry openTelemetry(SdkTracerProvider sdkTracerProvider) {
//        return OpenTelemetrySdk.builder()
//                .setTracerProvider(sdkTracerProvider)
//                .build();
//    }
//
////    @Bean
////    public Tracer tracer(OpenTelemetry openTelemetry) {
////        return openTelemetry.getTracer("com.notification.tracer");
////    }
//
//}
