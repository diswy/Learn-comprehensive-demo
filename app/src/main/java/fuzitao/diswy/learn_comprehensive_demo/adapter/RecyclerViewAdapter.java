package fuzitao.diswy.learn_comprehensive_demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

import java.util.ArrayList;
import java.util.List;

import fuzitao.diswy.learn_comprehensive_demo.R;
import fuzitao.diswy.learn_comprehensive_demo.view.NetworkImageHolderView;

/**
 * 添加底部加载更多
 * Created by Administrator on 2017/2/26 0026.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_AD_BANNER = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_LOADING = 2;
    private static final int TYPE_FOOTER = 3;
    private Boolean isLoading = true;
    private Context context;
    private List data;

    private Boolean init;// 初始
    private Boolean canLoop;

    public void setInit(Boolean init) {
        this.init = init;
    }

    public void setCanLoop(Boolean canLoop) {
        this.canLoop = canLoop;
    }

    public void setLoading(Boolean loading) {
        isLoading = loading;
    }

    public RecyclerViewAdapter(Context context, List data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_AD_BANNER) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_ad_banner, parent, false);
            return new AdBannerViewHolder(view);
        } else if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_base, parent, false);
            return new ItemViewHolder(view);
        } else if (viewType == TYPE_LOADING) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        } else if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_footer, parent, false);
            return new FootViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof AdBannerViewHolder) {
            if (init){
                if (canLoop){
                    ((AdBannerViewHolder) holder).convenientBanner.startTurning(2000);
                }else {
                    ((AdBannerViewHolder) holder).convenientBanner.stopTurning();
                }
                init = false;// 初始化执行一次
            }
        }

        if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).tv.setText("这是第 " + position + " 条数据。");
        }


    }

    @Override
    public int getItemCount() {
        return data.size() == 0 ? 1 : data.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return TYPE_AD_BANNER;
        } else if (position + 1 == getItemCount()) {
            if (isLoading)
                return TYPE_LOADING;
            else
                return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    private static class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        ItemViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.recycler_view_tv);

        }
    }

    private static class FootViewHolder extends RecyclerView.ViewHolder {

        FootViewHolder(View itemView) {
            super(itemView);
        }
    }

    private static class LoadingViewHolder extends RecyclerView.ViewHolder {

        LoadingViewHolder(View itemView) {
            super(itemView);
        }
    }

    private static class AdBannerViewHolder extends RecyclerView.ViewHolder {

        ConvenientBanner convenientBanner;

        AdBannerViewHolder(View itemView) {
            super(itemView);
            convenientBanner = (ConvenientBanner) itemView.findViewById(R.id.ad_banner);

            List<String> networkImages = new ArrayList<>();

            networkImages.add("http://img0.178.com/lol/201607/262728096674/262728680833.jpg");
            networkImages.add("http://img2.178.com/lol/201607/262728096674/262728680834.jpg");
            networkImages.add("http://img5.178.com/lol/201607/262728096674/262728680835.jpg");

            convenientBanner.setPages(
                    new CBViewHolderCreator<NetworkImageHolderView>() {
                        @Override
                        public NetworkImageHolderView createHolder() {
                            return new NetworkImageHolderView();
                        }
                    }, networkImages)
                    .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                    .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
        }

    }
}
