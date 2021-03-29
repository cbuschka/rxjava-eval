package com.github.cbuschka.rxjava_eval;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StockUpdateTest
{
	private final List<String> output = new ArrayList<>();

	public enum Outcome
	{
		UPDATED,
		NOT_UPDATED;
	}

	@Test
	void stockUpdateExample()
	{
		Observable.fromIterable(Arrays.asList(new StockUpdateRequest("S1", "S1.I1", 1, )))
				.subscribe(output::add)
				.dispose();

		assertThat(output).containsExactly("1", "2", "3");
	}

	public static class StockUpdateRequest
	{
		public String supplierNo;
		public String itemNo;
		public int amount;
		public int reportedAt;

		public StockUpdateRequest(String supplierNo, String itemNo, int amount, int reportedAt)
		{
			this.supplierNo = supplierNo;
			this.itemNo = itemNo;
			this.amount = amount;
			this.reportedAt = reportedAt;
		}
	}

	public static class SupplierData
	{
		public String supplierNo;

		public SupplierData(String supplierNo)
		{
			this.supplierNo = supplierNo;
		}
	}

	public static class ItemData
	{
		public String supplierNo;
		public String itemNo;

		public ItemData(String supplierNo, String itemNo)
		{
			this.supplierNo = supplierNo;
			this.itemNo = itemNo;
		}
	}

	public static class SupplierItemData
	{
		public String supplierNo;
		public String itemNo;
		public int amount;
		public int reportedAt;

		public SupplierItemData(String supplierNo, String itemNo, int amount, int reportedAt)
		{
			this.supplierNo = supplierNo;
			this.itemNo = itemNo;
			this.amount = amount;
			this.reportedAt = reportedAt;
		}
	}
}
