package online.yudream.yudreamlibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageViewUtils {
    public static void initSize(Activity activity, int id, int padding){
        ImageView imageView = activity.findViewById(id);
        WindowManager windowManager = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        // 创建一个DisplayMetrics对象
        DisplayMetrics metrics = new DisplayMetrics();
        // 获取默认显示对象并将其度量值放入metrics对象
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(metrics);
            // 屏幕宽度（像素）
            int width = metrics.widthPixels;
            ViewGroup.LayoutParams params = imageView.getLayoutParams();
            params.width = width-padding;  // 单位是像素
            params.height = width-padding; // 单位是像素
            imageView.setLayoutParams(params);
        }
    }
    /**
     * 防止bitmap由于图片过大而导致内存溢出(ImageView不显示)
     * @param imagePath 图片路径
     * @return 图片
     */
    public static Bitmap getBitmap(String imagePath){
        Bitmap image = BitmapFactory.decodeFile(imagePath);
        if (image.getWidth()>1000||image.getHeight()>1000){
            if (image.getWidth()>=image.getHeight()){
                image = reSize(image,1000, 1000*image.getHeight()/image.getWidth());
            }
            else {
                image = reSize(image,1000*image.getWidth()/image.getHeight(), 1000);
            }
        }
        return image;
    }
    /**
     * 防止bitmap由于图片过大而导致内存溢出(ImageView不显示)
     * @param image 图片
     * @return 图片
     */
    public static Bitmap getBitmap(Bitmap image){
        if (image.getWidth()>1000||image.getHeight()>1000){
            if (image.getWidth()>=image.getHeight()){
                image = reSize(image,1000, 1000*image.getHeight()/image.getWidth());
            }
            else {
                image = reSize(image,1000*image.getWidth()/image.getHeight(), 1000);
            }
        }
        return image;
    }

    /**
     * 调整图片大小
     * @param originalBitmap 原始图片
     * @param width 宽度
     * @param height 高度
     * @return 调整后的图片
     */
    public static Bitmap reSize(Bitmap originalBitmap,int width,int height){

        // 创建Matrix对象来进行缩放
        Matrix matrix = new Matrix();
        matrix.postScale((float) width / originalBitmap.getWidth(), (float) height / originalBitmap.getHeight());
        // 使用Matrix来缩放图像
        return Bitmap.createBitmap(originalBitmap, 0, 0, originalBitmap.getWidth(), originalBitmap.getHeight(), matrix, true);
    }
}
