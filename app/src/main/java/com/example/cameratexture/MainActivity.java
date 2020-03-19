package com.example.cameratexture;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.SurfaceTexture;
import android.os.Bundle;

import io.fotoapparat.Fotoapparat;

public class MainActivity extends AppCompatActivity implements TextureAvailableListener {

    Fotoapparat fotoapparat;
    OpenGLView openGLView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openGLView = new OpenGLView(this);
        setContentView(openGLView);
        fotoapparat = new Fotoapparat(this, openGLView);
        openGLView.setTextureAvailableListener(this);
    }

    public void onResume() {
        super.onResume();
        if (openGLView.isTextureAvailable()) {
            fotoapparat.start();
        }

    }

    public void onPause() {
        fotoapparat.stop();
        super.onPause();
    }


    public void onTextureAvailable(SurfaceTexture st) {
        if(fotoapparat != null) {
            fotoapparat.start();
        }
    }
}
