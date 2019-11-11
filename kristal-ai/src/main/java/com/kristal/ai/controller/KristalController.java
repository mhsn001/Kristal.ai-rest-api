package com.kristal.ai.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kristal.ai.domain.NumberEntity;
import com.kristal.ai.service.IKristalService;



@RestController
@RequestMapping("/emission")
public class KristalController {
	
	@Autowired
	IKristalService kristalService;
			
	@RequestMapping(path ="/numbers", method = RequestMethod.POST, produces = "application/json")
	public Map<String, List<Integer>> saveEmployee(@RequestBody List<NumberEntity> numbers){
		
		Map<String, List<Integer>> map = kristalService.getCumulativeResult(numbers);
		
		return map;
	}
	
	
	@RequestMapping(path ="/numbers", method = RequestMethod.GET)
	public List<NumberEntity> getDummyNums(){

		List<NumberEntity> nums = new ArrayList<NumberEntity>();
		for(int i =1; i<=5; i++) {
			NumberEntity num = new NumberEntity(Arrays.asList(1*i,2*i,3*i,4*i,5*i), new Date().getTime());
			nums.add(num);
		}
		
		System.out.println(nums.toString());
		return nums;
	}
	
}
