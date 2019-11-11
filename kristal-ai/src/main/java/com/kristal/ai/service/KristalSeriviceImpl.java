package com.kristal.ai.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kristal.ai.domain.NumberEntity;

@Service
public class KristalSeriviceImpl implements IKristalService{

	@Override
	public Map<String, List<Integer>> getCumulativeResult(List<NumberEntity> numbers) {

		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
				
		List<Integer> cumulativeNums = new ArrayList<Integer>();
		
		for(int i =0; i < numbers.size(); i++) {
			
			if(i == 301){// last five mins data (0 to 5 mins)
			map.put("five_mins_data", cumulativeNums);
			}else if(i == 601) {// last thirty mins data (0 to 10 mins)
				map.put("ten_mins_data", cumulativeNums);	
			}
			else if(i == 18001) { // last 30 mins data (0 to 30 mins)
				map.put("thirty_mins_data", cumulativeNums);	
			}else {
				cumulativeNums.addAll(numbers.get(i).getNumbers()); 
			}
		}
		
		if(!map.containsKey("five_mins_data")) {
			map.put("five_mins_data", cumulativeNums);
		}else if(!map.containsKey("ten_mins_data") && numbers.size() > 301) {
			map.put("ten_mins_data", cumulativeNums);
		}else if(!map.containsKey("thirty_mins_data") && numbers.size() > 601) {
			map.put("thirty_mins_data", cumulativeNums);
		}
		return map;
	}
	
}
