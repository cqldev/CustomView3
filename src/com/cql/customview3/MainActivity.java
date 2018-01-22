
package com.cql.customview3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Log.d("cql","onCreate......");
        setContentView(R.layout.activity_main);
        
//        RelativeLayout parent = (RelativeLayout) findViewById(R.id.content_parent);
        
//        SkyView skyView = new SkyView(this);
//        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//        lp.addRule(RelativeLayout.CENTER_IN_PARENT);
//        parent.addView(skyView, lp);
        
        SkyView skyView = (SkyView) findViewById(R.id.circle);
        Log.d("cql","11111");
        skyView.setSweepValue(250);
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("cql","onStart......");
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("cql","onResume......");
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("cql","onPause......");
    }
}
