package mr.lmd.personal.randomgvapplication;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
    
    public void genRandom() {
        for (int i = 0; i < 100; i++) {
            Log.d("ELSeed", "" + (int) Math.random() * 60 + 1);
        }
    }

}