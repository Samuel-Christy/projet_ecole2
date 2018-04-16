package factories;

import com.github.javafaker.Faker;

public class FakerUtils {

	private static Faker faker;

	public static Faker getFaker() {
		if (faker != null)
			return faker;
		faker = new Faker();
		return faker;
	}

}
