package com.example.priyanka.fileoperationdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "bvimit.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            saveContentsToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            readContentsFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void saveContentsToFile() throws IOException {
        FileOutputStream stream = openFileOutput(FILE_NAME,Context.MODE_PRIVATE|MODE_APPEND);
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("This is sample content");
        bufferedWriter.close();
        writer.close();
        stream.close();

    }
    private void readContentsFromFile() throws IOException {
        FileInputStream stream1 = openFileInput(FILE_NAME);
        InputStreamReader reader = new InputStreamReader(stream1);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String contents = bufferedReader.readLine();
        bufferedReader.close();
        reader.close();
        stream1.close();
        Toast.makeText(this,contents,Toast.LENGTH_LONG).show();
    }
}
