import org.json.JSONObject ;
import org.restlet.resource.*;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.data.* ;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Client {

    ClientResource client ; 

    public Client(String url) {
        client = new ClientResource(url); 
    }

    public Boolean checkDuplicateUsername(String input) throws JsonParseException, JsonMappingException, IOException {
        JSONObject json_username = new JSONObject();
        json_username.put("username", input);

        Representation representation = client.post(new JsonRepresentation(json_username), MediaType.APPLICATION_JSON);
        String result=representation.getText();
        ObjectMapper mapper = new ObjectMapper();
        StatusCodes status = mapper.readValue(result.getBytes(), StatusCodes.class);
        if(status.statusCode== 200){
            return true;
        }
        else{
            return false;
        }
    }

    public void S(String input) {
        JSONObject json_username = new JSONObject();
        json_username.put("action", "getUsername");
        json_username.put("username", input);

        client.post(new JsonRepresentation(json_username), MediaType.APPLICATION_JSON);
    }

    public void getScore(int input) {
        JSONObject json_getScore = new JSONObject();
        json_getScore.put("action", "getScore");
        json_getScore.put("score", input);

        client.post(new JsonRepresentation(json_getScore), MediaType.APPLICATION_JSON);
    }

    public Score[] postScore() throws JsonParseException, JsonMappingException, IOException {

        Player player=Player.getInstance();
        JSONObject json_username = new JSONObject();
        json_username.put("username", player.getName());
        json_username.put("score", player.getScore());
        ClientResource client=new ClientResource(Constant.URL.scoreboard);
        Representation representation = client.post(new JsonRepresentation(json_username), MediaType.APPLICATION_JSON);
        String result=representation.getText();

        
        ObjectMapper mapper = new ObjectMapper();
        //Reset player
        player.reset();

        Score[] players = mapper.readValue(result.getBytes(), Score[].class);

        return players;
    }

    public String toString() {
        String result = "" ;
        Representation result_string = client.get() ; 
        try {
            JSONObject json = new JSONObject( result_string.getText() ) ;
            result = (String) json.get("banner") ;
        }
        catch (Exception e) {
            result = e.getMessage() ;
        }          
        return result ;
    }
}