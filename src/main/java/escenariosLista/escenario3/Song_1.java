package escenariosLista.escenario3;

public class Song_1 {

    private String title;
    private String artist;

    public Song_1(String title, String artist){
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

        Song_1 other = (Song_1) obj;
        return title.equals(other.title) && artist.equals(other.artist);
    }
}