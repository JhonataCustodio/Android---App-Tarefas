package br.ifms.exemplo.adapters;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.ifms.exemplo.R;
import br.ifms.exemplo.activities.FormCursoActivity;
import br.ifms.exemplo.dao.CursoDAO;
import br.ifms.exemplo.model.Curso;

public class AdapterPersonalizado extends BaseAdapter {

    private List<Curso> cursos;
    private AppCompatActivity activity;
    private CursoDAO dao;


    public void setCursos(List<Curso> cursos){
        this.cursos = cursos;
    }

    public AdapterPersonalizado(AppCompatActivity activity){
        this.cursos = new ArrayList<Curso>();
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return cursos.size();
    }

    @Override
    public Object getItem(int position) {
        return cursos.get(position);
    }

    @Override
    public long getItemId(int position) {
        Curso  curso = cursos.get(position);
        return curso.getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity
                .getLayoutInflater()
                .inflate(R.layout.activity_list_cursos_list_item, parent,false);

        TextView campoNome = view.findViewById(R.id.acitivity_list_cursos_list_item_campo_nome);
        final TextView campoDescricao = view.findViewById(R.id.acitivity_list_cursos_list_item_campo_descricao);
        ImageView campoImagem = view.findViewById(R.id.acitivity_list_cursos_list_item_imagem);
        final Button botaoFeito = view.findViewById(R.id.botao_feito);

        final Curso curso = cursos.get(position);

        campoNome.setText(curso.getNome());
        campoDescricao.setText(curso.getDescricao());
        campoImagem.setImageResource(R.drawable.ic_launcher_background);


        final Button button = (Button) view.findViewById(R.id.botao_feito);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                botaoFeito.setBackgroundColor(Color.parseColor("#8FBC8F"));

            }
        });

        return view;
    }





}
