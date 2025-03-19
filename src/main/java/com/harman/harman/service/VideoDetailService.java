package com.harman.harman.service;

import com.harman.harman.model.VideoDetail;
import com.harman.harman.repository.VideoDetailRepo;
import com.harman.harman.wrapper.EngagementStatsWrapper;
import com.harman.harman.wrapper.VideoDetailWrapper;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.harman.harman.utils.VideoSpacification.*;

@Service
public class VideoDetailService {

    @Autowired
    private VideoDetailRepo videoDetailRepo;


    public VideoDetail publishVideo(VideoDetail video) {
        video.setDeListed(Boolean.FALSE);
        video.setImpressions(0);
        video.setViews(0);
        return videoDetailRepo.save(video);
    }

    public VideoDetail updateMetadata(Integer id, VideoDetail video)  {

        VideoDetail existingVideo = videoDetailRepo.findById(id).get();
        existingVideo.setTitle(video.getTitle());
        existingVideo.setSynopsis(video.getSynopsis());
        existingVideo.setDirector(video.getDirector());
        existingVideo.setCastName(video.getCastName());
        existingVideo.setYearOfRelease(video.getYearOfRelease());
        existingVideo.setGenre(video.getGenre());
        existingVideo.setRunningTime(video.getRunningTime());
        return videoDetailRepo.save(existingVideo);
    }

    public void delistVideo(Integer id) {
        VideoDetail existingVideo = videoDetailRepo.findById(id).get();
        existingVideo.setDeListed(Boolean.TRUE);
        videoDetailRepo.save(existingVideo);
    }

    public VideoDetail loadVideo(Integer id) {
        VideoDetail video = videoDetailRepo.findById(id).get();
        video.setImpressions(video.getImpressions() + 1);  // Increment impressions
        return videoDetailRepo.save(video);
    }

    public String playVideo(Integer id) {
        VideoDetail video = videoDetailRepo.findById(id).get();
        video.setViews(video.getViews() + 1);
        videoDetailRepo.save(video);
        String result = "Video content for: "+ video.getTitle()+" and "+ video.getDirector() + " is playing And the video has been viewed "+ video.getViews()+" times";
        return result;
    }
    public List<VideoDetailWrapper> listVideos() {
        List<VideoDetailWrapper> result = videoDetailRepo.findAll().stream().filter(x-> x.getDeListed().equals(Boolean.FALSE)).map( video -> new VideoDetailWrapper(
                video.getTitle(),
                video.getDirector(),
                video.getCastName(),
                video.getGenre(),
                video.getRunningTime()
        )).collect(Collectors.toList());
        return  result;
    }


    public List<VideoDetailWrapper> searchVideos(String directorName, String title, String cast, String genre) {
            Specification<VideoDetail> filters = Specification.where(StringUtils.isBlank(directorName) ? null : derector(directorName))
                    .and(StringUtils.isBlank(title) ? null : title(title))
                    .and(StringUtils.isEmpty(genre) ? null : genre(genre))
                    .and(StringUtils.isEmpty(cast) ? null : castName(cast).and(deListed()));
        List<VideoDetailWrapper>  result = videoDetailRepo.findAll(filters).stream().map(video -> new VideoDetailWrapper(
                    video.getTitle(),
                    video.getDirector(),
                    video.getCastName(),
                    video.getGenre(),
                    video.getRunningTime()
            )).collect(Collectors.toList());
        return result;
    }

    public EngagementStatsWrapper getEngagementStats(Integer id) {
       VideoDetail data= videoDetailRepo.findById(id).get();
       EngagementStatsWrapper engagementStatsWrapper = new EngagementStatsWrapper(data.getImpressions() , data.getViews());
         return engagementStatsWrapper;

    }
}
