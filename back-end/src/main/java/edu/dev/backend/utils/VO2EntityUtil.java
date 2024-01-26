package edu.dev.backend.utils;

import edu.dev.backend.VO.opinion.OpinionVO;
import edu.dev.backend.VO.policyDetail.PolicyVO;
import edu.dev.backend.VO.policyDetail.TagVO;
import edu.dev.backend.entity.Opinion;
import edu.dev.backend.entity.Policy;
import edu.dev.backend.entity.SysDept;
import edu.dev.backend.entity.Tag;
import edu.dev.backend.service.SysDeptService;
import edu.dev.backend.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By  @林俊杰
 * 2022/3/29 11:58
 *
 * @version 1.0
 */
public class VO2EntityUtil {


    public static Policy policyVO2policy(PolicyVO policyVO,SysDeptService deptService){
        Policy res = new Policy();
        res.setId(policyVO.getPolicy_id());
        SysDept dept = deptService.findOneByName(policyVO.getPost_agency());
        res.setAuthor(dept.getId());
        res.setCode(policyVO.getIssue_number());
        res.setContent(policyVO.getText_content());
        res.setTitle(policyVO.getText_title());
        res.setType(policyVO.getPost_type());
        res.setCreateTime(policyVO.getCreate_date());
        res.setUpdateTime(policyVO.getRelease_date());
        return res;
    }

    public static List<Tag> policyVO2TagList(PolicyVO policyVO,TagService tagService){
        List<Tag> tags = new ArrayList<>();
        List<TagVO> tagVOList = policyVO.getPost_tags();
        if(tagVOList!=null) {
            for (TagVO tagVO : tagVOList) {

                Tag tag = tagService.findOneByContent(tagVO.getTag_content());
                if (tag==null) tag = tagService.addTagByContent(tagVO.getTag_content());

                tags.add(tag);
            }
        }
        else {tags=null;}
        return tags;
    }

    public static List<OpinionVO> opinions2OpinionVOs(List<Opinion> opinions){
        List<OpinionVO> voList = new ArrayList<>();
        if (opinions==null||opinions.isEmpty()) return null;
        for (Opinion opinion:opinions) {
            OpinionVO vo = new OpinionVO();
            vo.setContent(opinion.getContent());
            vo.setDate(opinion.getCreateTime());
            vo.setName(opinion.getName());
            vo.setPhone(opinion.getPhone());
            vo.setPolicy_id(opinion.getPolicyId());
            voList.add(vo);
        }
        return voList;
    }
}
