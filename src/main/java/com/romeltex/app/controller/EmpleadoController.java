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


import com.romeltex.app.models.entity.Empleado;
import com.romeltex.app.service.IEmpleadoService;
import com.romeltex.app.util.PageRender;

@Controller
@SessionAttributes("empleado")
@RequestMapping("/empleados/")
public class EmpleadoController {

		@Autowired
		private IEmpleadoService empleadoService;
		
		@GetMapping(value="/listarEmpleados")
		public String listar(@RequestParam (name="page", defaultValue="0")
		int page, Model model)
		{
		Pageable pageRequest = PageRequest.of(page, 8);
		Page< Empleado> empleados = empleadoService.findAll(pageRequest);
		PageRender< Empleado> pageRender = new PageRender<Empleado>("/empleados/listarEmpleados/", empleados);
		
		model.addAttribute("title","lista de empleados");
		model.addAttribute("empleados", empleados);
		model.addAttribute("page", pageRender);
		 
		return "empleado/listarEmpleado";
		}
		@GetMapping(value="/nuevoEmpleado")//enlace
		public String nuevoEmpleado(Model model) {
			
			Empleado empleado=new Empleado();
			model.addAttribute("empleado", empleado);
			model.addAttribute("tipoempleados",empleadoService.tiposempleados());
			model.addAttribute("title", "Nuevo Empleado");
					
			return "empleado/formEmpleado";
		}
		@PostMapping(value = "/saveEmpleado")
		public String saveEmpleado(@Valid Empleado empleado, BindingResult result, Model model, RedirectAttributes flash) {//SessionStatus status) {

			if(result.hasErrors()) {
				model.addAttribute("title", "Guardar Empleado");
				model.addAttribute("tipoempleados",empleadoService.tiposempleados());
				return "empleado/formEmpleado";
			}
			String mensajeFlash=(empleado.getIdempleado()!=null)?"Empleado editado exitosamente!": "Empleado creado exitosamente";
			empleadoService.save(empleado);
			//status.setComplete();
			flash.addFlashAttribute("success",mensajeFlash );
			return "redirect:/empleados/listarEmpleados";//enlace no es nombre de la vista
		}
	
		@GetMapping(value = "/editEmpleado/{idempleado}")
		public String editEmpleado(@PathVariable(value = "idempleado") Long id, Model model, RedirectAttributes flash) {

			Empleado empleado = null;

			if (id > 0) {
				empleado = empleadoService.findById(id);
				if (empleado == null) {
					flash.addFlashAttribute("error", "The customer ID does not exist in the database!");
					return "redirect:/empleados/listarEmpleados";
				}
			} else {
				flash.addFlashAttribute("error", "The customer ID can not be zero!");
				return "redirect:/empleados/";
			}
			model.addAttribute("empleado", empleado);
			model.addAttribute("tipoempleados",empleadoService.tiposempleados());
			model.addAttribute("title", "Edit Empleado");
			return "empleado/formEmpleado";
		}

		@GetMapping(value = "/deleteEmpleado/{idempleado}")
		public String deleteEmpleado(@PathVariable(value = "idempleado") Long id, RedirectAttributes flash) {

			if (id > 0) {

				empleadoService.delete(id);
				flash.addFlashAttribute("success", "Empleado removed successfully!");
			}
			return "redirect:/empleados/listarEmpleados";
		}
		
}
