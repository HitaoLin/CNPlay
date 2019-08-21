package com.example.cnplay.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;

import com.example.cnplay.di.DaggerRecommendComponent;
import com.example.cnplay.di.RecommendModule;
import com.example.cnplay.ui.decoration.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cnplay.R;
import com.example.cnplay.bean.AppInfo;
import com.example.cnplay.presenter.RecommendPresenter;
import com.example.cnplay.presenter.contract.RecommendContract;
import com.example.cnplay.ui.adapter.RecomendAppAdatper;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * <pre>
 *     author:LHT
 *     date:20190813
 *     desc:推荐  Fragment
 * </pre>
 */
public class RecommendFragment extends Fragment implements RecommendContract.View {


    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    Unbinder unbinder;

    private RecomendAppAdatper mAdatper;
    private ProgressDialog mProgressDialog;
    @Inject
    RecommendContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recomend, container, false);
        unbinder = ButterKnife.bind(this, view);

        mProgressDialog = new ProgressDialog(getActivity());
//        mPresenter = new RecommendPresenter(this);

        DaggerRecommendComponent.builder().recommendModule(new RecommendModule(this)).build().inject(this );

        initData();

        return view;
    }

    private void initData() {

        mPresenter.requestDatas();

    }

    private void initRecyclerView(List<AppInfo> datas) {
        //为RecyclerView 设置布局管理器
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //为RecyclerView设置分割线(这个可以对DividerItemDecoration进行修改，自定义)
        recycleView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL_LIST));
        //动画
        recycleView.setItemAnimator(new DefaultItemAnimator());
        mAdatper = new RecomendAppAdatper(getActivity(),datas);
        recycleView.setAdapter(mAdatper);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showResult(List<AppInfo> datas) {
        initRecyclerView(datas);
    }

    @Override
    public void showNodata() {
        Toast.makeText(getActivity(), "暂时无数据，请吃完饭再来", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrow(String msg) {
        Toast.makeText(getActivity(), "服务器开小差了："+msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void dismissLoading() {
        if(mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }
}
