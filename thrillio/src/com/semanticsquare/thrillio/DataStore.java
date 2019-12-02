package com.semanticsquare.thrillio;

import java.util.ArrayList;
import java.util.List;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.constants.Gender;
import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.constants.UserType;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.entities.UserBookmark;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import com.semanticsquare.thrillio.managers.UserManager;
import com.semanticsquare.thrillio.util.IOUtil;

public class DataStore {
	
	private static List<User> users = new ArrayList<>();
	public static List<User> getUsers() {
		return users;
	}

	private static List<List<Bookmark>> bookmarks = new ArrayList<>();
	public static List<List<Bookmark>> getBookmarks() {
		return bookmarks;
	}

	private static List<UserBookmark> userBookmarks = new ArrayList<>();
	public static List<UserBookmark> getUserBookmarks() {
		return userBookmarks;
	}

	
	public static void loadData() {
		loadUsers();
		loadWebLinks();
		loadMovies();
		loadBooks();
	}

	private static void loadUsers() {
//		String[] data = new String[TOTAL_USER_COUNT];
		
		List<String> data = new ArrayList<>(); 
		IOUtil.read(data, "User.txt");
		for(String row: data) { 
			String[] values = row.split("\t");
			
			int gender = Gender.MALE;
			if(values[5].equals("f")) {
				gender = Gender.FEMALE;
			} else if(values[5].equals("t")) {
				gender = Gender.TRANSGENDER;
			}
			
			User user = UserManager.getInstance().createUser(Long.parseLong(values[0]), values[1], values[2], values[3], values[4], gender, values[6]);
			users.add(user); 
		}
	}

	private static void loadWebLinks() {
		List<String> data = new ArrayList<>(); 
		IOUtil.read(data, "Web-Link.txt");
		
		List<Bookmark> bookmarkList = new ArrayList<>();
		for(String row : data) {
			String[] values = row.split("\t");
			Bookmark bookmark = BookmarkManager.getInstance().createWebLink(Long.parseLong(values[0]), values[1], values[2], values[3]/*, values[4]*/);
			bookmarkList.add(bookmark);
		}
		bookmarks.add(bookmarkList);
	}

	private static void loadMovies() {
		List<String> data = new ArrayList<>(); 
		IOUtil.read(data, "Movie.txt");
		
		List<Bookmark> bookmarkList = new ArrayList<>();
		for (String row: data) {
			String[] values = row.split("\t");
			String[] casts = values[3].split(",");
			String[] directors = values[4].split(",");
			Bookmark bookmark =  BookmarkManager.getInstance().createMovie(Long.parseLong(values[0]), values[1], "", Integer.parseInt(values[2]), casts, directors, values[5], Double.parseDouble(values[6])/*, values[7]*/);
			bookmarkList.add(bookmark);
		}
		bookmarks.add(bookmarkList);
	}

	private static void loadBooks() {
		List<String> data = new ArrayList<>(); 
		IOUtil.read(data, "Book.txt");

		List<Bookmark> bookmarkList = new ArrayList<>();
		for(String row : data) {
			String[] values = row.split("\t");
			String[] authors = values[4].split(",");
			Bookmark bookmark = BookmarkManager.getInstance().createBook(Long.parseLong(values[0]), values[1], Integer.parseInt(values[2]), values[3], authors, values[5], Double.parseDouble(values[6])/*, values[7]*/);
			bookmarkList.add(bookmark);
		}
		bookmarks.add(bookmarkList);
	}

	public static void add(UserBookmark userBookmark) {
		userBookmarks.add(userBookmark);
	}

}
