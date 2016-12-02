package api;

import org.restlet.*;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class GameServer extends Application {

	public static void main(String[] args) throws Exception {
		Component server = new Component();
		server.getServers().add(Protocol.HTTP, 8081);
		server.getDefaultHost().attach(new GameServer());
		server.start();
	}

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		router.attach("/register", RegisterUserService.class);
		router.attach("/scoreboard", ScoreboardService.class);
		return router;
	}
}