package com.inflearn.study;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ConditionalTest {
    @Test
    void conditional() {
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config1.class);
        context.refresh();

        Bean1 bean = context.getBean(Bean1.class);

        assertNotNull(bean);*/
        // Test 도와주는 Application Context
        ApplicationContextRunner contextRunner = new ApplicationContextRunner();
        contextRunner.withUserConfiguration(Config1.class)
                .run(context1 -> {
//                    Bean1 bean1 = context1.getBean(Bean1.class);
//                    assertNotNull(bean1);

                    assertThat(context1).hasSingleBean(Bean1.class);
                });

        ApplicationContextRunner contextRunner2 = new ApplicationContextRunner();
        contextRunner2.withUserConfiguration(Config2.class)
                .run(context2 -> {
//                    Bean1 bean1 = context2.getBean(Bean1.class);
//                    assertNotNull(bean1);

                    assertThat(context2).doesNotHaveBean(Bean1.class);
                });
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(BooleanCondition.class)
    @interface BooleanConditional {
        boolean value() default false;
    }

    @Configuration
    @BooleanConditional(value = true)
    static class Config1 {
        @Bean
        Bean1 bean1() {
            return new Bean1();
        }
    }

    @Configuration
    @BooleanConditional
    static class Config2 {
        @Bean
        Bean1 bean1() {
            return new Bean1();
        }
    }

    static class Bean1 {}

    static class TrueCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return true;
        }
    }

    static class FalseCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return false;
        }
    }

    static class BooleanCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(BooleanConditional.class.getName());
            Boolean value = (Boolean) annotationAttributes.get("value");
            return value;
        }
    }
}
