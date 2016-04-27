package com.toryang.sampledemo.presenter;

import com.toryang.sampledemo.ui.view.MvpView;

/**
 * Created by toryang on 16/4/27.
 */
public class BasePresenter <T extends MvpView> implements Presenter<T> {

    private T mMvpView;

    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public T getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }


    public static class MvpViewNotAttachedException extends RuntimeException{
        public MvpViewNotAttachedException(){
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
