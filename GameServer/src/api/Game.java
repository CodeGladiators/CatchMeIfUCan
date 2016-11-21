package api;

import java.util.ArrayList;
import java.util.Iterator;

public class Game implements ListIterator {

	public static Game singleInstance = null;

	private ArrayList<User> listOfUsers = new ArrayList<User>();

	public static Game getInstance() {

		synchronized (Game.class) {

			if (singleInstance == null) {
				singleInstance = new Game();
			}

		}

		return singleInstance;
	}

	public ArrayList<User> getUserList() {
		return listOfUsers;
	}

	@Override
	public Iterator getIterator() {
		return listOfUsers.iterator();
	}

}
