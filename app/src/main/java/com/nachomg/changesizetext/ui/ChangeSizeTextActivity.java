package com.nachomg.changesizetext.ui;

import com.nachomg.changesizetext.ChangeSizeApplication;
import com.nachomg.changesizetext.model.Message;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.nachomg.changesizetext.databinding.ActivityChangeSizeTextBinding;

/**
 * Clase que pide al usuario un texto y un tamañi de texto mediante el componente SeekBar.
 * Después se inicializa un TextView @see {@link ViewMessageActivity}
 */
public class ChangeSizeTextActivity extends AppCompatActivity {

    private ActivityChangeSizeTextBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityChangeSizeTextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btSend.setOnClickListener(view -> {
            btSendOnClick();
        });
    }

    private void btSendOnClick() {
        //1.Crear objeto Bundle.
        //2. Añadir mensaje al Bundle.
        //3. Enviar Intent cone el Bundle.

        Bundle bundle= new Bundle();

        //Para obtener el usuario de la clase Applicaction: obtenemos la clase Application (getApplication()),
        //Casting ChangeSizeApplication
        //getUser().
        Message message= new Message(((ChangeSizeApplication)getApplication()).getUser(),
                binding.etTexto.getText().toString(),binding.skSize.getProgress());

        bundle.putSerializable("message",message);
        Intent intent= new Intent(this,ViewMessageActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}