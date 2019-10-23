package com.revature.client;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.revature.model.Course;

@FeignClient(name = "data", url = "http://localhost:8083/course/all")
public interface DemoFeignClient {
	@RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<Course>> getCourse();

}
