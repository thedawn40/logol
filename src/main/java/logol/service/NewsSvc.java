package logol.service;

import java.util.List;

import logol.model.News;

public interface NewsSvc {
	
	public List<News> findAll();
	public int insert(News news);
	public int update(News news);
	public int delete(String id);
	

}
