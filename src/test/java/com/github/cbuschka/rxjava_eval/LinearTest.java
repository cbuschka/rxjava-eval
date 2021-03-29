package com.github.cbuschka.rxjava_eval;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LinearTest
{
	@Test
	void linearPrintln()
	{
		List<String> messages = Arrays.asList("Hello", "World", "!");

		Observable.fromIterable(messages)
				.subscribe((m) -> System.err.println("Subscriber: " + m))
				.dispose();
	}
}
