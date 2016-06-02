package pl.stalostech.model.factory;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.Year;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

@Component
public class FactoryUtils {

	private SecureRandom random = new SecureRandom();

	public Date dateFromYear(int year) {
		return Date.from(Year.of(year).atDay(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public int randomNumber(int low, int high) {
		return new Random().nextInt(high - low) + low;
	}

	public String randomString() {
		return new BigInteger(130, random).toString(100);
	}

	public <T> T getRandomFromList(List<T> list) {
		if (list.isEmpty()) {
			return null;
		}
		return list.get(ThreadLocalRandom.current().nextInt(0, list.size()));
	}
	
	public <T> Set<T> getRandomMaxFromList(List<T> list, int max) {
		Set<T> r = new HashSet<>();
		
		int limit = ThreadLocalRandom.current().nextInt(0, max + 1);
		for (int i = 0; i < limit; i++) {
			r.add(getRandomFromList(list));
		}
		return r;
	}

}
