package org.mywire.temiroapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.mywire.temiroapp.R;
import org.mywire.temiroapp.ui.user.LoginActivity;
import org.mywire.temiroapp.ui.main.EnviarDatosFormularioTask;

public class ContactoUno extends AppCompatActivity {

    EditText editTextApellido;
    EditText editTextNombre;
    EditText editTextEmail;
    EditText editTextTelefono;
    EditText editTextAsunto;
    EditText editTextConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_contacto_uno);

        editTextApellido = findViewById(R.id.editTextApellido);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextAsunto = findViewById(R.id.editTextAsunto);
        editTextConsulta = findViewById(R.id.editTextConsulta);
    }

    public void enviarConsulta(View view) {
        String apellido = editTextApellido.getText().toString();
        String nombre = editTextNombre.getText().toString();
        String email = editTextEmail.getText().toString();
        String telefono = editTextTelefono.getText().toString();
        String asunto = editTextAsunto.getText().toString();
        String consulta = editTextConsulta.getText().toString();

        boolean validar = !apellido.isEmpty() && !nombre.isEmpty() && !email.isEmpty() && !telefono.isEmpty() && !asunto.isEmpty() && !consulta.isEmpty();
        if (validar) {
            EnviarDatosFormularioTask task = new EnviarDatosFormularioTask(this, apellido, nombre, email, telefono, asunto, consulta);
            task.execute();
            finish();
        } else {
            Toast.makeText(ContactoUno.this, "Debe completar todos los campos !", Toast.LENGTH_LONG).show();
        }
    }
}