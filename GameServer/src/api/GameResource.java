package api;

import org.json.* ;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.resource.* ;

public class GameResource extends ServerResource {


    @Get
    public Representation get() throws JSONException {

        //String banner = machine.toString() ;
        //int count = machine.getCount() ;
        //String state = machine.getStateString() ;

        JSONObject json = new JSONObject() ;
        //json.put( "banner", banner ) ;
        //json.put( "count", count ) ;
        //json.put( "state", state ) ;

        return new JsonRepresentation ( json ) ;
    }


    @Post
    public Representation post(JsonRepresentation jsonRep) {

        JSONObject json = jsonRep.getJsonObject() ;
        String action = json.getString("action") ;
        System.out.println( "action: " + action ) ;

        if ( action.equals( "getUsername") )
            System.out.println(json.getString("username"));
        if ( action.equals( "getScore") )
            System.out.println("score");

        JSONObject response = new JSONObject() ;
        //String state = machine.getStateString() ;
        //response.put( "result", state ) ;

        return new JsonRepresentation ( response ) ;

    }
}

