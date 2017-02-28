package fuzitao.diswy.learn_comprehensive_demo.view;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 网络图片加载
 * Created by Fu.Zi.Tao on 2016/10/19.
 */

public class NetworkImageHolderView implements Holder<String> {
    private SimpleDraweeView draweeView;
//    private ImageView imageView;

    @Override
    public View createView(Context context) {
        //你可以通过layout文件来创建，也可以像我一样用代码创建，任何控件都可以进行翻页
        draweeView = new SimpleDraweeView(context);
        draweeView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return draweeView;
//        imageView = new ImageView(context);
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        Uri uri = Uri.parse(data);
        draweeView.setImageURI(uri);
//        imageView.setImageResource(android.R.mipmap.sym_def_app_icon);
    }
}