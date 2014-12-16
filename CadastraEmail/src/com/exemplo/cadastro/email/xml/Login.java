package com.exemplo.cadastro.email.xml;

import com.exemplo.cadastro.email.model.Usuario;
import com.exemplo.cadastro.email.repositorio.RepositorioUsuario;
import com.exemplo.cadastro.email.repositorio.RepositorioUsuarioScript;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cadastraemail.R;

public class Login extends Activity {
	
	
	private Button entrar;
	private EditText senhaEmail;
	private Button cadastrarEmail;
	
	Usuario usuario = new Usuario();
	RepositorioUsuario repositorio = new RepositorioUsuario(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form_login);
		
		final EditText senhaLogin = (EditText)findViewById(R.id.senhaLogin);
		Button entrar = (Button) findViewById(R.id.entrar);
		final EditText senhaEmail = (EditText)findViewById(R.id.editEmail);
		Button cadastrarEmail = (Button)findViewById(R.id.cadastrarEmail);
		
		entrar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				RepositorioUsuarioScript r = new RepositorioUsuarioScript(Login.this);
				Cursor cursor = r.getDb().rawQuery("select * from Usuario", null);
                if (cursor.getCount() > 0){
                    cursor.moveToFirst();
                    
                    
                    String senha = cursor.getString(cursor.getColumnIndex("senha"));
                    
                    usuario = new Usuario(senha);
                }
                String loginCerto  = usuario.getSenha();
                String StrSenha  =  senhaLogin.getText().toString();
                
                if(StrSenha.equals(loginCerto)){
                	startActivity(new Intent(Login.this, Resultado.class));
                	
					senhaLogin.setText("");
                }else{
                	senhaLogin.setText("");
                	Toast.makeText(Login.this, "Senha Incorreta", Toast.LENGTH_SHORT).show();
                }

				
			}
		});
		
		cadastrarEmail.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				usuario.setSenha(senhaEmail.getText().toString());
			repositorio.salvar(usuario);
			//	Toast.makeText(Login.this, senhaEmail.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		
		
	}


}
