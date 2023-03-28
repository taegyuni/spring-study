package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
        //메소드 데이터를 하나씩 비워줘야함.
        //테스트할 때 테스트순서와 상관없이 결과에 영향을 받지 않기 위해서
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("tg");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member,result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findeByName(){
        Member member1 = new Member();
        member1.setName("Tg1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Tg2");
        repository.save(member2);

        Member result = repository.findByName("Tg1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("tgtg1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("tgtg2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
