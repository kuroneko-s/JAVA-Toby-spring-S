package com.inflearn.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * DeferredImportSelector - 기본 빈 초기화 후 동작.
 * Import를 string path로 설정 가능하게 해주는 interface
 */
public class MyAutoConfigImportSelector implements DeferredImportSelector {
    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Iterable<String> importCandidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);
        List<String> stringList = new ArrayList<>();

        for (String str: importCandidates) {
            stringList.add(str);
        }

        // StreamSupport.stream(importCandidates.spliterator(), false).toArray(String[]::new);
        return stringList.toArray(String[]::new);
    }
}
