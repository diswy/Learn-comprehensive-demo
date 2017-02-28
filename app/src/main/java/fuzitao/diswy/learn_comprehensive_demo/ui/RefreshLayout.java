package fuzitao.diswy.learn_comprehensive_demo.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import fuzitao.diswy.learn_comprehensive_demo.R;
import fuzitao.diswy.learn_comprehensive_demo.adapter.RecyclerViewAdapter;

public class RefreshLayout extends BaseActivity {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    boolean isLoading;
    private List<Map<String, Object>> data = new ArrayList<>();
    private RecyclerViewAdapter adapter;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_layout);

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter.setInit(true);
        adapter.setCanLoop(true);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onStop() {
        super.onStop();

        adapter.setCanLoop(false);
        adapter.setInit(true);
        adapter.notifyDataSetChanged();
    }

    private void initData() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("TAG","init data");
                getData();
            }
        }, 2000);
    }

    private void getData() {

        if (data.size() > 50) {
            adapter.setLoading(false);
        } else {
            for (int i = 0; i < 10; i++) {
                data.add(new HashMap<String, Object>());
            }
        }

        adapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    private void initView() {

        // 下拉刷新的颜色序列
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        data.clear();
                        adapter.setLoading(true);
                        getData();
                    }
                }, 2000);
            }
        });

        adapter = new RecyclerViewAdapter(this, data);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                if (lastVisibleItemPosition + 1 == adapter.getItemCount()) {
                    boolean isRefreshing = swipeRefreshLayout.isRefreshing();
                    if (isRefreshing) {
                        adapter.notifyItemRemoved(adapter.getItemCount());
                        return;
                    }
                }

                if (!isLoading) {
                    isLoading = true;
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getData();
                            isLoading = false;
                        }
                    }, 2000);
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 清空所有Message，防止Activity结束后控件空指针异常
         */
        handler.removeCallbacksAndMessages(null);
    }
}
