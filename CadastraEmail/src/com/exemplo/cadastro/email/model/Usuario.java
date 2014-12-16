package com.exemplo.cadastro.email.model;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class Usuario {
	

	
	public static String[] colunas = new String[]{Usuarios._ID, Usuarios.SENHA};
	
	public static final String AUTHORITY = "com.example.projetologin.model.usuario";
	
	public long id;
	public String senha;
	
	public Usuario(){
		
	}

	public Usuario(String senha){
		super();
		this.senha = senha;
		
	}
	
	public Usuario(long id, String senha ){
		super();
		this.id = id;
		this.senha = senha;
		
	}
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	



	public static final class Usuarios implements BaseColumns{
		public Usuarios(){
			
		}
		public static final Uri CONTENT_URI = Uri.parse("content://"
				+ AUTHORITY + "/usuarios");
		public static final String CONTENT_TYPE = "vnd.android.curso.dir/vnd.google.usuarios";
		public static final String CONTENT_ITEM_TYPE = "vnd.android.curso.item/vnd.google.usuarios";
		public static final String DEFAULT_SORT_ORDER = "_id_ASC";
		
		public static final String SENHA = "senha";

		public static Uri getUriId(long id) {
			Uri uriUsuario = ContentUris.withAppendedId(Usuarios.CONTENT_URI, id);
		return uriUsuario;
	}
		@Override
		public String toString() {
			return "Senha: " +  SENHA  ;
		}
	}
	

}
