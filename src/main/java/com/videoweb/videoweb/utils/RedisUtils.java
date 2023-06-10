package com.videoweb.videoweb.utils;

import com.videoweb.videoweb.model.Videodata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class RedisUtils {
    private static final String PREFIX = "video";
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    public void saveVideo(Videodata video) {
        String key = PREFIX + video.getVideoId();
        redisTemplate.opsForHash().putAll(key, video.toMap());
        redisTemplate.opsForZSet().add("videos", key, video.getPlays());
    }

    public void increasePlays(String videoId){
        String key=PREFIX+videoId;
        redisTemplate.opsForHash().increment(key,"plays",1);
        redisTemplate.opsForZSet().incrementScore("videos", key, 1);
    }
    public List<Videodata> getPopularVideos(){
        Set<Object> videoKeys=redisTemplate.opsForZSet().reverseRange("videos",0,12);
        List<Videodata> videos = new ArrayList<>();
        for(Object videoKey:videoKeys){
            Map<Object, Object> map = redisTemplate.opsForHash().entries((String)videoKey);
            Videodata video = new Videodata();
            video.fromMap(map);
            videos.add(video);
        }
        return videos;
    }

    public Videodata getVideoById(Videodata video) {
        String key = PREFIX + video.getVideoId();
        Map<Object, Object> map = redisTemplate.opsForHash().entries(key);
        Videodata cachedVideo = new Videodata();
        cachedVideo.fromMap(map);
        return cachedVideo;
    }
}
