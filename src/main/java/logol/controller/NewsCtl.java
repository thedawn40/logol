package logol.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import logol.common.RestResponse;
import logol.model.News;
import logol.service.NewsSvc;


@RestController
@RequestMapping("/news")
public class NewsCtl {
	
	@Autowired
	NewsSvc newsSvc;
		
	@GetMapping("")
	public RestResponse findAll() {
		RestResponse map = new RestResponse();
		try {
			List<News> users = newsSvc.findAll();
			map.setStatus(1);
			map.setMessage("Success");
			map.setTotalRecords(users.size());
			map.setContents(users);
			return map;
		}catch(Exception e) {
			e.printStackTrace();
			map.setStatus(0);
			map.setMessage("Failed");
			map.setContents(null);
			map.setTotalRecords(0);
			return map;
		}
	}
	
	@PostMapping("/insert")
	public RestResponse insert(@RequestBody Map<String,Object> mapInput) {	
		RestResponse map = new RestResponse();
		try {						
			News news = new News();
			news.setId(mapInput.get("id").toString());
			news.setTitle(mapInput.get("title").toString());
			news.setDescription(mapInput.get("description").toString());
			news.setCreatedDate(new Date());
			int status = newsSvc.insert(news);
			if(status==1) {
				map.setStatus(status);
				map.setMessage("Success");				
			}else {
				map.setStatus(status);
				map.setMessage("Failed");				
			}
			return map;
		}catch(Exception e) {
			map.setStatus(0);
			map.setMessage(e.getMessage());
			return map;
		}
	}

	@PutMapping("/update")
	public RestResponse update(@RequestBody Map<String,Object> mapInput) {	
		RestResponse map = new RestResponse();
		try {						
			News news = new News();
			news.setId(mapInput.get("id").toString());
			news.setTitle(mapInput.get("title").toString());
			news.setDescription(mapInput.get("description").toString());
			int status = newsSvc.update(news);
			if(status==1) {
				map.setStatus(status);
				map.setMessage("Success");				
			}else {
				map.setStatus(status);
				map.setMessage("Failed");				
			}
			return map;
		}catch(Exception e) {
			map.setStatus(0);
			map.setMessage(e.getMessage());
			return map;
		}
	}

	@PostMapping("/delete")
	public RestResponse delete(@RequestBody Map<String,Object> mapInput) {	
		RestResponse map = new RestResponse();
		try {						
			String id = mapInput.get("id").toString();
			int status = newsSvc.delete(id);
			if(status==1) {
				map.setStatus(status);
				map.setMessage("Success");				
			}else {
				map.setStatus(status);
				map.setMessage("Failed");				
			}
			return map;
		}catch(Exception e) {
			map.setStatus(0);
			map.setMessage(e.getMessage());
			return map;
		}
	}


}
