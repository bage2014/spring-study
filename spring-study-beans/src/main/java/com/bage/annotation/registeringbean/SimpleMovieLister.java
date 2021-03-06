package com.bage.annotation.registeringbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="registeringbeanSimpleMovieLister")
public class SimpleMovieLister {

        private MovieFinder movieFinder;

        @Autowired
        public SimpleMovieLister(MovieFinder movieFinder) {
                this.movieFinder = movieFinder;
        }

        @Override
		public String toString() {
			return "SimpleMovieLister [movieFinder=" + movieFinder + "]";
		}
        
}
