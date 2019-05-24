package com.example.trang_exe2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    private Sensor accelerometor;
    private float vibrateThreshold = 0;
    LinearLayout view;
    ImageView imgHinh, top, left, bottom, right;
    String data;
    private  float lastX, lastY, lastZ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setSensor();
    }
    public void setControl(){
        view = (LinearLayout) findViewById(R.id.linearLayout);
        imgHinh = (ImageView) findViewById(R.id.imageView);
        top = (ImageView) findViewById(R.id.top);
        left = (ImageView) findViewById(R.id.left);
        bottom = (ImageView) findViewById(R.id.bottom);
        right = (ImageView) findViewById(R.id.right);
    }

    public void setEvent(){
    }
    private void setSensor(){
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
            accelerometor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, accelerometor, SensorManager.SENSOR_DELAY_NORMAL);
            vibrateThreshold = accelerometor.getMaximumRange() / 2;
        }
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            doiHinh(event);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void doiHinh(SensorEvent event){
        if(lastY <= -2.0 ){
            top.setImageResource(R.drawable.top);
            top.setColorFilter(Color.RED);
            imgHinh.setImageResource(R.drawable.dt1);
            view.setBackgroundColor(Color.RED);
            data = "#1";

        }
        else if(lastY >= 2.0 ){
            bottom.setImageResource(R.drawable.bottom);
            bottom.setColorFilter(Color.BLUE);
            imgHinh.setImageResource(R.drawable.dt2);
            view.setBackgroundColor(Color.BLUE);
            data = "#2";
        }

        if(lastX <= -2.0 ){
            right.setImageResource(R.drawable.right);
            right.setColorFilter(Color.BLACK);
            imgHinh.setImageResource(R.drawable.dt3);
            view.setBackgroundColor(Color.BLACK);
            data = "#3";

        }else if(lastX >= 2.0){
            left.setImageResource(R.drawable.left);
            left.setColorFilter(Color.YELLOW);
            imgHinh.setImageResource(R.drawable.dt4);
            view.setBackgroundColor(Color.YELLOW);
            data = "#4";
        }


        lastX = event.values[0];
        lastY = event.values[1];
        lastZ = event.values[2];
    }
}
