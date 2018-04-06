package com.example.strig.mobilecomputingclass.le180213_Fragments;

import com.example.strig.mobilecomputingclass.R;

public class Movie {
    private String description;
    private String title;
    private String director;
    private double rating;
    private int poster;

    public static final Movie[] movies = {
            new Movie("Pulp Fiction",
                    "Quentin Tarantino",
                    "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
                    8.9,
                    R.drawable.pulp_fiction),
            new Movie("Hot Fuzz",
                    "Edgar Wright",
                    "A skilled London police officer is transferred to a small town that's harbouring a dark secret.",
                    7.9,
                    R.drawable.hot_fuzz),
            new Movie("Inception",
                    "Christopher Nolan",
                    "A thief, who steals corporate secrets through the use of dream-sharing technology, is given the inverse task of planting an idea into the mind of a CEO.",
                    8.8,
                    R.drawable.inception)
    };

    private Movie(String title, String director, String description, double rating, int poster) {
        this.title = title;
        this.director = director;
        this.description = description;
        this.rating = rating;
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
