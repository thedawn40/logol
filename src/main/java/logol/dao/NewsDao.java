package logol.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import logol.model.News;

public interface NewsDao extends JpaRepository<News, String>{
	
	@Modifying
	@Query(value="insert into news (id, title, description, created_date) values (:id, :title, :desc, :created)", nativeQuery = true)
	@Transactional
	void insertNews(@Param("id")String id,  @Param("title")String title,  @Param("desc")String desc, @Param("created")Date createdDate);

	@Modifying
	@Query(value="update news set title=:title, description=:desc where id=:id", nativeQuery = true)
	@Transactional
	void updateNews(@Param("id")String id,  @Param("title")String title,  @Param("desc")String desc);

}
