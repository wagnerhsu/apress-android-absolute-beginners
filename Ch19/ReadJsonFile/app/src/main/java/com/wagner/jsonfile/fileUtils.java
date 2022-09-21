package com.wagner.jsonfile;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class fileUtils {
    static final String TAG = fileUtils.class.getName();

    static String readFileFromAssets(Context context, String fileName) throws IOException {
        String jsonString;
        InputStream is = null;
        try {
            is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            Log.e(TAG, "Error to get json from " + fileName, e);
            return null;
        } finally {
            if (is != null) {
                is.close();
            }
        }

        return jsonString;
    }
}
