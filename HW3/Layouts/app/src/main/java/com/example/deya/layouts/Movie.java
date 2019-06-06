package com.example.deya.layouts;

import java.util.ArrayList;

public class Movie {

    private String title;
    private String year;
    private String director;
    private String image;
    private String synopsis;

    public Movie() {

    }

    public Movie(String mTitle, String mYear, String mDirector, String mImage, String mSynopsis) {
        setTitle(mTitle);
        setYear(mYear);
        setDirector(mDirector);
        setImage(mImage);
        setSynopsis(mSynopsis);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public static class Builder {
        Movie movie;

        public Builder() {
            movie = new Movie();
        }

        public Builder title(String title) {
            movie.title = title;
            return this;
        }

        public Builder year(String year) {
            movie.year = year;
            return this;
        }

        public Builder director(String director) {
            movie.director = director;
            return this;
        }

        public Builder image(String image) {
            movie.image = image;
            return this;
        }

        public Builder synopsis(String synopsis) {
            movie.synopsis = synopsis;
            return this;
        }

        public Movie build() {
            return movie;
        }
    }

    /** Premade array of movies */
    public static Movie[] initMovies() {

        ArrayList<Movie> moviesAL = new ArrayList<>();

        moviesAL.add(new Movie.Builder()
                .title("Night of the Comet")
                .year("2007")
                .director("Juan Carlos Fresnadillo")
                .image("http://collider.com/wp-content/uploads/2015/08/28-weeks-later.jpg")
                .synopsis("28 Weeks Later is one of those rare sequels that does the original proud, especially when the original is a film as acclaimed and influential as 28 Days Later. Director Juan Carlos Fresnadillo made his English-language directorial debut on the sequel, stepping in for Danny Boyle, and pulled off a fantastic trick in honoring the “franchise style” Boyle established in the original — the quick edits and snarling infected — while evolving it and adding his own visual flourish to the mix. \\n 28 Days Later subverted the conventions of the zombie genre in such clever, convincing ways, it became the modern day zombie template that countless films tried to mimic. 28 Weeks Later was smart enough not to follow the blueprint and flipped the script, depicting the British government’s attempt to rebuild society in the aftermath of the rage virus and the subsequent outbreak that brings it all crashing down. Through the contained military facility we get to witness a small-scale version of the viral apocalypse that we missed in the first film and the desperate, hopeless attempts to stop it. That makes 28 Weeks Later is a bit more of a conventional zombie film, depicting the downfall of society and the breakdown of boundaries in times terror, but it’s a very good conventional zombie movie. Fresnadillo hits all the right notes, lacing the broad arc with intimate family drama and depending on his superb cast to sell every moment of heartbreak amidst the bloodshed. — Haleigh Foutch")
                .build());

        moviesAL.add(new Movie.Builder()
                .title("Night of the Creeps")
                .year("1986")
                .director("Fred Dekker")
                .image("http://cdn.collider.com/wp-content/uploads/2017/10/night-of-the-creeps.jpg")
                .synopsis("The delightfully delirious directorial debut from Monster Squad helmer Fred Dekker, Night of the Creeps is a loving tribute to the zombie genre that’s as packed to the brim with self-reference as it is with cheeky, cheesy fun. The film follows two college boys trying to land a spot in a fraternity in the name of scoring chicks. To earn their initiation, the boys have to sneak into the college medical center, where they discover the long-frozen corpse of a 1950s coed with alien slugs coursing through his brain. Hijinks follow, the body thaws, and space parasites are unleashed on campus, transforming their hosts into mindless zombies. \\nA blunt-force display of Dekker’s sensibilities, Night of the Creeps is an exuberant blend of zombie genre trappings and the sci-fi B-movies of yore; like Mars Attacks by way of Night of the Living Dead. Dekker lines his film with loving references to the genre, most obviously with his characters, who he names after the horror greats: Romero, Raimi, Carpenter, Cronenberg, Cameron, Landis, and Hooper. Night of the Creeps feels like Dekker took all his favorite movies and stirred them together in a silly, slimy stew. It can be clunky and goofy, but Night of the Creeps wears its idol worship like a badge of honor and Dekker’s creative flourish is a firewall that keeps his homage from becoming derivative. — Haleigh Foutch")
                .build());

        moviesAL.add(new Movie.Builder()
                .title("ParaNorman")
                .year("2012")
                .director("Chris Butler, Sam Fell")
                .image("http://collider.com/wp-content/uploads/paranorman-movie-image.jpg")
                .synopsis("Rarely do zombies get the animated treatment (rarer still, stop-motion animation), and even if they do, they’re traditionally made the villains. LAIKA is anything but traditional, which makes their films so endearing, unique, and memorable. ParaNorman, one of the stop-motion studio’s handful of original films, manages to not only (re)animate some truly gruesome and decaying corpses, but to give them a voice and agency within the story. Most live-action movies can’t even achieve that much. \\nBut what truly makes ParaNorman a great zombie tale is that the zombies themselves are more than just part of the spooky story (along with witches, ghosts, and dark magic), they’re a similar stand-in for societal problems first addressed by Romero’s original undead flick. Without giving away too many spoilers, the zombies themselves are reanimated townsfolk from colonial times who have realized the error of their ways but are prevented from setting things right thanks to a witch’s curse. Because they can’t communicate, they’re set upon by an angry mob. While you’d expect that turn of events in a traditional monster movie, the twist in ParaNorman is what lends some substance to its overall message. As a bonus, it’s a zombie movie you can watch with the kids! – Dave Trumbore")
                .build());

        moviesAL.add(new Movie.Builder()
                .title("Zombieland")
                .year("2009")
                .director("Ruben Fleischer")
                .image("http://collider.com/wp-content/uploads/Zombieland-movie-image-Woody-Harrelson-Jesse-Eisenberg-1.jpg")
                .synopsis("One of the greatest enjoyments of horror cinema in the last few decades has been watching filmmakers who grew up knowing the rules of the genre find new and exciting ways to subvert them. Shaun of the Dead is the gold star of self-referential cinematic love letters, but Ruben Fleischer’s Zombieland is a rollicking comedy horror in its own right.\\nZombieland arrived in theaters in 2009, towards the end of a new zombie boom, and it’s a film made for audiences who already know the rules and want to have some fun playing the game. The script comes from Deadpool screenwriters Reese and Wernick, and both properties share the duo’s knack for genre deconstruction and razor-sharp, smart-mouthed humor. The ensemble comedic performers has a blast doling out verbal beatdowns in between actually beating down the undead. And let’s be honest — even if Zombieland wasn’t an all-around fun and entertaining action horror, it deserves a spot on the list for giving BIll Murray the most Bill Murray cameo of all time. — Haleigh Foutch")
                .build());

        Movie[] movies = new Movie[moviesAL.size()];
        movies = moviesAL.toArray(movies);
        return movies;
    }
}
