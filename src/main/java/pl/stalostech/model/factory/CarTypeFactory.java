package pl.stalostech.model.factory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.stalostech.model.CarType;

@Component
public class CarTypeFactory {

	@Autowired
	private FactoryUtils factoryUtils;

	public List<CarType> getCarTypes() {

		return IntStream.range(0, 10000).mapToObj(i -> new CarType(factoryUtils.randomNumber(1, 4), factoryUtils.randomString(),
				factoryUtils.dateFromYear(factoryUtils.randomNumber(1990, 2016)))).collect(Collectors.toList());

	}

}
