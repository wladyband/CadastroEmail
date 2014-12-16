package com.exemplo.cadastro.email.repositorio;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.exemplo.cadastro.email.model.Usuario;
import com.exemplo.cadastro.email.model.Usuario.Usuarios;

public class RepositorioUsuario {
	
	

	private static final String CATEGORIA = "LoginCategoria";

	// Nome do banco
	private static final String NOME_BANCO = "ProjetoFinanceiro";
	// Nome da tabela
	public static final String NOME_TABELA = "Usuario";

	protected SQLiteDatabase db;
	
	List<Usuario> usuarios = new ArrayList<Usuario>();

	public RepositorioUsuario(Context ctx) {
		// Abre o banco de dados j� existente
	}

	public RepositorioUsuario(){
		
	}
	public long salvar(Usuario usuario) {
	  ContentValues values = new ContentValues();
	  values.put(Usuarios.SENHA, usuario.senha);
	  long id = salvar(values);
	  return id;
	}
	
	
	public long salvar(ContentValues valores){
		long id = db.insert(NOME_TABELA, "", valores);
		return id;
	}
	
	
	
	

	public void fechar() {
		// fecha o banco de dados
		if (db != null) {
			db.close();
		}
	}


}
