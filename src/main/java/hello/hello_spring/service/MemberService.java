package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public long join(Member member){
        memberRepository.save(member);
        return member.get();
    }
}
