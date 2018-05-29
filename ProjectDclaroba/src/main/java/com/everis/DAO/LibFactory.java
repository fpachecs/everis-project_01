package com.everis.DAO;


public class LibFactory {
	
	public static UsuarioLoginDaoImp getUsuarioLoginDaoImp() {
		return new UsuarioLoginDaoImp();
	}
	public static MovimientosDaoImp getMovimientosDaoImp() {
		return new MovimientosDaoImp();
	}
	public static CuentasDaoImp getCuentasDaoImp() {
		return new CuentasDaoImp();
	}
	public static UsuarioDaoImp getUsuarioDaoImp() {
		return new UsuarioDaoImp();
	}
}
