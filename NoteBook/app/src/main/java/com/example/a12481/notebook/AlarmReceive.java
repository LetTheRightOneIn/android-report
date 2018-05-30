package com.example.a12481.notebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;



/**
 * Created by 12481 on 2018/5/28.
 */

public class AlarmReceive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent tempIntent = new Intent(context,MainActivity.class);
       Bundle bundle = new Bundle();
        bundle.putString("msg", "msg");
        tempIntent.putExtras(bundle);
        tempIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//设置新的task
        context.startActivity(tempIntent);
    }
}
