package com.jcodee.demodownload;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.LinearLayout;

import com.jcodee.demodownload.rest.HelperWS;
import com.jcodee.demodownload.rest.MetodoWS;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.layout)
    LinearLayout layout;
    @BindView(R.id.btn_download)
    AppCompatButton btnDownload;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_download)
    public void downloadFile() {
        btnDownload.setEnabled(false);

        MetodoWS metodoWS = HelperWS.getConfiguration().create(MetodoWS.class);

        Call<ResponseBody> request = metodoWS.downloadFile();
        request.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {

                new AsyncTask<Void, Long, Void>() {
                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();

                        progressDialog = new ProgressDialog(MainActivity.this);
                        progressDialog.setMessage("Descargando...");
                        progressDialog.setCancelable(false);
                        progressDialog.show();
                    }

                    @Override
                    protected Void doInBackground(Void... voids) {
                        downloadFile(response.body());
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        super.onPostExecute(aVoid);
                    }
                }.execute();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void downloadFile(ResponseBody body) {
        try {
            int count;
            byte data[] = new byte[1024 * 4];
            InputStream bis = new BufferedInputStream(body.byteStream(), 1024 * 8);
            final File outputFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    UUID.randomUUID().toString().replace("-", "") + ".pdf");
            OutputStream output = new FileOutputStream(outputFile);
            while ((count = bis.read(data)) != -1) {
                output.write(data, 0, count);
            }
            output.flush();
            output.close();
            bis.close();
            progressDialog.dismiss();
            btnDownload.setEnabled(true);

            Snackbar.make(layout, "Se descargo el archivo", Snackbar.LENGTH_LONG)
                    .setAction("Abrir", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension(".PDF");

                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_VIEW);
                            intent.setDataAndType(Uri.fromFile(outputFile), mime);
                            startActivityForResult(intent, 10);
                        }
                    })
                    .show();
        } catch (IOException e) {

        }
    }
}
