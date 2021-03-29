package com.github.cbuschka.rxjava_eval;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ZipTest
{
	private final List<String> output = new ArrayList<>();

	@Test
	void zip()
	{
		Observable.zip(
				Observable.fromIterable(Arrays.asList("1", "2", "3")),
				Observable.fromIterable(Arrays.asList("a", "b", "c")),
				(number, letter) -> number + letter
		)
				.subscribe(output::add)
				.dispose();

		assertThat(output).containsExactly("1a", "2b", "3c");
	}

	@Test
	void zipLastOfLeftLost()
	{
		Observable.zip(
				Observable.fromIterable(Arrays.asList("1", "2", "3")),
				Observable.fromIterable(Arrays.asList("a", "b")),
				(number, letter) -> number + letter
		)
				.subscribe(output::add)
				.dispose();

		assertThat(output).containsExactly("1a", "2b");
	}

	@Test
	void zipLastOfRightLost()
	{
		Observable.zip(
				Observable.fromIterable(Arrays.asList("1", "2")),
				Observable.fromIterable(Arrays.asList("a", "b", "c")),
				(number, letter) -> number + letter
		)
				.subscribe(output::add)
				.dispose();

		assertThat(output).containsExactly("1a", "2b");
	}
}
