import org.json.JSONObject ;
import org.restlet.resource.*;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.data.* ;

public class Client {
  
  private String URL = "http://localhost:8080/GameServer/game" ;
  ClientResource client ; 

  public Client() {
    client = new ClientResource( URL ); 
  }

  public void getUsername(String input) {
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