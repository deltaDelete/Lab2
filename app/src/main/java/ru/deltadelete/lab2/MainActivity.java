package ru.deltadelete.lab2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import ru.deltadelete.lab2.databinding.ActivityMainBinding;
import ru.deltadelete.lab2.models.User;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initButton();
    }

    private void initButton() {
        binding.btn.setOnClickListener((view) -> startSecondActivity());
    }

    enum FIELDS {
        NAME("NAME"),
        SURNAME("SURNAME"),
        AGE("AGE"),
        SALARY("SALARY");

        private final String value;

        FIELDS(String value) {
            this.value = value;
        }

        @NonNull
        @Override
        public String toString() {
            return value;
        }
    }
    private void startSecondActivity() {
//        var intent = new Intent(this, SecondActivity.class);
//        intent.putExtra(FIELDS.NAME.toString(), binding.name.getText());
//        intent.putExtra(FIELDS.SURNAME.toString(), binding.surname.getText());
//        intent.putExtra(FIELDS.AGE.toString(), binding.age.getText());
//        intent.putExtra(FIELDS.SALARY.toString(), binding.salary.getText());
//        startActivity(intent);
        var user = new User(
                binding.name.getText().toString(),
                binding.surname.getText().toString(),
                Integer.parseInt(binding.age.getText().toString()),
                Float.parseFloat(binding.salary.getText().toString()),
                89231234567L
        );
        var intent = new Intent(this, SecondActivity.class);
        intent.putExtra("USER", new Gson().toJson(user, User.class));
        startActivity(intent);
    }
}