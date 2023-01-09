package com.djht.fourteenth_session.Utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

import androidx.appcompat.app.AppCompatActivity;

public class Image_chage_D extends AppCompatActivity {
    /**
     * 构造器私有化
     */
    public Image_chage_D(){

    }
    /**
     * 改变图片大小
     * @param bm 图片资源
     * @param screenWidth
     * @param screenHeight
     * @return
     */
    public static Bitmap zoomImg(Bitmap bm, int screenWidth, int screenHeight) {
        // 获得图片的宽高
        int width = bm.getWidth();
        int height = bm.getHeight();
        // 计算缩放比例
        float scaleWidth = ((float) screenWidth) / width;
        float scaleHeight = ((float) screenHeight) / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        System.out.println(newbm);
        return newbm;
    }

    /**
     * 剪切图片为圆形
     * @param source
     * @return
     */
    public static Bitmap createCircleImage(Bitmap source) {
        int length = source.getWidth() < source.getHeight() ? source.getWidth() : source.getHeight();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap target = Bitmap.createBitmap(length, length, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(target);
        canvas.drawCircle(length / 2, length / 2, length / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(source, 0, 0, paint);
        return target;
    }
}
