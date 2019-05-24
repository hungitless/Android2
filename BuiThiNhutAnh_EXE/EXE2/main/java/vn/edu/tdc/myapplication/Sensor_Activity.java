package vn.edu.tdc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.widget.Toast;

public class Sensor_Activity extends AppCompatActivity implements SensorEventListener{
    private SensorManager sensorManager;
    private boolean isColor = false;
    private View view;
    private View view2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_layout);
        view = findViewById(R.id.img1);
        view2 = findViewById(R.id.imgHinh);
        view.setBackgroundColor(Color.CYAN);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }
    //overriding two methods of SensorEventListener
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometer(event);
        }

    }

    private void getAccelerometer(SensorEvent event) {
        float[] values = event.values;
// Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];

        float accelationSquareRoot = (x * x + y * y + z * z)
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);

        Toast.makeText(getApplicationContext()," Hello!",Toast.LENGTH_SHORT).show();

        if (accelationSquareRoot >= 2)
        {
            if (isColor) {
                view.setVisibility(View.VISIBLE);
                view.setBackgroundColor(Color.YELLOW);
                view2.setVisibility(View.GONE);
            } else {
                view.setVisibility(View.GONE);
                view2.setBackgroundColor(Color.RED);
                view2.setVisibility(View.VISIBLE);
            }
            isColor = !isColor;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
