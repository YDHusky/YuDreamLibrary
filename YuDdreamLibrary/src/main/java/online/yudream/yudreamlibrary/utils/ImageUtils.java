package online.yudream.yudreamlibrary.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;


public class ImageUtils {
    /**
     * 转换像素值域
     * @param f 像素值
     * @return 转换后的像素值
     */
    public static int toPixelFloat(float f) {
        return (int)((f+1) * 127.5);
    }


    /**
     * 重新调整图片大小
     * @param bitmap 图片
     * @param width 宽度
     * @param height 高度
     * @return 调整后的图片
     */
    public static Bitmap changeBitmapSize(Bitmap bitmap, int width, int height){
        int imgWidth = bitmap.getWidth();
        int imgHeight = bitmap.getHeight();
        float scaleWidth = ((float) width) / imgWidth;
        float scaleHeight = ((float) height) / imgHeight;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth,scaleHeight);
        return Bitmap.createBitmap(bitmap,0,0,imgWidth,imgHeight,matrix,true);
    }
    /**
     * 将图片转换为3D数组
     * @param bitmap 图片
     * @param width 宽度
     * @param height 高度
     * @return 数组
     */
    public static float[][][] convertBitmapToByteBuffer(Bitmap bitmap, int width, int height) {
        float [][][] input= new float[width][height][3];
        for (int y=0;y<width;++y){
            for (int x=0;x<height;++x){
                float r = Color.red(bitmap.getPixel(x,y));
                float g = Color.green(bitmap.getPixel(x,y));
                float b = Color.blue(bitmap.getPixel(x,y));
                input[x][y][0]=r;
                input[x][y][1]=g;
                input[x][y][2]=b;
            }
        }
        return input;
    }
    /**
     * 将3D数组转换为图片
     * @param array 数组
     * @return 图片
     */
    public static Bitmap convertArrayToBitmap(float[][][] array) {
        int width = array.length;
        int height = array[0].length;
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        for (int y = 0; y < width; ++y) {
            for (int x = 0; x < height; ++x) {
                int r = (int) (toPixelFloat(array[x][y][0]));
                int g = (int) (toPixelFloat(array[x][y][1]));
                int b = (int) (toPixelFloat(array[x][y][2]));
                bitmap.setPixel(x, y, Color.rgb(r, g, b));
            }
        }
        return bitmap;
    }

}
