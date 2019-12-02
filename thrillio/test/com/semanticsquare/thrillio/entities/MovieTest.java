package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.managers.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {
		//Test 1: Horror Genre isKidfriendlyEligible -- false
		Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);
		boolean isKidFreiendlyEligible = movie.isKidFriendlyEligible();
		assertFalse("For Horror Genre isKidFriendlyEligible method should return false.", isKidFreiendlyEligible);
		
		//Test 2: Thrillers Genre isKidFriendlyEligible -- false
		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);
		isKidFreiendlyEligible = movie.isKidFriendlyEligible();
		assertFalse("For Thrillers Genre isKidFriendlyEligible should return false", isKidFreiendlyEligible);
	}

}
