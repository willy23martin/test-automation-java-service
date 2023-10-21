package com.test.automation.project.testautomationjavaservicebackend.api.model.datastructure;

import java.util.ArrayList;


public class ArbolBinario<T> {

	private NodoArbol<T> raiz;
	
	public ArbolBinario(){
		raiz=null;
	}

	public NodoArbol<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoArbol<T> raiz) {
		this.raiz = raiz;
	}
	
	//---------------METODOS DEL ARBOL BINARIO-------//
	
	public boolean estaVacio(){
		return (raiz==null);
	}
	
	public void agregarElemento(T elemento){
		if(estaVacio()){
			raiz=new NodoArbol<T>(elemento);
		}else{
			raiz.agregarElemento(elemento);
		}
	}
	
	public T buscarElemento(T elemento) {
		if(estaVacio()){
			return null;
		}else{
			return raiz.buscarNodo(elemento).getElemento();
		}
	}
	
	public void eliminarElemento(T elemento) throws Exception{
		if(estaVacio()){
			throw new Exception("El arbol esta vacio");
		}else{
			raiz=raiz.eliminarElemento(elemento); 
		}
	}
	
	public ArrayList<T> recorrerInorden(){
		ArrayList<T> inorden=new ArrayList<T>();
		return raiz.recorrerInorden(inorden);
	}
	
	public ArrayList<T> recorrerPreorden(){
		ArrayList<T> preorden=new ArrayList<T>();
		return raiz.recorrerPreorden(preorden);
	}
	
	public ArrayList<T> recorrerPostorden(){
		ArrayList<T> postorden=new ArrayList<T>();
		return raiz.recorrerPostorden(postorden);
	}
	
	public int peso(){
		if(estaVacio()){
			return 0;
		}else{
			return raiz.peso();
		}
	}
	
	public int altura(){
		if(estaVacio()){
			return 0;
		}else{
			return raiz.altura();
		}
	}
	
	public boolean existeElemento(T elemento){
		if(estaVacio()){
			return false;
		}else{
			if(buscarElemento(elemento)!=null){ 
				return true;
			}else{
				return false;
			}
		}
	}
	
}
