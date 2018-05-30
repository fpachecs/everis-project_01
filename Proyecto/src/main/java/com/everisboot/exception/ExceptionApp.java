package com.everisboot.exception;

@SuppressWarnings("serial")
public class ExceptionApp extends Exception {
	private String titulo;
	private String msg;
	public ExceptionApp(String msg) {
		this.msg=msg;
	}
	public ExceptionApp(String titulo, String msg) {
		this.setTitulo(titulo);
		this.msg=msg;
	}	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
