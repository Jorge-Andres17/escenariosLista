package escenariosLista.escenario3;

public class Song {

    private String title;
    private String artist;

    public Song(String title, String artist){
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString(){
        return title + " - " + artist;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Song other = (Song) obj;
        return title.equals(other.title) && artist.equals(other.artist);
    }
}