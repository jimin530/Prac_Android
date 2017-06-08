package com.jmdroid.prac_barcode;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;

public class MainActivity extends AppCompatActivity {

    ImageView iv_barcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_barcode = (ImageView) findViewById(R.id.iv_barcode);

        Bitmap bitmap = makeBarcode("999883571493", 800, 200);

        iv_barcode.setImageBitmap(bitmap);
    }

    public Bitmap makeBarcode(String str, int width, int height) {
        Bitmap bitmap = null;
        Writer c9 = new Code128Writer();

        try {
            BitMatrix bitMatrix = c9.encode(str, BarcodeFormat.CODE_128, width, height);
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    bitmap.setPixel(i, j, bitMatrix.get(i, j) ? Color.BLACK : Color.WHITE);
                }
            }
        } catch (WriterException e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}
