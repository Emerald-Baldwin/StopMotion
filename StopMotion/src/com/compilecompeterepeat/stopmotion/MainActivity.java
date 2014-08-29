package com.compilecompeterepeat.stopmotion;

import android.hardware.Camera;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
	private Camera mCamera;
	private CameraPreview mPreview;
	
    	@Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Create an instance of Camera
            mCamera = getCameraInstance();

            // Create our Preview view and set it as the content of our activity.
            mPreview = new CameraPreview(this, mCamera);
            FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
            preview.addView(mPreview);
        }
    
    // later use Camera.open(int) to swap between cameras
    // http://developer.android.com/guide/topics/media/camera.html
    public static Camera getCameraInstance() {
    	Camera c = null;
    	try {
    		c = Camera.open(); // attempt to get a Camera instance
    	} catch (Exception e) {
    		// camera is not available (in use or does not exist)
    	}
    	return c;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
