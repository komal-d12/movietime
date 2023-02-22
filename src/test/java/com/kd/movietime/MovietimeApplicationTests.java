package com.kd.movietime;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.kd.movietime.data.entity.Movie;
import com.kd.movietime.data.entity.Show;
import com.kd.movietime.data.entity.Theatre;
import com.kd.movietime.data.entity.User;
import com.kd.movietime.service.ShowService;
import com.kd.movietime.service.TheatreService;
import com.kd.movietime.service.UserService;

@SpringBootTest
class MovietimeApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private TheatreService theatreService;

	@Autowired
	private ShowService showService;

	@Test
	void generateTestData() {

		User user1 = new Gson().fromJson(
				"{\n" + "    \"firstName\": \"Jim\",\n" + "    \"lastName\": \"Halpert\",\n"
						+ "    \"address\": \"5th Avenue, Main Street\",\n" + "    \"city\": \"Scranton\",\n"
						+ "    \"mobile\": \"9999999991\",\n" + "    \"email\": \"jim.halpert@abc.com\"\n" + "}",
				User.class);

		User user2 = new Gson().fromJson(
				"{\n" + "    \"firstName\": \"Pamela\",\n" + "    \"lastName\": \"Beasley\",\n"
						+ "    \"address\": \"4th Cross, 9th Street\",\n" + "    \"city\": \"Scranton\",\n"
						+ "    \"mobile\": \"9999999992\",\n" + "    \"email\": \"pam.beasley@abc.com\"\n" + "}",
				User.class);

		User user3 = new Gson().fromJson(
				"{\n" + "    \"firstName\": \"Dwight\",\n" + "    \"lastName\": \"Shrute\",\n"
						+ "    \"address\": \"11, Main Street\",\n" + "    \"city\": \"Scranton\",\n"
						+ "    \"mobile\": \"9999999993\",\n" + "    \"email\": \"dwight.shrute@abc.com\"\n" + "}",
				User.class);

		userService.createUser(user1);
		userService.createUser(user2);
		userService.createUser(user3);

		Theatre theatre1 = new Theatre();
		theatre1.setName("Maratha Mandir");
		theatre1.setCity("Mumbai");

		Theatre theatre2 = new Theatre();
		theatre2.setName("Urvashi Cinema");
		theatre2.setCity("Bangalore");

		theatreService.createTheatre(theatre1);
		theatreService.createTheatre(theatre2);

		Show show1 = new Show();
		show1.setDateTime(LocalDateTime.of(2023, 02, 20, 12, 0, 0));
		show1.setPrice(400.00);
		show1.setTheatre(theatre1);
		Movie movie1 = new Movie();
		movie1.setName("Pathaan");
		movie1.setCast("\"Shahrukh Khan\", \"Deepika Padukone\", \"John Abraham\"");
		show1.setMovie(movie1);
		showService.createOrUpdateShow(show1);

		Show show2 = new Show();
		show2.setDateTime(LocalDateTime.of(2023, 02, 22, 16, 0, 0));
		show2.setPrice(200.00);
		show2.setTheatre(theatre1);
		Movie movie2 = new Movie();
		movie2.setName("Shehzada");
		movie2.setCast("\"Karthik Aryan\", \"Kriti Sanon\"");
		show2.setMovie(movie2);
		showService.createOrUpdateShow(show2);

		Show show3 = new Show();
		show3.setDateTime(LocalDateTime.of(2023, 02, 22, 13, 30, 0));
		show3.setPrice(300.00);
		show3.setTheatre(theatre2);
		show3.setMovie(movie1);
		showService.createOrUpdateShow(show3);

		Show show4 = new Show();
		show4.setDateTime(LocalDateTime.of(2023, 02, 24, 16, 0, 0));
		show4.setPrice(240.00);
		show4.setTheatre(theatre2);
		Movie movie4 = new Movie();
		movie4.setName("Love Birds");
		movie4.setCast("\"Darling Krishna\", \"Milana Nagraj\"");
		show4.setMovie(movie4);
		showService.createOrUpdateShow(show4);

	}

}
