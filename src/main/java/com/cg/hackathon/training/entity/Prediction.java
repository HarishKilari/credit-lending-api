package com.cg.hackathon.training.entity;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class Prediction {
	private List<String> classes;
	private List<Double> scores;

	public List<String> getClasses() {
		return classes;
	}

	public void setClasses(List<String> classes) {
		this.classes = classes;
	}

	public List<Double> getScores() {
		return scores;
	}

	public void setScores(List<Double> scores) {
		this.scores = scores;
	}
}
	    
	    

