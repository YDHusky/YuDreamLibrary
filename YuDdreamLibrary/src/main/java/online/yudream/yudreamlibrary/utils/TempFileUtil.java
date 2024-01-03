package online.yudream.yudreamlibrary.utils;

import android.app.Activity;
import android.graphics.Bitmap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TempFileUtil {
    /**
     * 保存临时图片
     * @param bitmap 图片
     * @param context 上下文
     * @return 图片路径
     */
    public static String saveImage(Bitmap bitmap, Activity context){
        File cachePath = new File(context.getCacheDir(),"images"); // 获取缓存目录
        String fileName = System.currentTimeMillis() + ".jpg"; // 以时间戳命名图片
        cachePath.mkdirs(); // 创建缓存目录
        try {
            File imageFile = new File(cachePath,fileName);
            FileOutputStream stream = new FileOutputStream(imageFile); // 创建输出流.
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream); // 将Bitmap压缩到输出流
            stream.close();
            //返回图片路径
            return imageFile.getAbsolutePath();
        } catch (IOException e) {
            return null;
        }
    }
    /**
     * 清除缓存
     * @param context 上下文
     */
    public static void clearCache(Activity context) {
        try {
            File cacheDir = context.getCacheDir(); // 获取缓存目录
            deleteDir(cacheDir); // 删除该目录下的所有文件和子目录
        } catch (Exception e) {
            e.printStackTrace();
            // 处理异常
        }
    }
    /**
     * 删除文件和目录
     * @param dir 文件或目录
     * @return 删除成功返回true，否则返回false
     */
    private static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false; // 如果任何子文件或子目录删除失败，则返回失败
                }
            }
            return dir.delete(); // 删除当前目录
        } else if(dir != null && dir.isFile()) {
            return dir.delete(); // 删除当前文件
        }
        return false;
    }
}
