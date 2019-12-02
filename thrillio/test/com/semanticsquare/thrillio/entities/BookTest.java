package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.managers.BookmarkManager;


public class BookTest {
	@Test
	void testIsKidFriendlyEligible() {
		//Test 1: Philosophy Genre isKidFriendlyEligible -- false
		Book book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.PHILOSOPHY, 4.3);
		
		boolean isKidFriendlyEligible = book.isKidFriendlyEligible();
		assertFalse("For Pholisophy Genre isKidFriendlyEligible should return false", isKidFriendlyEligible);
		
		//Test 2: Genre isKidFriendlyEligible -- false
		book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.SELF_HELP, 4.3);
		isKidFriendlyEligible = book.isKidFriendlyEligible();
		assertFalse("For Self-Help Genre isKidFriendlyEligible should return false", isKidFriendlyEligible);
		
	}

}
