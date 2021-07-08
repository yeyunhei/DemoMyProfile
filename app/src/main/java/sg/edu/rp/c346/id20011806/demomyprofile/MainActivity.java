package sg.edu.rp.c346.id20011806.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);




    }

    @Override
    protected void onResume() {
        super.onResume();

        //name
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String savedname = prefs.getString("username", "no username!");
        etName.setText(savedname);
        //gpa
        Float floatGPA = prefs.getFloat("gpa", 0);
        etGPA.setText(floatGPA + "");

    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("username", strName);
        prefEdit.putFloat("gpa", gpa);
        prefEdit.commit();
    }
}