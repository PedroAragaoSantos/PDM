package com.ifsc.contaclique;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    int i=0;
    SensorManager mSensorManager;
    Sensor sensor;
    TextView tx, ty, tz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tx = findViewById(R.id.textViewX);
        ty = findViewById(R.id.textViewY);
        tz = findViewById(R.id.textViewZ);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //metodo para verificar sensores
        //mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mSensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        tx.setText(Float.toString(sensorEvent.values[0]));
        ty.setText(Float.toString(sensorEvent.values[1]));
        tz.setText(Float.toString(sensorEvent.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}