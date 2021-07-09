package hello.core.singleton;

/* DI 컨테이너인 AppConfig는 요청을 할 때마다 새로운 객체를 생성한다.
요청이 많은 트래픽 사이트에서는 계속 객체를 생성하게 되면 메모리 낭비가 심하기 때문이다. */
public class SingletonService {

    // Class 단위에서 사용할 수 있다.(객체 사용 X) 자바 실행되면 바로 실행되게 설계했다.
    private static final SingletonService instance = new SingletonService();

    // public으로 열어두고 객체 인스턴스가 필요하면 getInstance 메서드를 통해서만 조회해도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 외부에서 생성하지 못하게 막아둔다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
