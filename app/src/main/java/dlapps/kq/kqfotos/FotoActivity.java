package dlapps.kq.kqfotos;

import android.opengl.GLSurfaceView;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.metaio.sdk.ARViewActivity;
import com.metaio.sdk.jni.IGeometry;
import com.metaio.sdk.jni.IMetaioSDKCallback;


public class FotoActivity extends ARViewActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_foto, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    /************************* METAIO ********************************/
    /**
     * Provide resource for GUI overlay if required.
     * <p/>
     * The resource is inflated into mGUIView which is added in onStart
     *
     * @return Resource ID of the GUI view
     */
    @Override
    protected int getGUILayout() {
        /* ADD LAYOUT TO GUI ON TOP OF GLSurfaceView*/

        Log.i("getGuiLayout", "hello from foto");
        return R.layout.activity_foto;
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
}
