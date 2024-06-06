package org.mywire.temiroapp.ui.main;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class EnviarDatosFormularioTask extends AsyncTask<Void, Void, Boolean> {

    private static final String SHEET_BEST_URL = "https://sheet.best/api/sheets/1195b89a-9ffc-4d0d-92f6-b3eed3258f4e";
    private static final String API_KEY = "HnC9#yvUN-nV_xDM3gu#UqwJQktaSo1bK6MamVMGiNu_3sHptM@dIx1DAzXI06t5";

    private Context context;
    private String apellido;
    private String nombre;
    private String email;
    private String telefono;
    private String asunto;
    private String consulta;

    public EnviarDatosFormularioTask(Context context, String apellido, String nombre, String email, String telefono, String asunto, String consulta) {
        this.context = context;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.asunto = asunto;
        this.consulta = consulta;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            String postData = "{"
                    + "\"apellido\": \"" + apellido + "\","
                    + "\"nombre\": \"" + nombre + "\","
                    + "\"email\": \"" + email + "\","
                    + "\"telefono\": \"" + telefono + "\","
                    + "\"asunto\": \"" + asunto + "\","
                    + "\"consulta\": \"" + consulta + "\""
                    + "}";

            URL url = new URL(SHEET_BEST_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("x-api-key", API_KEY);
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            byte[] input = postData.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return true;
            } else {
                Log.e("EnviarDatosFormulario", "Error en la respuesta del servidor. Código: " + responseCode);
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean success) {
        if (success) {
            Toast.makeText(context, "Datos enviados exitosamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Error al enviar los datos", Toast.LENGTH_SHORT).show();
        }
    }
}
