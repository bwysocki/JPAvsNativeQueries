package pl.stalostech.model.factory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.stalostech.model.Client;

@Component
public class ClientFactory {

	@Autowired
	private FactoryUtils factoryUtils;

	public List<Client> getClients() {
		return IntStream.range(0, 1000)
				.mapToObj(i -> new Client(factoryUtils.randomString(), factoryUtils.randomString()))
				.collect(Collectors.toList());
	}

}
