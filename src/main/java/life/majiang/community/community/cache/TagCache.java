package life.majiang.community.community.cache;

import life.majiang.community.community.dto.TagDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagCache {
    public static List<TagDTO> get() {
        List<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("JS", "PHP", "CSS", "HTML", "HTML5", "node", "python", "C", "C++", "JAVA", "VB", "VC", "FoxPro", "Delphi", "SQL", "ASP", "JSP"));
        tagDTOS.add(program);

        TagDTO framework = new TagDTO();
        framework.setCategoryName("平台框架");
        framework.setTags(Arrays.asList("laravel", "spring", "express", "django", "flask", "yli", "ruby-on-rails", "tornado", "koa", "struts"));
        tagDTOS.add(framework);

        TagDTO server = new TagDTO();
        server.setCategoryName("服务器");
        server.setTags(Arrays.asList("tomcat", "Resin", "JBoss", "WebSphere", "WebLogic", "linux", "nginx", "docker", "centos"));
        tagDTOS.add(server);

        TagDTO db = new TagDTO();
        db.setCategoryName("数据库");
        db.setTags(Arrays.asList("mysql", "sql", "oracle", "sqlite"));
        tagDTOS.add(db);

        TagDTO tool = new TagDTO();
        tool.setCategoryName("开发工具");
        tool.setTags(Arrays.asList("git", "maven", "github", "vim", "eclipse", "ide", "IntelliJ IDEA"));
        tagDTOS.add(tool);

        return tagDTOS;
    }

    public static String filterInvalid(String tags){
        //将字符串转化为数组
        String[] split = StringUtils.split(tags, ",");
        List<TagDTO> tagDTOS = get();

        //将获取的List<TagDTO>的所有Tags抽出来变成List<String>
        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());

        //将传入的Tag数据与所有静态Tags进行对比筛选出静态Tags中没有的字符串并获取
        String invalid = Arrays.stream(split).filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));


        return invalid;
    }

}