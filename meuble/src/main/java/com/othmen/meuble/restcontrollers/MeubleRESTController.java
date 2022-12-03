package com.othmen.meuble.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.othmen.meuble.entities.meuble;
import com.othmen.meuble.service.MeubleService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class MeubleRESTController {
@Autowired
MeubleService meubleService;
@RequestMapping(method = RequestMethod.GET)
public List<meuble> getAllMeubles() {
return meubleService.getAllMeubles();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public meuble getMeubleById(@PathVariable("id") Long id) {
return meubleService.getMeuble(id);
 }
@RequestMapping(method = RequestMethod.POST)
public meuble createMeuble(@RequestBody meuble meuble) {
return meubleService.saveMeuble(meuble);
}
@RequestMapping(method = RequestMethod.PUT)
public meuble updateMeuble(@RequestBody meuble meuble) {
return meubleService.updateMeuble(meuble);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteMeuble(@PathVariable("id") Long id)
{
meubleService.deleteMeubleById(id);
}
@RequestMapping(value="/prodscat/{idType}",method = RequestMethod.GET)
public List<meuble> getMeublesByTypeId(@PathVariable("idType") Long idType) {
return meubleService.findByTypeIdType(idType);
}
}
