package com.example.computo_01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RadioGroup radioGroup = findViewById(R.id.gurpo);
        CheckBox checkBox1 = findViewById(R.id.checkBox);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        Button btnShow = findViewById(R.id.button3);

        btnShow.setOnClickListener(v -> {
            StringBuilder result = new StringBuilder("Seleccionado: ");

            // RadioButton selection
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId != -1) {
                RadioButton selectedRadioButton = findViewById(selectedId);
                result.append(selectedRadioButton.getText()).append(" ");
            } else {
                result.append("Ningún género ");
            }

            // CheckBox selections
            if (checkBox1.isChecked()) {
                result.append("| ").append(checkBox1.getText()).append(" ");
            }
            if (checkBox2.isChecked()) {
                result.append("| ").append(checkBox2.getText()).append(" ");
            }

            Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
        });
    }
}
