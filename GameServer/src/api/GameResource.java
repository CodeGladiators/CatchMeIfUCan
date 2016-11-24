package api;

import org.json.*;
import org.restlet.representation.*;
import org.restlet.ext.json.*;
import org.restlet.resource.*;

public class GameResource extends ServerResource {

	@Get
	public Representation get() throws JSONException {

		JSONObject json = new JSONObject();

		return new JsonRepresentation(json);
	}

	@Post
	public Representation post(JsonRepresentation jsonRep) {

		JSONObject json = jsonRep.getJsonObject();
		String action = json.getString("action");
		System.out.println("action: " + action);

		if (action.equals("getUsername"))
			System.out.println(json.getString("username"));
		if (action.equals("getScore"))
			System.out.println("score");

		JSONObject response = new JSONObject();

		return new JsonRepresentation(response);
	}

}