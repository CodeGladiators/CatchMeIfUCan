package api;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class ScoreboardService extends ServerResource {

	@Post
	public Representation post(JsonRepresentation jsonRep) {

		// handle request
		JSONObject request = jsonRep.getJsonObject();

		String username = request.getString("username");
		long userscore = request.getLong("score");
		
		System.out.println(username);
		System.out.println(userscore);
		
		Iterator userListIterator = Game.getInstance().getIterator();
		while (userListIterator.hasNext()) {
			User user = (User) userListIterator.next();

			if (user.getUsername().equals(username)) {
				user.setScore(userscore);
				break;
			}
		}

		// prepare and send response
		JSONArray response = new JSONArray(Game.getInstance().getListOfUsers());
		return new JsonRepresentation(response);
	}

}