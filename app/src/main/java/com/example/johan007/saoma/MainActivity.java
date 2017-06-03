package com.example.johan007.saoma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    int REQUEST_CODE=100;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= (Button) findViewById(R.id.btn);

        //Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
        //startActivityForResult(intent, REQUEST_CODE);

        final String baseUrl = "http://118.178.230.233:8080/JW/Agent/";





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);*/
                //创建Retrofit对象
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                final APIClient movieService = retrofit.create(APIClient.class);
                final Call<ObjectEntity> call = movieService.getDataTest("3","0","0");
                call.enqueue(new Callback<ObjectEntity>() {
                    @Override
                    public void onResponse(Call<ObjectEntity> call, Response<ObjectEntity> response) {
                        //tvShow.setText(response.body().getTitle());

                        Log.i("onResponse", response.toString());
                        Toast.makeText(MainActivity.this, "请求成功", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<ObjectEntity> call, Throwable t) {
                        //tvShow.setText(t.getMessage());
                        Log.i("Failure", t.toString());
                        Toast.makeText(MainActivity.this, "请求失败", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //Toast.makeText(this, "返回了", Toast.LENGTH_LONG).show();
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();

                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
