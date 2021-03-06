package com.example.zz7.hiragana;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

/**
 * Created by zz7 on 16-4-3.
 */
public class Fragment2 extends Fragment {

    private MediaPlayer mp;
    private Uri uri;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fg_2, container, false);

        TableLayout tableLayout = (TableLayout) view.findViewById(R.id.table2);
        String[] name_array = getResources().getStringArray(R.array.ga);
        final String[] sound_array = getResources().getStringArray(R.array.s_ga);

        for (int i = 0; i < 5; i++) {

            TableRow currentRow = new TableRow(getContext());

            for (int j = 0; j < 5; j++) {

                Button button = new Button(getContext());
                button.setText(name_array[5 * i + j]);
                button.setId(200 + i * 5 + j);

                button.setGravity(Gravity.CENTER);
                button.setTextSize(32);
                button.setBackground(getResources().getDrawable(R.drawable.table_button));

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int id = v.getId() - 200;

                        if (id == 14)
                            uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/raw/" + "dooo");
                        else
                            uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/raw/" + sound_array[v.getId() - 200]);
                        Log.e("uri", uri.toString());
                        if (mp != null) {
                            mp.reset();
                        }
                        mp = MediaPlayer.create(v.getContext(), uri);
                        mp.start();
                    }
                });
                currentRow.addView(button);
            }
            tableLayout.addView(currentRow);
        }

        return view;
    }


}
