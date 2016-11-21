package api;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class GetUsersService extends ServerResource {

	@Get
	public Representation get() throws JSONException {

		JSONObject json = new JSONObject();
		return new JsonRepresentation(json);
	}

}
