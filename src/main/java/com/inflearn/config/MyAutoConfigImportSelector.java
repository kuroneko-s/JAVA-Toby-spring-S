package com.inflearn.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * DeferredImportSelector - 기본 빈 초기화 후 동작.
 * Import를 string path로 설정 가능하게 해주는 interface
 */
public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "com.inflearn.config.autoconfig.ServletConfigure",
                "com.inflearn.config.autoconfig.WebServerConfigure"
        };
    }
}
