package com.kristal.ai.service;

import java.util.List;
import java.util.Map;

import com.kristal.ai.domain.NumberEntity;

public interface IKristalService {

	
	public Map<String, List<Integer>> getCumulativeResult(List<NumberEntity> numbers);
	
}
