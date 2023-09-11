package ru.deltadelete.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import ru.deltadelete.lab2.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        var root = binding.getRoot();
        setContentView(root);

        readData();
        initButtons();
    }

    private void initButtons() {
        binding.btn.setOnClickListener((view) -> getBack());
    }

    public void readData(){
        Bundle arguments = getIntent().getExtras();
        String name = arguments.get(MainActivity.FIELDS.NAME.toString()).toString();
        String surname = arguments.get(MainActivity.FIELDS.SURNAME.toString()).toString();
        String age = arguments.get(MainActivity.FIELDS.AGE.toString()).toString();
        String salary = arguments.get(MainActivity.FIELDS.SALARY.toString()).toString();
        binding.textView.setText(String.format("Name: %s\nSurname: %s\nAge: %s\nSalary: %s", name,surname,age,salary));
    }

    public void getBack() {
        var intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        setResult(RESULT_OK, intent);
        finish();
    }
}