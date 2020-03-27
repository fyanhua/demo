package com.example.demo.cache;

import com.example.demo.dto.TagDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagCache {
    public static List<TagDTO> get() {
        List<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO behave= new TagDTO();
        behave.setCategoryName("行为");
        behave.setTags(Arrays.asList("熬夜", "拖延", "攻击", "暴食", "色欲", "空虚", "困惑", "焦虑"));
        tagDTOS.add(behave);

        TagDTO cure = new TagDTO();
        cure.setCategoryName("治疗");
        cure.setTags(Arrays.asList("心理咨询", "心理测评", "流派方案", "优质诊所", "治疗方法", "创伤治疗"));
        tagDTOS.add(cure);


        TagDTO life = new TagDTO();
        life.setCategoryName("生活");
        life.setTags(Arrays.asList("家庭", "婚姻", "成长过程", "父母", "职业", "孩子", "人际交往","树洞"));
        tagDTOS.add(life);

        TagDTO emotion = new TagDTO();
        emotion.setCategoryName("情绪");
        emotion.setTags(Arrays.asList("压抑", "脆弱", "焦虑调节", "表达", "抑制", "情绪智力"));
        tagDTOS.add(emotion);

        TagDTO out = new TagDTO();
        out.setCategoryName("科普");
        out.setTags(Arrays.asList("心理效应", "实验研究", "犯罪心理", "社会心理",   "名词解释"));
        tagDTOS.add(out);
        return tagDTOS;
    }

    public static String filterInvalid(String tags) {
        String[] split = StringUtils.split(tags, ",");
        List<TagDTO> tagDTOS = get();

        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));
        return invalid;
    }
}