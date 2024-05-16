package org.mywire.temiroapp.ui.product;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.mywire.temiroapp.MainActivity;
import org.mywire.temiroapp.R;

public class PaymentActivity extends AppCompatActivity {

    private EditText editTextCardNumber;
    private EditText editTextSecurityCode;
    private EditText editTextExpirationDate;
    private EditText editTextName;
    private EditText editTextAddress;
    private Button buttonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        editTextCardNumber = findViewById(R.id.editTextCardNumber);
        editTextSecurityCode = findViewById(R.id.editTextSecurityCode);
        editTextExpirationDate = findViewById(R.id.editTextExpirationDate);
        editTextName = findViewById(R.id.editTextName);
        editTextAddress = findViewById(R.id.editTextAddress);
        buttonConfirm = findViewById(R.id.buttonConfirm);


        editTextCardNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
        editTextCardNumber.setFilters(new InputFilter[] {new InputFilter.LengthFilter(19)});
        editTextCardNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String cardNumber = editTextCardNumber.getText().toString().replaceAll("\\s+", "");
                StringBuilder formattedCardNumber = new StringBuilder();

                for (int i = 0; i < cardNumber.length(); i++) {
                    if (i > 0 && i % 4 == 0) {
                        formattedCardNumber.append(" ");
                    }
                    formattedCardNumber.append(cardNumber.charAt(i));
                }

                editTextCardNumber.removeTextChangedListener(this);
                editTextCardNumber.setText(formattedCardNumber.toString());
                editTextCardNumber.setSelection(formattedCardNumber.length());
                editTextCardNumber.addTextChangedListener(this);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });


        editTextSecurityCode.setInputType(InputType.TYPE_CLASS_NUMBER);
        editTextSecurityCode.setFilters(new InputFilter[] {new InputFilter.LengthFilter(3)});


        editTextExpirationDate.setInputType(InputType.TYPE_CLASS_NUMBER);
        editTextExpirationDate.setFilters(new InputFilter[] {new InputFilter.LengthFilter(5)});
        editTextExpirationDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 2 && before == 1) {

                    if (s.charAt(1) == '/') {
                        editTextExpirationDate.setText(s.subSequence(0, 1));
                        editTextExpirationDate.setSelection(1);
                    }
                } else if (s.length() == 2 && before == 0) {

                    int month = Integer.parseInt(s.toString());
                    if (month > 12) {

                        editTextExpirationDate.setText("12/");
                        editTextExpirationDate.setSelection(3);
                    } else {

                        editTextExpirationDate.setText(s + "/");
                        editTextExpirationDate.setSelection(3);
                    }
                } else if (s.length() == 5 && before == 0) {

                    int year = Integer.parseInt(s.subSequence(3, 5).toString());
                    if (year < 22) {

                        editTextExpirationDate.setText(s.subSequence(0, 3) + "22");
                        editTextExpirationDate.setSelection(5); // Mover el cursor al final del campo
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });


        editTextName.setFilters(new InputFilter[] {new InputFilter.LengthFilter(20)});
        editTextName.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
        editTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().matches("[a-zA-Z ]*")) {
                    editTextName.setError("Solo se permiten letras");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cardNumber = editTextCardNumber.getText().toString().replaceAll("\\s+", "");
                String securityCode = editTextSecurityCode.getText().toString();
                String expirationDate = editTextExpirationDate.getText().toString();
                String name = editTextName.getText().toString();
                String address = editTextAddress.getText().toString();


                if (TextUtils.isEmpty(cardNumber) || TextUtils.isEmpty(securityCode) || TextUtils.isEmpty(expirationDate) || TextUtils.isEmpty(name) || TextUtils.isEmpty(address)) {

                    Toast.makeText(PaymentActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(PaymentActivity.this, "Compra realizada", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(PaymentActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        Button buttonGoToMainMenu = findViewById(R.id.buttonGoToMainMenu);
        buttonGoToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PaymentActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}