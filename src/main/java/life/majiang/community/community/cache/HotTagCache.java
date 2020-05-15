package life.majiang.community.community.cache;

import life.majiang.community.community.dto.HotTagDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Data
public class HotTagCache {
    private List<String> hots = new ArrayList<>();

    public void updateTags(Map<String, Integer> tags) {
        int max = 10;
        //创建优先队列(小顶堆)
        PriorityQueue<HotTagDTO> priorityQueue = new PriorityQueue<>();

        tags.forEach((name, priority) -> {
            HotTagDTO hotTagDTO = new HotTagDTO();
            hotTagDTO.setName(name);
            hotTagDTO.setPriority(priority);
            if (priorityQueue.size() < max) {
                priorityQueue.add(hotTagDTO);
            } else {
                HotTagDTO minHot = priorityQueue.peek();
                //将新加的与队列中最小的元素进行比较
                if (hotTagDTO.compareTo(minHot) > 0) {
                    //若新元素大于队列最小元素，取出最小元素，加入新元素
                    priorityQueue.poll();
                    priorityQueue.add(hotTagDTO);
                }
            }
        });

        List<String> sortedTags = new ArrayList<>();

        HotTagDTO poll = priorityQueue.poll();
        while (poll != null) {
            sortedTags.add(0, poll.getName());
            poll = priorityQueue.poll();
        }

        hots = sortedTags;
        System.out.println(hots);

    }
}
