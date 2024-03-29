package com.example.unitconvertor1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner sourceUnitSpinner;
    private Spinner destinationUnitSpinner;
    private EditText inputEditText;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        sourceUnitSpinner = findViewById(R.id.source_unit_spinner);
        destinationUnitSpinner = findViewById(R.id.destination_unit_spinner);
        inputEditText = findViewById(R.id.input_edit_text);
        convertButton = findViewById(R.id.convert_button);
        resultTextView = findViewById(R.id.result_text_view);

        // Set up spinner listeners
        sourceUnitSpinner.setOnItemSelectedListener(this);
        destinationUnitSpinner.setOnItemSelectedListener(this);

        // Set up button click listener
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });

        // Populate source and destination unit spinners
        ArrayAdapter<CharSequence> unitAdapter = ArrayAdapter.createFromResource(
                this, R.array.units_array, android.R.layout.simple_spinner_item);
        unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceUnitSpinner.setAdapter(unitAdapter);
        destinationUnitSpinner.setAdapter(unitAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Handle spinner item selection
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Handle when no item is selected
    }

    private void convert() {
        // Retrieve input values
        String sourceUnit = sourceUnitSpinner.getSelectedItem().toString();
        String destinationUnit = destinationUnitSpinner.getSelectedItem().toString();
        double inputValue = Double.parseDouble(inputEditText.getText().toString());

        // Perform the conversion
        double convertedValue = performConversion(sourceUnit, destinationUnit, inputValue);

        // Display the converted value
        resultTextView.setText(String.valueOf(convertedValue));
    }

    private double performConversion(String sourceUnit, String destinationUnit, double inputValue) {
        double convertedValue = 0.0;
        boolean isValidConversion = true;

        // Perform the conversion based on the source and destination units
        if (sourceUnit.equals("Inch")) {
            if (destinationUnit.equals("Centimeter")) {
                convertedValue = inputValue * 2.54;
            } else if (destinationUnit.equals("Foot")) {
                convertedValue = inputValue / 12.0;
            } else if (destinationUnit.equals("Yard")) {
                convertedValue = inputValue / 36.0;
            } else if (destinationUnit.equals("Mile")) {
                convertedValue = inputValue / 63360.0;
            } else {
                isValidConversion = false;
            }
        } else if (sourceUnit.equals("Centimeter")) {
            if (destinationUnit.equals("Inch")) {
                convertedValue = inputValue / 2.54;
            } else if (destinationUnit.equals("Foot")) {
                convertedValue = inputValue / 30.48;
            } else if (destinationUnit.equals("Yard")) {
                convertedValue = inputValue / 91.44;
            } else if (destinationUnit.equals("Mile")) {
                convertedValue = inputValue / 160934.4;
            } else {
                isValidConversion = false;
            }
        } else if (sourceUnit.equals("Foot")) {
            if (destinationUnit.equals("Inch")) {
                convertedValue = inputValue * 12.0;
            } else if (destinationUnit.equals("Centimeter")) {
                convertedValue = inputValue * 30.48;
            } else if (destinationUnit.equals("Yard")) {
                convertedValue = inputValue / 3.0;
            } else if (destinationUnit.equals("Mile")) {
                convertedValue = inputValue / 5280.0;
            } else {
                isValidConversion = false;
            }
        } else if (sourceUnit.equals("Yard")) {
            if (destinationUnit.equals("Inch")) {
                convertedValue = inputValue * 36.0;
            } else if (destinationUnit.equals("Centimeter")) {
                convertedValue = inputValue * 91.44;
            } else if (destinationUnit.equals("Foot")) {
                convertedValue = inputValue * 3.0;
            } else if (destinationUnit.equals("Mile")) {
                convertedValue = inputValue / 1760.0;
            } else {
                isValidConversion = false;
            }
        } else if (sourceUnit.equals("Mile")) {
            if (destinationUnit.equals("Inch")) {
                convertedValue = inputValue * 63360.0;
            } else if (destinationUnit.equals("Centimeter")) {
                convertedValue = inputValue * 160934.4;
            } else if (destinationUnit.equals("Foot")) {
                convertedValue = inputValue * 5280.0;
            } else if (destinationUnit.equals("Yard")) {
                convertedValue = inputValue * 1760.0;
            } else {
                isValidConversion = false;
            }
        } else if (sourceUnit.equals("Pound")) {
            if (destinationUnit.equals("Kilogram")) {
                convertedValue = inputValue * 0.453592;
            } else if (destinationUnit.equals("Ounce")) {
                convertedValue = inputValue * 16.0;
            } else if (destinationUnit.equals("Ton")) {
                convertedValue = inputValue / 2000.0;
            } else {
                isValidConversion = false;
            }
        } else if (sourceUnit.equals("Kilogram")) {
            if (destinationUnit.equals("Pound")) {
                convertedValue = inputValue / 0.453592;
            } else if (destinationUnit.equals("Ounce")) {
                convertedValue = inputValue * 35.274;
            } else if (destinationUnit.equals("Ton")) {
                convertedValue = inputValue / 907.185;
            } else {
                isValidConversion = false;
            }
        } else if (sourceUnit.equals("Ounce")) {
            if (destinationUnit.equals("Pound")) {
                convertedValue = inputValue / 16.0;
            } else if (destinationUnit.equals("Kilogram")) {
                convertedValue = inputValue / 35.274;
            } else if (destinationUnit.equals("Ton")) {
                convertedValue = inputValue / 32000.0;
            } else {
                isValidConversion = false;
            }
        } else if (sourceUnit.equals("Ton")) {
            if (destinationUnit.equals("Pound")) {
                convertedValue = inputValue * 2000.0;
            } else if (destinationUnit.equals("Kilogram")) {
                convertedValue = inputValue * 907.185;
            } else if (destinationUnit.equals("Ounce")) {
                convertedValue = inputValue * 32000.0;
            } else {
                isValidConversion = false;
            }
        } else if (sourceUnit.equals("Celsius")) {
            if (destinationUnit.equals("Fahrenheit")) {
                convertedValue = (inputValue * 1.8) + 32.0;
            } else if (destinationUnit.equals("Kelvin")) {
                convertedValue = inputValue + 273.15;
            } else {
                isValidConversion = false;
            }
        } else if (sourceUnit.equals("Fahrenheit")) {
            if (destinationUnit.equals("Celsius")) {
                convertedValue = (inputValue - 32.0) / 1.8;
            } else if (destinationUnit.equals("Kelvin")) {
                convertedValue = (inputValue + 459.67) * 5.0 / 9.0;
            } else {
                isValidConversion = false;
            }
        } else if (sourceUnit.equals("Kelvin")) {
            if (destinationUnit.equals("Celsius")) {
                convertedValue = inputValue - 273.15;
            } else if (destinationUnit.equals("Fahrenheit")) {
                convertedValue = (inputValue * 9.0 / 5.0) - 459.67;
            } else {
                isValidConversion = false;
            }

            if (!isValidConversion) {
                String errorMessage = "Invalid conversion";
                resultTextView.setText(errorMessage);
            } else {
                // Display the converted value in the app's UI
                resultTextView.setText(String.valueOf(convertedValue));
            }
        }
        return convertedValue;
    }

//    private void displayErrorMessage(String errorMessage) {
//        // Find the TextView in your app's UI and set the error message
//        TextView errorTextView = findViewById(R.id.errorTextView);
//        errorTextView.setText(errorMessage);
//    }

//    private void displayConvertedValue(double convertedValue) {
//        // Find the TextView in your app's UI and set the converted value
//        TextView convertedTextView = findViewById(R.id.result_text_view);
//        convertedTextView.setText(String.valueOf(convertedValue));
//    }


}
