package com.dalvik.bookreaderapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class PDFViewerActivity extends AppCompatActivity {


    private PDFView pdfViewer;
    private String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewer_activity);
        nombre = getIntent().getStringExtra("nombre");
        initComponents(nombre);
    }

    private void initComponents(final String path) {
        pdfViewer = (PDFView) findViewById(R.id.pdfViewer);
        //String pdf = "http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf";
        //pdfViewer.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + url);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf");
                    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                    connection.connect();
                    InputStream pdfSource = connection.getInputStream();
                    //ByteArrayOutputStream bais = new ByteArrayOutputStream();
                    //InputStream in = url.openStream();

                    pdfViewer.fromStream(pdfSource);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

}
