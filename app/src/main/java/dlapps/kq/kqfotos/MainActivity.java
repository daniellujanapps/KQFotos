package dlapps.kq.kqfotos;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.metaio.sdk.ARViewActivity;
import com.metaio.sdk.MetaioDebug;
import com.metaio.sdk.jni.IGeometry;
import com.metaio.sdk.jni.IMetaioSDKCallback;
import com.metaio.tools.io.AssetsManager;

import java.io.IOException;


public class MainActivity extends ARViewActivity {

    /**
     * Provide resource for GUI overlay if required.
     * <p/>
     * The resource is inflated into mGUIView which is added in onStart
     *
     * @return Resource ID of the GUI view
     */
    @Override
    protected int getGUILayout() {
        Log.i("getGuiLayout", "hello from main");
        return R.layout.activity_main;
    }

    /**
     * Provide metaio SDK callback handler if desired.
     *
     * @return Return metaio SDK callback handler
     * @see com.metaio.sdk.jni.IMetaioSDKCallback
     */
    @Override
    protected IMetaioSDKCallback getMetaioSDKCallbackHandler() {
        return null;
    }

    /**
     * Load rendering contents to metaio SDK in this method, e.g. 3D models, environment map etc..
     */
    @Override
    protected void loadContents() {

    }

    /**
     * Called when a geometry is touched.
     *
     * @param geometry Geometry that is touched
     */
    @Override
    protected void onGeometryTouched(IGeometry geometry) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.frozenFotoBtn) {
            Log.i("MainActivity", "click frozenFotoBtn");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void frozenFotoBtn_Click(View view){
        Log.i("MainActivity", "frozen button clicked - main");
    }

    /******************* metaio *****************************/

    /**
     * This task extracts all the application assets to an external or internal location
     * to make them accessible to Metaio SDK
     */
    private class AssetsExtracter extends AsyncTask<Integer, Integer, Boolean>
    {

        @Override
        protected void onPreExecute()
        {
        }

        @Override
        protected Boolean doInBackground(Integer... params)
        {
            try
            {
                // Extract all assets and overwrite existing files if debug build
                AssetsManager.extractAllAssets(getApplicationContext(), BuildConfig.DEBUG);
            }
            catch (IOException e)
            {
                MetaioDebug.log(Log.ERROR, "Error extracting assets: " + e.getMessage());
                MetaioDebug.printStackTrace(Log.ERROR, e);
                return false;
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean result)
        {
            if (result)
            {
                // Start AR Activity on success
                Log.i("MainActivity", "random shit");
//                Intent intent = new Intent(getApplicationContext(), FotoActivity.class);
//                startActivity(intent);
            }
            else
            {
                // Show a toast with an error message
                Toast toast = Toast.makeText(getApplicationContext(), "Error extracting application assets!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
            }

            finish();
        }

    }

}
