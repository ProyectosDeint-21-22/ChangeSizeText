package com.nachomg.changesizetext.ui;

import com.nachomg.changesizetext.ChangeSizeApplication;
import com.nachomg.changesizetext.model.Message;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.nachomg.changesizetext.databinding.ActivityChangeSizeTextBinding;

/**
 * Clase que pide al usuario un texto y un tamaño de texto mediante el componente SeekBar.
 * Después se inicializa un TextView @see {@link ViewMessageActivity}
 */
public class ChangeSizeTextActivity extends AppCompatActivity {

    private static final String TAG = "ChangeSizeText";
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

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"ChangeSizeTextActivity-> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"ChangeSizeTextActivity-> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"ChangeSizeTextActivity-> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"ChangeSizeTextActivity-> onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"ChangeSizeTextActivity-> onDestroy()");
    }

    private void btSendOnClick() {
        //1.Crear objeto Bundle.
        //2. Añadir mensaje al Bundle.
        //3. Enviar Intent con el Bundle.

        Bundle bundle= new Bundle();

        /**
         * Para obtener el usuario de la clase Applicaction: obtenemos la clase Application (getApplication()),
         * Casting ChangeSizeApplication
         * getUser().
         */
        Message message= new Message(((ChangeSizeApplication)getApplication()).getUser(),
                binding.etTexto.getText().toString(),binding.skSize.getProgress());

        bundle.putSerializable("message",message);
        Intent intent= new Intent(this,ViewMessageActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}