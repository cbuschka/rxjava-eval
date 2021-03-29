package com.github.cbuschka.rxjava_eval;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinearTest
{
	private final List<String> output = new ArrayList<>();

	@Test
	void single()
	{
		Observable<String> observer = Observable.just("Hello world!");
		observer.subscribe(output::add).dispose();

		assertThat(output).containsExactly("Hello world!");
	}

	@Test
	void linearPrintln()
	{
		List<String> messages = Arrays.asList("Hello", "World", "!");

		Observable.fromIterable(messages)
				.subscribe((m) -> output.add("Subscriber: " + m))
				.dispose();

		assertThat(output).containsExactly("Subscriber: Hello", "Subscriber: World", "Subscriber: !");
	}
}
