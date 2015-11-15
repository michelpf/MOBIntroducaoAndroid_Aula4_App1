package br.com.fiap.mobintroducaoandroid_aula4_app1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ActivityPrincipal extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioGroup rg = null;
    private RadioButton rbMussarela = null;
    private RadioButton rbCalabresa = null;
    private RadioButton rbPortuguesa = null;
    private CheckBox cbBorda = null;
    private TextView txtResultado = null;

    private Double valor = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        rg = (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(this);


        rbMussarela = (RadioButton) findViewById(R.id.rbMussarela);
        rbCalabresa = (RadioButton) findViewById(R.id.rbCalabresa);
        rbPortuguesa = (RadioButton) findViewById(R.id.rbPortuguesa);
        cbBorda = (CheckBox) findViewById(R.id.cbBordaRecheada);
        txtResultado = (TextView) findViewById(R.id.txtResultado);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void calcular(View v){

        RadioButton rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
        if (rb.getText().equals("Mussarela")){
            valor+=10;
        }
        if (rb.getText().equals("Calabresa")){
            valor+=15;
        }
        if (rb.getText().equals("Portuguesa")){
            valor+=20;
        }
        if (cbBorda.isChecked() && cbBorda.isEnabled()){
            valor+=5;
        }

        txtResultado.setText(String.valueOf(valor));
        valor=0.0;

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        RadioButton rb = (RadioButton) findViewById(checkedId);
        if (rb.getId()==R.id.rbMussarela){
            cbBorda.setEnabled(false);
        }
        else
        {
            cbBorda.setEnabled(true);
        }

    }
}
