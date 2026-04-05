package escenariosLista.escenario3;

public class Main {

    public static void main(String[] args) {

    CirculeSinglyList<Song> playlist = new CirculeSinglyList<>();

    playlist.addHome(new Song("Blinding Lights", "The Weeknd"));
    playlist.addHome(new Song("Shape of You", "Ed Sheeran"));
    playlist.addHome(new Song("Levitating", "Dua Lipa"));
    playlist.addHome(new Song("As It Was", "Harry Styles"));

    System.out.println("Initial playlist:");
    playlist.showList();

    System.out.println("\nPlaying songs:");
    System.out.println("Now playing: " + playlist.nextSong());
    System.out.println("Now playing: " + playlist.nextSong());
    System.out.println("Now playing: " + playlist.nextSong());
    System.out.println("Now playing: " + playlist.nextSong());
    System.out.println("Now playing: " + playlist.nextSong());

    System.out.println("\nRemoving song: Shape of You - Ed Sheeran");
    playlist.remove(new Song("Shape of You", "Ed Sheeran"));

    System.out.println("\nPlaylist after removal:");
    playlist.showList();

    System.out.println("\nPlaying again:");
    System.out.println("Now playing: " + playlist.nextSong());
    System.out.println("Now playing: " + playlist.nextSong());
}
}