package com.kingtous.remotefingerunlock.WLANConnectTool;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.kingtous.remotefingerunlock.DataStoreTool.RecordData;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class WLANClient extends AsyncTask<Void, String, String> {

    String host;
    int port;
    RecordData data;
    private Context context;

    WLANClient(Context context,String host, int port, RecordData data) {
        this.context=context;
        this.host = host;
        this.port = port;
        this.data = data;
    }

    @Override
    protected String doInBackground(Void... arg0) {
        //  连接
        try {
            Socket socket=new Socket(host,port);
            OutputStream stream=socket.getOutputStream();
            JSONObject object = new JSONObject();
            object.put("username", data.getUser());
            object.put("passwd", data.getPasswd());
            stream.write(object.toString().getBytes(StandardCharsets.UTF_8));
            stream.close();
        } catch (IOException ignored) {
        } catch (JSONException ignored) {
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);



    }

}
