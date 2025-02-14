/**
 * 
 */
package nl.jemaja.weekmenu.controller.api;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import nl.jemaja.weekmenu.config.DataSetup;
import nl.jemaja.weekmenu.model.Complexity;
import nl.jemaja.weekmenu.model.Recipe;
import nl.jemaja.weekmenu.model.RecipeList;
import nl.jemaja.weekmenu.repository.RecipeRepository;
import nl.jemaja.weekmenu.service.DayRecipeService;
import nl.jemaja.weekmenu.service.PlannerService;
import nl.jemaja.weekmenu.service.RecipeService;

/**
 * @author yannick.tollenaere
 *
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/")
public class RecipeRestControllerV1 {
	
	@Autowired
	RecipeService recipeService;
	
	@Autowired
	RecipeRepository recipeRepository;
	
	@Autowired
	DayRecipeService dRService;
	


	
	@GetMapping(path = "/blaat", produces = MediaType.APPLICATION_JSON_VALUE) 
	public List<Recipe> getRecipes() {
		return recipeRepository.findAll();
	}
	
	@GetMapping(path = "/init", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity init() {
		ResponseEntity response = new ResponseEntity(HttpStatus.OK);
		
		try {
			//DataSetup.days(dRService);
			DataSetup.recipes(recipeService);
		} catch (Exception e) {
			response.status(HttpStatus.INTERNAL_SERVER_ERROR);
			log.error(e.getStackTrace().toString());
		}
		
		
		return response;
		
	}
	


}
