package shop.mtcoding.project.model;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResumeRepository {
    public void findAll();
    public void findById(

    );
    public int insert(

    );
    public int updateById(

    );
    public int deleteById(

    );
}