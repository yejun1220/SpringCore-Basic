package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @Qualifier는 맵핑을 통해 DI를 주입해준다.
// @Qualifier("mainDiscountPolicy")

// 여러개의 빈이 선택되면 @Primary가 있는 빈을 실행한다.
// @Primary

// 내가 직접 애노테이션을 만들 수 있다.(오타날 경우 컴파일 시점에서 찾을 수 있다.)
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        else {
            return 0;
        }
    }
}
