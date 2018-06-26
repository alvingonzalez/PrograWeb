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

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.romeltex.app.models.entity.Cliente;
import com.romeltex.app.service.IClienteService;
import com.romeltex.app.util.PageRender;

@Controller
//@SessionAttributes("Cliente")
@SessionAttributes({"cliente"})
@RequestMapping("/clientes/")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteservice;
	
	@GetMapping(value="/listar")
	public String listarCliente(@RequestParam(name = "page", defaultValue = "0") int page,Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 8);
		Page<Cliente> clientes = clienteservice.findAll(pageRequest);
		PageRender<Cliente> pageRender = new PageRender<Cliente>("/clientes/listar/", clientes);
		
		model.addAttribute("title","Lista de Clientes");
		model.addAttribute("clientes",clientes);
		model.addAttribute("page", pageRender);
		return "cliente/listar";//vista, lugar en la  carpeta
	}
	@GetMapping(value="/nuevo")//enlace
	public String nuevoCliente(Model model) {
		
		Cliente cliente=new Cliente();
		model.addAttribute("cliente", cliente);
		model.addAttribute("title", "Nuevo Cliente");
				
		return "cliente/form";
	}
	@PostMapping(value = "/save")
	public String saveCliente(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash) {//SessionStatus status) {

		if(result.hasErrors()) {
			model.addAttribute("title", "Guardar Cliente");
			return "cliente/form";
		}
		
		String mensajeFlash=(cliente.getIdcliente()!=null)?"Cliente editado exitosamente!": "Cliente creado exitosamente";
		clienteservice.save(cliente);
		//status.setComplete();
		flash.addFlashAttribute("success",mensajeFlash );
		return "redirect:/clientes/listar";//enlace no es nombre de la vista
	}
	@GetMapping(value = "/edit/{idcliente}")
	public String editCliente(@PathVariable(value = "idcliente") Long id, Model model, RedirectAttributes flash) {

		Cliente cliente = null;

		if (id > 0) {
			cliente = clienteservice.findById(id);
			if (cliente == null) {
				flash.addFlashAttribute("error", "El Id del cliente no existe en la base de datos!");
				return "redirect:/clientes/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El Id del cliente no puede ser cero!");
			return "redirect:/clientes/";
		}
		model.addAttribute("cliente", cliente);
		model.addAttribute("title", "Editar cliente");
		return "cliente/form";
	}
	@GetMapping(value = "/delete/{idcliente}")
	public String deleteCliente(@PathVariable(value = "idcliente") Long id, RedirectAttributes flash) {

		if (id > 0) {

			clienteservice.delete(id);
			flash.addFlashAttribute("success", "Customer removed successfully!");
		}
		return "redirect:/clientes/listar";
	}

}
