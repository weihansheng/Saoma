package com.example.johan007.saoma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import retrofit2.adapter.rxjava.HttpException;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {
    int REQUEST_CODE=100;
    private Button btn;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= (Button) findViewById(R.id.btn);
        tvResult= (TextView) findViewById(R.id.tv_result);

        //Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
        //startActivityForResult(intent, REQUEST_CODE);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("");
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);


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
                    //Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                    Log.d("test","扫描值="+result);
                    getData(result);

                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public void getData(String code) {
        NetRequest.APIInstance2.getDataTest("10",code)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(results -> {
                    Log.d("test","result="+results.toString());
                    if (results.error.equals("") ){

                        //Log.d("test","result="+results.toString());
                        String str=results.result.toString();
                        tvResult.setText(str.substring(str.length()-8,str.length()));

                    } else {
                        //ToastUtil.shortShowText(results.message);
                        Toast.makeText(MainActivity.this,results.error,Toast.LENGTH_SHORT).show();
                        String str=results.error.toString();
                        tvResult.setText(str);
                    }
                }, throwable -> {
                    //loadFaillayout.setVisibility(View.VISIBLE);
                    if (throwable instanceof HttpException) {
                        //ToastUtil.shortShowText("网络连接异常");
                        Toast.makeText(MainActivity.this,"网络连接异常",Toast.LENGTH_SHORT).show();
                    } else {
                        //ToastUtil.shortShowText("验证失败");
                        Toast.makeText(MainActivity.this,"验证失败",Toast.LENGTH_SHORT).show();
                    }
                    //throwableDataList.add(throwable.getMessage());
                });

    }
}
