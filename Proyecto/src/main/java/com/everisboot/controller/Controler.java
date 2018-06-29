package com.everisboot.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.everisboot.exception.ExceptionApp;
import com.everisboot.models.Cuenta;
import com.everisboot.models.Movimiento;
import com.everisboot.models.Usuario;
import com.everisboot.models.UsuarioLogin;
import com.everisboot.services.GestCuentas;
import com.everisboot.services.GestMovimientos;
import com.everisboot.services.GestUsuario;
import com.everisboot.services.GestUsuarioLogin;


@Controller
public class Controler {
	//private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private GestCuentas cuentaService;
	@Autowired
	private GestUsuarioLogin loginService;
	@Autowired
	private GestMovimientos movimientosService;
	@Autowired
	private GestUsuario usuarioService;
	
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {		
		Iterable<Cuenta> listCuentas = cuentaService.listCuentas();
		Iterable<Movimiento> listMovimientos = movimientosService.listMovimiento();
		Iterable<UsuarioLogin> listUsuarioLogin= loginService.listLogin();		
		Iterable<Usuario> listUsuario= usuarioService.listUsuario();	
		
		ModelAndView model = new ModelAndView("index");
		
		model.addObject("cuenta", new Cuenta());
		model.addObject("movimiento", new Movimiento());
		model.addObject("usuariologin",new UsuarioLogin());
		model.addObject("usuario",new Usuario());
		
		model.addObject("cuentasList", listCuentas);
		model.addObject("movimientosList", listMovimientos);
		model.addObject("usuarioLoginList", listUsuarioLogin);
		model.addObject("usuarioList", listUsuario);
		return model;
	}	
	
	@RequestMapping(value = "/listado")
	public ModelAndView listado(HttpServletRequest request) {			
		Iterable<Cuenta> listCuentas = cuentaService.listCuentas();		
		ModelAndView model = new ModelAndView("movimientos");
		model.addObject("cuentasList", listCuentas);
		return model;
	}
	
//	@RequestMapping(value= "/login" , method = RequestMethod.POST)
//	public ModelAndView login(HttpServletRequest request) {
//		String user=request.getParameter("inputEmail");
//		UsuarioLogin usuarioLogin = null;
//		try {
//			usuarioLogin = loginService.login(user);
//		} catch (ExceptionApp e) {
//			ModelAndView model=new ModelAndView("index");
//			model.addObject("descripcion", e.getMsg());
//			model.addObject("titulo", e.getTitulo());
//			return model;
//		}
//		Usuario usuario = new Usuario();
//		usuario=usuarioService.getUsuario(usuarioLogin.getIdUser());		
//		ModelAndView model = new ModelAndView("principal");
//		model.addObject("usuario", usuario);
//		return model;
//	}
	
	@RequestMapping(value = "/listadodecuenta", method = RequestMethod.GET)
	public ModelAndView listadodecuenta(HttpServletRequest request) {		
		Integer usuarioId = Integer.parseInt(request.getParameter("idUsuario"));
		//Integer usuarioId = 1;
		List<Cuenta> cuenta = cuentaService.getCuentaByUser(usuarioId);		
		ModelAndView model = new ModelAndView("cuentas");
		model.addObject("cuentasUsuario", cuenta);
		return model;
	}
	
	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public ModelAndView registro(HttpServletRequest request) {		
		UsuarioLogin usuarioLogin=new UsuarioLogin();
		Usuario usuario=new Usuario();
		usuario.setId(0);
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setApellido(request.getParameter("apellido"));
		usuario.setDni(request.getParameter("dni"));	
		usuarioService.saveUsuario(usuario);
		usuarioLogin.setId(0);
		usuarioLogin.setIdUser(usuario.getId());
		usuarioLogin.setUser(request.getParameter("usuario"));
		usuarioLogin.setPass(request.getParameter("pass"));
		usuarioLogin.setUltimoAcceso(LocalDateTime.now());
		loginService.saveLogin(usuarioLogin);
		ModelAndView model= new ModelAndView("index");
		return model;
		
		
	}
	
	@RequestMapping(value = "/iraregistro")
	public ModelAndView iraregistro() {		
		ModelAndView model= new ModelAndView("registro");
		return model;
	}	

}
