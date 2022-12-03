package com.othmen.meuble.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.othmen.meuble.entities.Type;
import com.othmen.meuble.entities.meuble;
import com.othmen.meuble.service.TypeService;
import com.othmen.meuble.service.MeubleService;
@Controller
public class MeubleController {
@Autowired
MeubleService meubleService;
@Autowired
TypeService typeService;
@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
List<Type> types = typeService.findAll();
modelMap.addAttribute("types", types);
modelMap.addAttribute("meuble", new meuble());
modelMap.addAttribute("mode", "new");
return "formMeuble";
}
@RequestMapping("/saveMeuble")
public String saveMeuble(ModelMap modelMap,@Valid meuble meuble,
BindingResult bindingResult)
{
	List<Type> types = typeService.findAll();
	modelMap.addAttribute("types", types);
System.out.println(meuble);
if (bindingResult.hasErrors()) return "formMeuble";
meubleService.saveMeuble(meuble);
return "redirect:/ListeMeubles";
}



@RequestMapping("/ListeMeubles")
public String listeMeubles(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
	List<Type> types = typeService.findAll();
	modelMap.addAttribute("types", types);
Page<meuble> prods = meubleService.getAllMeublesParPage(page, size);
modelMap.addAttribute("meubles", prods);
 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeMeubles";
}


@RequestMapping("/supprimerMeuble")
public String supprimerMeuble(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
meubleService.deleteMeubleById(id);
Page<meuble> prods = meubleService.getAllMeublesParPage(page, 
size);
modelMap.addAttribute("meubles", prods);
modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeMeubles";
}


@RequestMapping("/modifierMeuble")
public String editerMeuble(@RequestParam("id") Long id,ModelMap modelMap)
{
meuble p= meubleService.getMeuble(id);
List<Type> types = typeService.findAll();
types.remove(p.getType());
modelMap.addAttribute("types", types);
modelMap.addAttribute("meuble", p);
modelMap.addAttribute("mode", "edit");
return "formMeuble";
}
@RequestMapping("/updateMeuble")
public String updateMeuble(@ModelAttribute("meuble") meuble meuble,
@RequestParam ModelMap modelMap) throws ParseException {
	
	 meubleService.updateMeuble(meuble);
	 List<meuble> prods = meubleService.getAllMeubles();
	 modelMap.addAttribute("meubles", prods);
	return "listeMeubles";
	}



@RequestMapping("/search")
public String recherNom(@RequestParam("nom") String nom,
ModelMap modelMap)
{
	List<Type> types = typeService.findAll();
	modelMap.addAttribute("types", types);
List<meuble> prods = meubleService.findByNomMeuble(nom);
modelMap.addAttribute("meubles",prods);
modelMap.addAttribute("mode", "SearchNomP");
return "listeMeubles";
}
@RequestMapping("/searchType")
public String recherType(@RequestParam("type") Long type,ModelMap modelMap)
{
Type types = new Type();
types.setIdType(type);
List<Type> types2 = typeService.findAll();
modelMap.addAttribute("types", types2);
List<meuble> prods = meubleService.findByType(types);
modelMap.addAttribute("meubles",prods);
modelMap.addAttribute("mode", "Searchtype");
return "listeMeubles";
}
}