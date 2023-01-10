package com.kakao.bootjpa;

import com.kakao.bootjpa.domain.Memo;
import com.kakao.bootjpa.persistence.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    MemoRepository memoRepository;

    // 삽입 테스트
    @Test
    public void testInsert(){
        IntStream.rangeClosed(1,100).forEach(i->{
            Memo memo = Memo.builder().memoText("Sample : " + i).build();
            memoRepository.save(memo);
        });
    }
    @Test
    public void testALl(){
        List<Memo> list = memoRepository.findAll();
        for(Memo memo : list){
            System.out.println(memo);
        }
    }
    @Test
    public void getById(){
        // 기본키로 조회하면 없거나 1개의 데이터 리턴
        Optional<Memo> result = memoRepository.findById(100L);
        if(result.isPresent()){
            System.out.println(result.get());
        }else{
            System.out.println("데이터 없음");
        }
    }

    @Test
    public void updateTest(){
        // 기본키값이 존재하지 않으면 삽입으로 처리
        Memo memo = Memo.builder().mno(100L).memoText("데이터 수정").build();
        memoRepository.save(memo);
    }
    
    @Test
    public void deleteTest() {
    //memoRepository.deleteById(100L); //기본키로 삭제
    //memoRepository.delete(Memo.builder().mno(99L).build()); //Entity로 삭제
        List<Memo> list = memoRepository.findAll();
            for(Memo memo : list){
                memoRepository.delete(Memo.builder().mno(memo.getMno()).build());
            }
    }

    @Test
    public void testPaging(){
        Pageable pageable = PageRequest.of(0,10);
        Page<Memo> result = memoRepository.findAll(pageable);
        // 전체 페이지 수
        System.out.println(result.getTotalPages());
        // 조회된 데이터 순회
        for(Memo memo : result.getContent()){
            System.out.println(memo);
        }
    }

    @Test
    public void testSort(){
        Sort sort = Sort.by("mno").descending();
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<Memo> result = memoRepository.findAll(pageable);
        for(Memo memo : result.getContent()){
            System.out.println(memo);
        }
    }

    @Test
    public void testSortConcate(){
        Sort sort1 = Sort.by("mno").descending();
        Sort sort2 = Sort.by("memoText").ascending();
        Sort sortAll = sort1.and(sort2);
        Pageable pageable = PageRequest.of(0, 10, sortAll);
        Page<Memo> result = memoRepository.findAll(pageable);
        for(Memo memo : result.getContent()){
            System.out.println(memo);
        }
    }

    @Test
    public void queryMethod1(){
        List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(30L, 40L);
        for (Memo memo : list){
            System.out.println(memo);
        }
    }

    @Test
    public void queryMethod2(){
        Pageable pageable = PageRequest.of(1,5);
        Page<Memo> result = memoRepository.findByMnoBetween(0L,50L,pageable);
        for(Memo memo : result.getContent()){
            System.out.println(memo);
        }
    }

    // 특정 작업에서 트랜잭션 미적용시 예외 발생
    @Test
    @Transactional
    //트랜잭션 적용시 자동 Commit이 되지 않으므로 Commit 필수
    @Commit
    public void deleteMnoTest(){
        memoRepository.deleteByMnoLessThan(100L);
        List<Memo> list = memoRepository.findAll();
        for(Memo memo : list){
            System.out.println(memo);
        }
    }

    @Test
    public void testUpdateQuery(){
        System.out.println(memoRepository.updateMemoText(11, "문자열"));
        System.out.println(memoRepository.updateMemoText(Memo.builder().mno(12L).memoText("문자열").build()));
    }

    @Test
    public void testSelectQuery(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
        Page<Memo> result = memoRepository.getListWithQuery(50L, pageable);
        for(Memo memo : result.getContent()){
            System.out.println(memo);
        }
    }

    @Test
    public void testObjectQuery(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
        Page<Object []> result = memoRepository.getObjectWithQuery(50L, pageable);
        for(Object [] memo : result.getContent()){
            System.out.println(Arrays.toString(memo));
        }
    }
}
