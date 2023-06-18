package org.money.institution.utils;

import java.util.List;
import java.util.stream.Stream;

public interface IEntityUtil<T> {
	
	static <T> Stream<T> getStream(List<T> list) {
		return list.stream();
	}
	

}
