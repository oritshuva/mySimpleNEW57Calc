package com.example.mysimplenew57calc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText Num1,Num2;
    TextView tvResult;
    Button btnPlus;
    Button btnMinus;
    Button btnMult;
    Button btnDiv;
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

    }

    public void onBtnClicked(View view) {
        // קריאת ערכים מה-EditText
        String et1Text = Num1.getText().toString().trim();
        String et2Text = Num2.getText().toString().trim();

        // בדיקה אם הקלט ריק
        if (et1Text.isEmpty() || et2Text.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        // המרת קלט למספרים
        int num1 = Integer.parseInt(et1Text);
        int num2 = Integer.parseInt(et2Text);
        int result = 0;

        if (view.getId() == R.id.btnPlus) {
            result = num1 + num2;
        } else if (view.getId() == R.id.btnMinus) {
            result = num1 - num2;
        } else if (view.getId() == R.id.btnMult) {
            result = num1 * num2;
        } else if (view.getId() == R.id.btnDiv) {
            if (num2 == 0) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                return;
            }
            result = num1 / num2;
        }

        // הצגת התוצאה ב-TextView
        tvResult.setText(String.valueOf(result));
    }

}