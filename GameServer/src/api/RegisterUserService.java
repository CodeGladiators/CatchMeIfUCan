package api;

import java.util.Iterator;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class RegisterUserService extends ServerResource {

	@Post
	public Representation post(JsonRepresentation jsonRep) {

		JSONObject request = jsonRep.getJsonObject();
		String username = request.getString("username");

		Iterator userListIterator = Game.getInstance().getIterator();

		JSONObject response = new JSONObject();

		// check if user already exists
		while (userListIterator.hasNext()) {
			User user = (User) userListIterator.next();

			if (user.getUsername().equals(username)) {
				response.put("statusCode", 401);
				return new JsonRepresentation(response);
			}
		}

		// otherwise register user
		Game.getInstance().addUser(new User(username));

		response.put("username", username);
		response.put("statusCode", 200);

		return new JsonRepresentation(response);
	}

}