package model;

import java.util.List;

public class PostTweetLogic {
	public void execute(Tweet tweet, List<Tweet> tweetList){
		// add to top
		tweetList.add(0, tweet);
	}
}
