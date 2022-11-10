package com.tcs.rmg.data;

public class RequestorRecommendationCount {
	
	
	Integer recommendationCount;
	
	public RequestorRecommendationCount() {
        //default Constructor
	}

	public RequestorRecommendationCount(Integer recommendationCount){
		this.recommendationCount = recommendationCount;
	}

	public Integer getRecommendationCount() {
		return recommendationCount;
	}

	public void setRecommendationCount(Integer recommendationCount) {
		this.recommendationCount = recommendationCount;
	}

}
