package com.calllogsdemo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.util.Log;

/**
 * Created by Rohit on 28-06-2019.
 */

public class CallLogHelper {
    public static Cursor getAllCallLogs(ContentResolver cr) {
        /*// reading all data in descending order according to DATE
        String strOrder = android.provider.CallLog.Calls.DATE + " DESC";
        Uri callUri = Uri.parse("content://call_log/calls");
        Cursor curCallLogs = cr.query(callUri, null, null, null, strOrder);

        return curCallLogs;*/

        try {
            Cursor callLogCursor = cr.query(android.provider.CallLog.Calls.CONTENT_URI, /*uri*/
                    null, /*projection*/
                    null,/*selection*/
                    null,/*selection arguments*/
                    android.provider.CallLog.Calls.DEFAULT_SORT_ORDER /*sort by*/);

            return callLogCursor;
        } catch (SecurityException e) {
            e.printStackTrace();
        }

        return null;
    }
}
