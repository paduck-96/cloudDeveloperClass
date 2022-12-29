package kakao.study.webapp;

public class PageServiceImpl implements PageService{
    // java라면 싱글톤 패턴 작성 코드 추가
    //spring에서는 불필요
    @Override
    public int add(int first, int second) {
        return first+second;
    }
}
