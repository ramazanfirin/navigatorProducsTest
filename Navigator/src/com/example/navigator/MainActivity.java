package com.example.navigator;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	final int defaultFlag = PackageManager.MATCH_DEFAULT_ONLY;
	Intent[] explicitIntents;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
    public void general(View view){
    	try{ 
    	        Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
    	        Intent implicitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:41.034430, 29.229620")); //NOTE: google navigation can't be launched without destination
    	        startActivity(implicitIntent);
        }catch(Exception e) {
          	 Toast.makeText(MainActivity.this, "error :  "+e.getMessage(), Toast.LENGTH_LONG).show();
           }
   }
    
    public void googleMap(View view){
    	try{ 
    	        Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
    	        Intent implicitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=tepeustu istanbul")); //NOTE: google navigation can't be launched without destination
    	        startActivity(implicitIntent);
        }catch(Exception e) {
          	 Toast.makeText(MainActivity.this, "error :  "+e.getMessage(), Toast.LENGTH_LONG).show();
           }
   }

    
    public void googleMap2(View view){
    	try{ 	
        Toast.makeText(MainActivity.this, "google mAp2 ", Toast.LENGTH_SHORT).show();
        String uri = "google.navigation:ll=%f,%f";
        Intent navIntent = new Intent(
            Intent.ACTION_VIEW,
            Uri.parse(String.format(uri, "41.0249", "29.1226")));
        startActivity(navIntent);
    }catch(Exception e) {
   	 Toast.makeText(MainActivity.this, "error :  "+e.getMessage(), Toast.LENGTH_LONG).show();
    }
}
    
 public void sygic(View view){
		try{ 
        Toast.makeText(MainActivity.this, "sygic ", Toast.LENGTH_SHORT).show();
        String str = "http://com.sygic.aura/coordinate|29.1226|41.0249|drive"; 
        startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse(str)) );
		}catch(Exception e) {
			 Toast.makeText(MainActivity.this, "error :  "+e.getMessage(), Toast.LENGTH_LONG).show();
		 }
}
    
 public void route66(View view){
		try{ 
     Toast.makeText(MainActivity.this, "route66", Toast.LENGTH_SHORT).show();
     String str = "route66://?daddr=tepeustu istanbul"; 
     startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse(str)) );
 }catch(Exception e) {
	 Toast.makeText(MainActivity.this, "error :  "+e.getMessage(), Toast.LENGTH_LONG).show();
 }
}
 
 public void route66_2(View view){
	try{ 	
     Toast.makeText(MainActivity.this, "route66_2", Toast.LENGTH_SHORT).show();
     String str = "route66://?daddr=41.0249,29.1226"; 
     Toast.makeText(MainActivity.this, "route_2 by coordinate", Toast.LENGTH_LONG).show();
    startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse(str)) );
	}catch(Exception e) {
		 Toast.makeText(MainActivity.this, "error :  "+e.getMessage(), Toast.LENGTH_LONG).show();
	 }
	}
 
    public void explicitIntent(View view){
    	getExplicitIntents();
    	 Toast.makeText(MainActivity.this, "exlipict intent ", Toast.LENGTH_SHORT).show();
    	 try {
    		 startActivity(getExplicitIntents()[0]);
    		 }
    		 catch(Exception e) {
    			 Toast.makeText(MainActivity.this, "error :  "+e.getMessage(), Toast.LENGTH_LONG).show();
    		 }


    		 
    	
    }	
    private Intent[] getExplicitIntents() {
    	if(explicitIntents == null) {
    	PackageManager currentPM = getPackageManager();
    	explicitIntents = new Intent[]{
		    	new Intent("android.intent.action.navigon.START_PUBLIC"), //navigon with public intent
		    	currentPM.getLaunchIntentForPackage("com.navigon.navigator"), //navigon without public intent
		    	currentPM.getLaunchIntentForPackage("hr.mireo.dp"), //ginius driver dont panic
		    	currentPM.getLaunchIntentForPackage("com.ndrive.android"), //ndrive
		    	currentPM.getLaunchIntentForPackage("com.sygic.aura"), //aura
		    	currentPM.getLaunchIntentForPackage("org.microemu.android.se.appello.lp.Lightpilot") // wisepilot
		    	};
		    	}
    	return explicitIntents;
    	}


    
}
