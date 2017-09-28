package com.example.yonny.servicedesk;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

        import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        user = (EditText) findViewById(R.id.idUser);
        pass = (EditText) findViewById(R.id.idPassword);

    }

    public void ingresar(View view) {
        String usuario = user.getText().toString();
        String clave = pass.getText().toString();


        UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();
        final List<Usuario> usuarios = usuarioRepository.getUsuarios();

        for (Usuario usuario1 : usuarios) {

            if(usuario1.getUsername().equals(usuario) & usuario1.getPassword().equals(clave)){
                 Intent i = new Intent(this, MainActivity.class);
                 i.putExtra("user",usuario1.getUsername());
                 i.putExtra("nombre",usuario1.getNombre());
                 i.putExtra("rol",usuario1.getRol());

                 startActivity(i);
                 Toast.makeText(this, "Bienvenido : " +usuario, Toast.LENGTH_SHORT).show();
            }

        }


    }
}
