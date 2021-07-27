import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Home {
	private static ArrayList<Album> albums = new ArrayList<>(); // for storing the Albums

	public static void main(String[] Hi) {
		Album album1 = new Album("Album1", "Coldplay");
		album1.addSong("Hymn For The Weekend", 4.41);
		album1.addSong("Something Just Like You", 4.2);
		album1.addSong("XYZ", 3.9);
		album1.addSong("PQR", 2.8);
		albums.add(album1);

		Album album2 = new Album("Album2", "James Blunt");
		album2.addSong("Bartender", 3.49);
		album2.addSong("Champion", 3.23);
		album2.addSong("The Truth", 4.4);
		albums.add(album2);

		LinkedList<Song> PlayList_1 = new LinkedList<>(); // for storing the PlayList
		albums.get(1).addToPlayList("Bartender", PlayList_1);
		albums.get(1).addToPlayList("Champion", PlayList_1);
		albums.get(0).addToPlayList("Something Just Like You", PlayList_1);
		albums.get(0).addToPlayList("Hymn For The Weekend", PlayList_1);
//		albums.get(0).addToPlayList("ABC", PlayList_1);

		
//		 System.out.println(PlayList_1.size());
//		  
//		 ListIterator<Song> ls = PlayList_1.listIterator(); 
//		 while (ls.hasNext()) {
//			 System.out.println(ls.next().title.toString()); 
//		 }
		 

		Play(PlayList_1);
	}

	private static void Play(LinkedList<Song> playlist) {
		MyScanner ms = new MyScanner();
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> ls = playlist.listIterator();

		if (playlist.size() == 0)
			System.out.println("This playlist contains no song");
		else {
			System.out.println("Now Playing " + ls.next().title.toString());
			printMenu();
		}

		while (!quit) {
			int action = ms.nextInt();
//			sc.nextLine();

			switch (action) {
			case 0:
				System.out.println("PlayList complete");
				quit = true;
				break;

			case 1:
				if (!forward) {
					if (ls.hasNext())
						ls.next();

					forward = true;
				}

				if (ls.hasNext())
					System.out.println("Now Playing " + ls.next().title.toString());
				else {
					System.out.println("Reached to the end of the PlayList");
					forward = false;
				}
				break;

			case 2:
				if (forward) {
					if (ls.hasPrevious())
						ls.previous();
					forward = false;
				}
				if (ls.hasPrevious())
					System.out.println("Now playing " + ls.previous().title.toString());
				else {
					System.out.println("This is the first song");
					forward = true;
				}

				break;

			case 3:
				if (forward) {
					if (ls.hasPrevious()) {
						System.out.println("Now playing " + ls.previous().title.toString());
						forward = false;
					} else {
						System.out.println("this is the first song");
					}
				} else {
					if (ls.hasNext()) {
						System.out.println("Now playing " + ls.next().title.toString());
						forward = true;
					} else {
						System.out.println("Reached to the end of the PlayList");
					}
				}

				break;

			case 4:
				printList(playlist);
				break;

			case 5:
				if (playlist.size() > 0) {
					ls.remove();
					if (ls.hasNext())
						System.out.println("Now playing " + ls.next().title.toString());
					else {
						if (ls.hasPrevious())
							System.out.println("Now playing " + ls.previous().title.toString());
					}
				}

				break;

			case 6:
				printMenu();
				break;
			}
		}
	}

	private static void printList(LinkedList<Song> playList) {
		Iterator<Song> it = playList.iterator();
		System.out.println("----------------------------------");

		while (it.hasNext())
			System.out.println(it.next().title);

		System.out.println("----------------------------------");
	}

	private static void printMenu() {
		System.out.println("Available options");
		System.out.println("0 - to quit\n" + "1 - to play next song\n" + "2 - to play previous song\n"
				+ "3 - to replay the current song\n" + "4 - List of all song\n" + "5 - delete current song\n"
				+ "6 - print all available options");
	}

	static class MyScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

	}
}
