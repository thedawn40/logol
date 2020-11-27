package logol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import logol.dao.NewsDao;
import logol.model.News;
import logol.service.NewsSvc;

@Service
public class NewsSvcImpl implements NewsSvc{
	
	@Autowired
	NewsDao newsDao;

	@Override
	public List<News> findAll() {
		try {
			return newsDao.findAll();			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int insert(News news) {
		try {
			newsDao.insertNews(news.getId(), news.getTitle(), news.getDescription(), news.getCreatedDate());
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(News news) {
		try {
			newsDao.updateNews(news.getId(), news.getTitle(), news.getDescription());
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(String id) {
		try {
			newsDao.deleteById(id);
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
