package com.romeltex.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.romeltex.app.models.entity.Sucursal;
import com.romeltex.app.service.ISucursalService;
import com.romeltex.app.util.PageRender;

@Controller
@SessionAttributes("sucursal")
@RequestMapping("/sucursal/")
public class SucursalController {

	
	@Autowired
	private ISucursalService sucursalService;
	
	@GetMapping(value="/lista")
	public String listarSucursal (@RequestParam (name="page",defaultValue="0")
	int pagina, Model model)
	{
		Pageable pageRequest = PageRequest.of(pagina, 5);	
		 Page<Sucursal> sucursales= sucursalService.findAll(pageRequest);
		 PageRender<Sucursal> pageRender = new PageRender<Sucursal>("/sucursal/lista/", sucursales);
		 
		 model.addAttribute("title", "Lista de Sucursales");

			model.addAttribute("sucursales", sucursales);
			model.addAttribute("page", pageRender);
		
		return "sucursal/lista";
	}
	
	@GetMapping(value="/new")
	 public String nuevoSucursal (Model model)
	 {
	Sucursal sucursal= new Sucursal();
	model.addAttribute("sucursal",sucursal);
	model.addAttribute("title","nuevo sucursal");
	return "sucursal/formsucursal";
	 }
	
@PostMapping(value="/save")
public String saveSucursal(@Valid Sucursal sucursal, BindingResult result, 
		Model model, RedirectAttributes flash,SessionStatus status)
{
	if (result.hasErrors()) {
		model.addAttribute("title","Guardar Sucursal");
		return "sucursal/formsucursal";
	}
	String mensajeFlash = (sucursal.getIdsucursal()!= null) ? "Successfully edited Sucursal!"
			: "Sucursal created successfully!";

	sucursalService.save(sucursal);
	status.setComplete();
	flash.addFlashAttribute("success", mensajeFlash);
	return "redirect:/sucursal/lista";
}
	
@GetMapping(value = "/edit/{idsucursal}")
public String editarSucursal(@PathVariable(value = "idsucursal") Long id, Model model, RedirectAttributes flash) {

	Sucursal sucursal= null;

	if (id > 0) {
		sucursal = sucursalService.findById(id);
		if (sucursal== null) {
			flash.addFlashAttribute("error", "El sucursal id no existe en la database!");
			return "redirect:/sucursal/lista";
		}
	} else {
		flash.addFlashAttribute("error", "The sucursal ID can not be zero!");
		return "redirect:/sucursal/";
	}
	model.addAttribute("sucursal", sucursal);
	model.addAttribute("title", "editar sucursal");
	return "sucursal/formsucursal";
}


@GetMapping(value = "/delete/{idsucursal}")
public String eliminarSucursal(@PathVariable(value = "idsucursal") Long id, RedirectAttributes flash) {

	if (id > 0) {

		sucursalService.delete(id);
		flash.addFlashAttribute("success", "Sucursal se removio exitosamente!");
	}
	return "redirect:/sucursal/lista";
}


	
	
}
