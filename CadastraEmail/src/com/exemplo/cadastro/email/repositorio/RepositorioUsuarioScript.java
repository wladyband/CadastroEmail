package com.exemplo.cadastro.email.repositorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class RepositorioUsuarioScript extends RepositorioUsuario {
	
private static final String SCRIPT_DATABASE_DELETE = "DROP TABLE IF EXISTS Usuario";
	
	private static final String [] SCRIPT_DATABASE_CREATE = new String[]{
		"create table Usuario ( _id integer primary key autoincrement, senha text not null);",
	/*"insert into Usuario(senha) values('wladimir');"	*/ };
	
	private static final String NOME_BANCO = "ProjetoFinanceiro";
	
	private static final int VERSAO_BANCO = 2;
	
	public static final String TABELA_LOGIN = "Usuario";
	
	private SQLiteHelper dbHelper;

	// Cria o banco de dados com um script SQL
	public RepositorioUsuarioScript(Context ctx) {
		super(ctx);
		// Criar utilizando um script SQL
		dbHelper = new SQLiteHelper(ctx, RepositorioUsuarioScript.NOME_BANCO, RepositorioUsuarioScript.VERSAO_BANCO,
				RepositorioUsuarioScript.SCRIPT_DATABASE_CREATE, RepositorioUsuarioScript.SCRIPT_DATABASE_DELETE);

		// abre o banco no modo escrita para poder alterar também
		db = dbHelper.getWritableDatabase();
	}
	
	// Fecha o banco
		@Override
		public void fechar() {
			super.fechar();
			if (dbHelper != null) {
				dbHelper.close();
			}
		}

    public SQLiteDatabase getDb(){
        return db;
    }


}
