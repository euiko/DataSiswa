package id.sch.smktelkom_mlg.tugas01.xiirpl1013.datasiswa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText isinama;
    RadioButton rbL, rbP;
    Button bOK;
    TextView tvHasil, tvJk;
    CheckBox cbO, cbS1, cbS2;
    Spinner spKelas;

    String jk = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isinama = (EditText) findViewById(R.id.editTextNama);
        rbL = (RadioButton) findViewById(R.id.radioButtonLaki);
        rbP = (RadioButton) findViewById(R.id.radioButtonPerempuan);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvJk = (TextView) findViewById(R.id.textView3);
        spKelas = (Spinner) findViewById(R.id.spinnerKelas);
        cbO = (CheckBox) findViewById(R.id.checkBoxOlahraga);
        cbS1 = (CheckBox) findViewById(R.id.checkBoxSeni);
        cbS2 = (CheckBox) findViewById(R.id.checkBoxSastra);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });

    }

    private void doClick() {
        if (rbL.isChecked()) {
            jk = rbL.getText().toString();
        } else if (rbP.isChecked()) {
            jk = rbP.getText().toString();
        }

        if (isValid()) {
            String nama = isinama.getText().toString();


            String kelas = spKelas.getSelectedItem().toString();

            String hobi = "Hobi Anda\t\t\t: ";
            String hobiS = "";
            int startlen = hobiS.length();
            if (cbO.isChecked()) hobiS += cbO.getText() + ", ";
            if (cbS1.isChecked()) hobiS += cbS1.getText() + ", ";
            if (cbS2.isChecked()) hobiS += cbS2.getText() + ", ";
            if (hobiS == "") hobiS = "Anda tidak memiliki hobi. ";

            hobiS = hobiS.substring(0, hobiS.length() - 2);
            hobi += hobiS;

            if (kelas.length() == startlen) kelas += "(No object was choosen)";

            tvHasil.setText("Nama\t\t\t\t\t: " + nama + "\n" + "Jenis Kelamin\t: " + jk + "\n"
                    + "Kelas\t\t\t\t\t\t: " + kelas + "\n" + hobi);
        }
    }

    public boolean isValid() {
        boolean valid = true;

        String nama = isinama.getText().toString();

        if (nama.isEmpty()) {
            isinama.setError("Name must be filled!");
            valid = false;
        } else if (nama.length() < 3) {
            isinama.setError("Name min have 3 characters!");
            valid = false;
        } else {
            isinama.setError(null);
        }

        if (jk == null) {
            tvJk.setError("No object was choosen");
            valid = false;
        } else {
            tvJk.setError(null);
        }
        return valid;
    }

}
