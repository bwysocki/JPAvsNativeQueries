package pl.stalostech.model.factory;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.Year;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import pl.stalostech.model.CarType;

@Component
public class CarTypeFactory {

	private SecureRandom random = new SecureRandom();

	public List<CarType> getCarTypes() {

		List<CarType> carTypes = IntStream.range(0, 10000)
				.mapToObj(i -> new CarType(randomNumber(1, 4), "", dateFromYear(randomNumber(1990, 2016))))
				.collect(Collectors.toList());

		return carTypes;
	}

	public Date dateFromYear(int year) {
		return Date.from(Year.of(year).atDay(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public int randomNumber(int low, int high) {
		return new Random().nextInt(high - low) + low;
	}

	public String randomString() {
		return new BigInteger(130, random).toString(200);
	}

}
