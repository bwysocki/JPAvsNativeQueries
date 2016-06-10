package pl.stalostech.jpavsnative.jpa;

import java.util.List;

import pl.stalostech.model.MatViewAsCache;

public interface JpaOperationsHelper {

	List<MatViewAsCache> readWithCache();
	
}
