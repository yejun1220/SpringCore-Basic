package hello.core;

import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 컴포넌트 스캔은 @Component가 붙은 스프링 빈을 자동으로 찾아낸다.
@ComponentScan(
        // 탐색할 디렉토리를 지정할 수 있다.
        // basePackages = "hello.core.member",
        // Configuration이 붙은 Annotation을 제외한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")
//    public MemoryMemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
