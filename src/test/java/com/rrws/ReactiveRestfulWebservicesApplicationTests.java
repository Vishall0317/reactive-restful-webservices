package com.rrws;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

@SpringBootTest
class ReactiveRestfulWebservicesApplicationTests {

	@Test
	void test() {
		Mono<String> monoPublisher = Mono.just("testing");

		monoPublisher.subscribe(new CoreSubscriber<String>() {
			@Override
			public void onSubscribe(Subscription subscription) {
				System.out.println("subscription done");
				subscription.request(1);
			}

			@Override
			public void onNext(String s) {
				System.out.println("data: "+s);
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("error: "+t.getMessage());
			}

			@Override
			public void onComplete() {
				System.out.println("completed");
			}
		});

		System.out.println("---------------------------");

		monoPublisher.subscribe(data-> System.out.println("data: "+data));
	}

}
