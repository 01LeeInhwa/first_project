package shop.mtcoding.project.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import shop.mtcoding.project.dto.skill.ResumeSkillresp.ResumeSkillRespDto;

@Mapper
public interface SkillRepository {
    public void findAll();
    public void findById();

    public List<ResumeSkillRespDto> findByUserSkill(Integer resumeId);

    public int insertRequiredSkill(
        @Param("skillList") List<String> skillList,
        @Param("jobsId") Integer jobsId
    );

    public int insertResumeSkill(
        @Param("skillList") List<String> skillList,
        @Param("resumeId") Integer resumeId
    );

    public int updateRequiredSkillById(
        @Param("skillList") List<String> skillList
    );

    public int updateResumeSkillById(
        @Param("skillList") List<String> skillList
    );

    public int deleteByResumeId(Integer resumeId);
    public int deleteByJobsId(Integer jobsId);
}
