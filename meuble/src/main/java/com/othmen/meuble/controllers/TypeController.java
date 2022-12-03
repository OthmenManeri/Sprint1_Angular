package com.othmen.meuble.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.othmen.meuble.entities.Type;
import com.othmen.meuble.service.TypeService;
import com.othmen.meuble.service.MeubleService;
@Controller
public class TypeController {
	
	@Autowired
	MeubleService meubleService;
	@Autowired
	TypeService typeService;
	
	
	@RequestMapping("/showCreateType")
	public String showCreateType(ModelMap modelMap)
	{
	modelMap.addAttribute("types", new Type());
	modelMap.addAttribute("mode", "new");
	return "formType";
	}
	@RequestMapping("/saveType")
	public String saveType(@ModelAttribute("type") Type type,ModelMap modelMap) throws ParseException 
	{
	Type saveType = typeService.saveType(type);
	return "redirect:/ListeType";
	}

	@RequestMapping("/ListeType")
	public String listeType(ModelMap modelMap ,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size)
	{
		Page<Type> types = typeService.getAllTypeParPage(page, size);
		
		
		modelMap.addAttribute("types", types);
		modelMap.addAttribute("pages", new int[types.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeType";
	}
	@RequestMapping("/modifierType")
	public String editerType(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Type c= typeService.getType(id);
	modelMap.addAttribute("types", c);
	modelMap.addAttribute("mode", "edit");
	return "formType";
	}
	@RequestMapping("/updateType")
	public String updateType(@ModelAttribute("type") Type type,ModelMap modelMap) throws ParseException {
		typeService.updateType(type);
		 List<Type> types = typeService.findAll();
		 modelMap.addAttribute("types", types);
		return "ListeType";
		}
	@RequestMapping("/supprimerType")
	public String supprimerType(@RequestParam("id") Long id,
	 ModelMap modelMap)
	{ 
	typeService.deleteTypeById(id);
	List<Type> types = typeService.findAll();
	modelMap.addAttribute("types", types);
	return "ListeType";
	}
	

}
