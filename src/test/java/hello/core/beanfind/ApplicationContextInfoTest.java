package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")

    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // beanDefinitionNames에 bean에 등록된 메서드 이름이 저장된다.
        for (String beanDefinitionName : beanDefinitionNames) {
            // beanDefinitionName = 빈 객체 이름(key), bean = 빈 객체 주소(values)
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " Object =" + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")

    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            // BeanDefinition은 빈 객체의 정보(메타 데이터)들을 가지고 있다.

            // Role_APPLICATION: 직접 등록한 애플리케이션 빈
            // ROle_INFRASTRUCTURE: 스프링이 내부에서 사용한 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " Object =" + bean);
            }
        }
    }
}
