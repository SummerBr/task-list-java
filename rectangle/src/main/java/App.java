//import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
//import java.util.Random;

public class App {
	public static void main(String[] args) {
		staticFileLocation("/public");
		String layout = "templates/layout.vtl";

		get("/", (request, response) -> {
			HashMap<String, Object> model = new HashMap<String, Object>();

			model.put("template", "templates/home.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());

		get("/rectangle", (request, response) -> {
			HashMap<String, Object> model = new HashMap<String, Object>();
			int length = Integer.parseInt(request.queryParams("length"));
			int width = Integer.parseInt(request.queryParams("width"));

			Rectangle myRectangle = new Rectangle(length, width);
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
	}
}
