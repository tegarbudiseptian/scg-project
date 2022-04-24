package com.antena.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class MemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
	}
}

@Data
@AllArgsConstructor
class Member {
	private String name;
}

@RestController
class MemberController {
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	@GetMapping("members")
	public Flux<Member> getSampahs() {
		return Flux.just(
				new Member("Tegar"),
				new Member("Budi"),
				new Member("Septian")
		).doFirst(() -> log.info("Returning all members"));
	}
}