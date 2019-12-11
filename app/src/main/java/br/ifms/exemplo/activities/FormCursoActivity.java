package br.ifms.exemplo.activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import br.ifms.exemplo.R;
import br.ifms.exemplo.dao.CursoDAO;
import br.ifms.exemplo.model.Curso;

public class FormCursoActivity extends AppCompatActivity {

    private Button botaoSalvar;
    private EditText campoNome;
    private TextView campoDescricao;
    private Button btnData;
    private CursoDAO dao;
    DatePickerDialog picker;
    EditText eText;
    Button btnGet;
    TextView tvw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Nova Tarefa");
        setContentView(R.layout.activity_form_curso);
        inicializarDAO();
        inicializarReferencias();
        inicializarAcoes();

        campoDescricao=(TextView)findViewById(R.id.button1);
        eText=(EditText) findViewById(R.id.activity_form_curso_campo_descricao);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                // date picker dialog
                picker = new DatePickerDialog(FormCursoActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        btnGet=(Button)findViewById(R.id.button1);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                campoDescricao.setText("Data selecionada: "+ eText.getText());
            }
        });

    }


    private void inicializarDAO(){
        dao = new CursoDAO(getBaseContext());
    }

    private void inicializarReferencias(){
        botaoSalvar = findViewById(R.id.activity_form_curso_botao_salvar);
        campoNome = findViewById(R.id.activity_form_curso_campo_nome);
        //btnData = findViewById(R.id.btnData);
        campoDescricao = findViewById(R.id.activity_form_curso_campo_descricao);
    }

    private void inicializarAcoes(){
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Curso curso = new Curso();
                curso.setNome(campoNome.getText().toString());
                curso.setDescricao (campoDescricao.getText().toString());
                campoDescricao.setText("Tarefa "+campoDescricao.getId());
                dao.addNovoCurso(curso);
                Toast toast = Toast.makeText(FormCursoActivity.this,"Salvo!",Toast.LENGTH_LONG);
                toast.show();
                finish();
            }
        });
    }
}
