package castleBooker.discounts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import castleBooker.model.discount.Discount;
import castleBooker.model.discount.DiscountData;

class DiscountLoaderData {

	@Test
	public void addElements() {
		DiscountData d = new DiscountData();
		d.addDiscount("1", Discount.EXTRA10);
		d.addDiscount("2", Discount.EXTRA25);
		d.addDiscount("2", Discount.EXTRA10);
		d.addDiscount("3", Discount.EXTRA25);
		d.saveFile();
	}
	
	@Test
	public void readElements() {
		DiscountData d = new DiscountData();
		assertEquals(Discount.EXTRA10, d.getDiscount("1"));
		assertEquals(Discount.EXTRA25, d.getDiscount("2"));
		assertNotEquals(Discount.EXTRA10, d.getDiscount("2"));
		assertEquals(Discount.EXTRA25, d.getDiscount("3"));
	}

}
