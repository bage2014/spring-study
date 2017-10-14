package com.bage.annotation.resource;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component(value="simpleMovieListerResource")
public class SimpleMovieLister {

	private MovieFinder myMovieFinder;

    @Resource() // 可以指定 name,默认是 name="属性名" 即 myMovieFinder
    public void setMyMovieFinder(MovieFinder myMovieFinder) {
            this.myMovieFinder = myMovieFinder;
    }

	public MovieFinder getMyMovieFinder() {
		return myMovieFinder;
	}

	@Override
	public String toString() {
		return "SimpleMovieLister [myMovieFinder=" + myMovieFinder + "]";
	}
    
}
