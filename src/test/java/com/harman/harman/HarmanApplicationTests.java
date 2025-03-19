package com.harman.harman;

import com.harman.harman.controller.VideoDetailController;
import com.harman.harman.model.VideoDetail;
import com.harman.harman.service.VideoDetailService;
import com.harman.harman.wrapper.EngagementStatsWrapper;
import com.harman.harman.wrapper.VideoDetailWrapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
class HarmanApplicationTests {

	@Autowired
	VideoDetailController videoDetailController;

	@Autowired
	VideoDetailService videoDetailService;


	@Test
	@Order(1)
	void publishVideoTest(){
		 VideoDetail video = new VideoDetail();
		 video.setDirector("Christopher Nolan");
		 video.setTitle("Title");
		 video.setCastName("Leonardo DiCaprio");
		 video.setGenre("Sci-Fi");
		 video.setYearOfRelease("2021");
		 video.setRunningTime(140);
		 video.setSynopsis("A skilled thief is given a chance to have his criminal record erased if he can successfully perform an inception.");
		 ResponseEntity<String> response = videoDetailController.publishVideo(video);
		 Assertions.assertEquals("Video published successfully", response.getBody());
	}

	@Test
	@Order(2)
	void updateMetadataTest(){
		 VideoDetail video = new VideoDetail();
		 video.setDirector("Christopher Nolan");
		 video.setTitle("Title");
		 video.setCastName("Leonardo DiCaprio");
		 video.setGenre("Sci-Fi");
		 video.setYearOfRelease("2021");
		 video.setRunningTime(140);
		 video.setSynopsis("A skilled thief is given a chance to have his criminal record erased if he can successfully perform an inception.");
		 ResponseEntity<String> response = videoDetailController.publishVideo(video);
		 Assertions.assertEquals("Video published successfully", response.getBody());
		 video.setTitle("Updated Title");
		 ResponseEntity<VideoDetail> updatedVideo = videoDetailController.updateMetadata(1, video);
		 Assertions.assertEquals("Updated Title", updatedVideo.getBody().getTitle());
	}

	@Test
	@Order(3)
	void delistVideoTest(){
		 ResponseEntity<String> delistResponse = videoDetailController.delistVideo(1);
		 Assertions.assertEquals("Video delisted successfully", delistResponse.getBody());
	}

	@Test
	@Order(7)
	void TestloadVideo(){
		 ResponseEntity<VideoDetail> loadedVideo = videoDetailController.loadVideo(1);
		 Assertions.assertEquals("Updated Title", loadedVideo.getBody().getTitle());
	}

	@Test
	@Order(5)
	void playVideoTest(){
		 ResponseEntity<String> playResponse = videoDetailController.playVideo(1);
		 Assertions.assertEquals("Video content for: Updated Title and Christopher Nolan is playing And the video has been viewed 1 times", playResponse.getBody());
	}

	@Test
	@Order(6)
	void listVideosTest() {
		ResponseEntity<List<VideoDetailWrapper>> playResponse = videoDetailController.listVideos();
		Assertions.assertNotNull(playResponse.getBody());
	}

	@Test
	@Order(7)
	void searchVideosTest() {
		ResponseEntity<List<VideoDetailWrapper>> playResponse = videoDetailController.searchVideos("Christopher Nolan", "Title", "Leonardo DiCaprio", "Sci-Fi");
		Assertions.assertNotNull(playResponse.getBody());
	}

	@Test
	@Order(8)
	void getEngagementStatsTest() {
		ResponseEntity<EngagementStatsWrapper> playResponse = videoDetailController.getEngagementStats(1);
		Assertions.assertNotNull(playResponse.getBody());
	}


}
