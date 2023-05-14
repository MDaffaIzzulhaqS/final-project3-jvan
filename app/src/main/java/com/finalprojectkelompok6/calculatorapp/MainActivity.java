package com.finalprojectkelompok6.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private TextView inputText, outputText;
    private String input, output;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnTambah, btnKurang, btnKali, btnBagi, btnPersen, btnPangkat, btnTitik, btnSamaDengan,
            btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.input_text);
        outputText = findViewById(R.id.output_text);

        btn0 = findViewById(R.id.btn_no0);
        btn1 = findViewById(R.id.btn_no1);
        btn2 = findViewById(R.id.btn_no2);
        btn3 = findViewById(R.id.btn_no3);
        btn4 = findViewById(R.id.btn_no4);
        btn5 = findViewById(R.id.btn_no5);
        btn6 = findViewById(R.id.btn_no6);
        btn7 = findViewById(R.id.btn_no7);
        btn8 = findViewById(R.id.btn_no8);
        btn9 = findViewById(R.id.btn_no9);

        btnTambah = findViewById(R.id.btn_tambah);
        btnKurang = findViewById(R.id.btn_kurang);
        btnKali = findViewById(R.id.btn_kali);
        btnBagi = findViewById(R.id.btn_bagi);
        btnPersen = findViewById(R.id.btn_persen);
        btnPangkat = findViewById(R.id.btn_pangkat);
        btnTitik = findViewById(R.id.btn_titik);
        btnSamaDengan = findViewById(R.id.btn_sama_dengan);
        btnClear = findViewById(R.id.btn_clear);
    }

    public void onButtonClicked(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();

        switch (data) {
            case "C":
                input = null;
                output = null;
                outputText.setText("");
                break;
            case "^":
                solve();
                input += "^";
                break;
            case "*":
                solve();
                input += "*";
                break;
            case "%":
                input += "%";
                double d = Double.parseDouble(inputText.getText().toString()) / 100;
                outputText.setText(String.valueOf(d));
                break;
            case "=":
                solve();
                break;
            default:
                if (input == null) {
                    input = "";
                } else if (data.equals("+") || data.equals("-") || data.equals("/")) {
                    solve();
                }
                input += data;
        }
        inputText.setText(input);
    }

    private void solve() {
        if (input.split("\\+").length == 2) {
            String numbers [] = input.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                outputText.setText(output);
                input = d + "";
            } catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\*").length == 2) {
            String numbers [] = input.split("\\*");
            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                outputText.setText(output);
                input = d + "";
            } catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\/").length == 2) {
            String numbers [] = input.split("\\/");
            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                outputText.setText(output);
                input = d + "";
            } catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\^").length == 2) {
            String numbers [] = input.split("\\^");
            try {
                double d = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                output = Double.toString(d);
                outputText.setText(output);
                input = d + "";
            } catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\-").length == 2) {
            String numbers [] = input.split("\\-");
            try {
                if (Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1])) {
                    double d = Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[0]);
                    output = Double.toString(d);
                    outputText.setText("-" + output);
                    input = d + "";
                } else {
                    double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                    output = Double.toString(d);
                    outputText.setText(output);
                    input = d + "";
                }
            } catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }
        }
    }
}